package com.techelevator.controller;

import com.techelevator.model.RecipePayload;
import com.techelevator.model.RecipeResponse;
import com.techelevator.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/{id}")
    public RecipeResponse getRecipeById(Principal principal, @PathVariable Long id) {
        return recipeService.getRecipeById(principal.getName(), id);
    }

    @PostMapping("/add")
    public RecipeResponse addRecipe(@RequestBody RecipePayload recipePayload, Principal principal) {
        return recipeService.addRecipe(principal.getName(), recipePayload);
    }

    @GetMapping("/all")
    public List<RecipeResponse> getAllRecipes(Principal principal) {
        return recipeService.getAllRecipes(principal.getName());
    }

    @PutMapping("/like/{recipeId}/{isLiked}")
    public boolean likeRecipeForUser(Principal principal, @PathVariable Long recipeId, @PathVariable Boolean isLiked) {
        return recipeService.likeRecipeForUser(principal.getName(), recipeId, isLiked);
    }

    @PutMapping("/{id}")
    public RecipeResponse updateRecipe(Principal principal, @PathVariable Long id, @RequestBody RecipePayload recipePayload) throws IllegalAccessException {
        System.out.println("user accessing controller is " + principal.getName());
        return recipeService.updateRecipe(principal.getName(), id, recipePayload);
    }

    @GetMapping("/myRecipes")
    public List<RecipeResponse> getMyRecipes(Principal principal) {
        return recipeService.getMyRecipes(principal.getName());
    }

    @DeleteMapping("/{recipeId}")
    public Boolean deleteRecipe(Principal principal, @PathVariable Long recipeId) throws IllegalAccessException {
        return recipeService.deleteRecipe(principal.getName(), recipeId);
    }
}
