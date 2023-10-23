package com.techelevator.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.techelevator.entity.AppUser;
import com.techelevator.model.PasswordChangeDTO;
import com.techelevator.service.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class AppUserController {
    @Autowired
    private final AppUserService appUserService;

    @Value("${CLOUDSECRET}")
    private String cloudsecret;

    private AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    @RequestMapping("/users")
    public List<AppUser> getUsers() {
        return appUserService.getUsers();
    }

    @PutMapping
    @RequestMapping("/changepassword")
    public boolean changePassword(Principal principal, @RequestBody PasswordChangeDTO passwordChangeDTO) {
        return appUserService.changePassword(principal.getName(), passwordChangeDTO);
    }

    @GetMapping("/verifyUser")
    public AppUser getUserByToken(Principal principal) {
        return appUserService.getUser(principal.getName());
    }

    @GetMapping("/get-signature")
    public Map<String, String> getCloudinarySignature() {

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "djoe",
                "api_key", "362171829159456",
                "api_secret", cloudsecret,
                "secure", true
        ));

        Long timestamp =  new Date().getTime() / 1000;
        String timestampString = timestamp.toString();

        String apiSecret = cloudsecret;

        Map<String, Object> paramsToSign = new HashMap<>();
        paramsToSign.put("timestamp", timestampString);
        paramsToSign.put("folder", "MealPlanner");

        String signature = cloudinary.apiSignRequest(paramsToSign, apiSecret);

        Map<String, String> response = new HashMap<>();
        response.put("timestamp", timestampString);
        response.put("signature", signature);

        return response;
    }

    @DeleteMapping("/user/delete/{username}")
    public boolean deleteUser(@PathVariable String username) {
        return appUserService.deleteUser(username);
    }
}
