package com.techelevator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RegisterUserDTO {

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,15}$", message="Username not valid")
    private String username;
    @NotEmpty
    @Pattern(regexp = "^(?=.*?[a-zA-Z])(?=.*?[0-9]).{8,18}$", message="Password not valid")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
