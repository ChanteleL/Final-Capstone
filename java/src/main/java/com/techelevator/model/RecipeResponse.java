package com.techelevator.model;

import com.techelevator.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeResponse {

    public RecipeResponse(Recipe recipe, Long userId) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        this.description = recipe.getDescription();
        this.servings = recipe.getServings();
        this.prepTime = recipe.getPrepTime();
        this.cookTime = recipe.getCookTime();
        this.creatorId = recipe.getAppUser().getId();
        this.creatorUsername = recipe.getAppUser().getUsername();

        if(!Objects.isNull(recipe.getImgId())) {
            this.imgId = recipe.getImgId();
        }

        for(Step step : recipe.getSteps()) {
            this.steps.add(step.getInfo());
        }

        for(RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
            RecipeIngredientDTO recipeIngredientDTO = new RecipeIngredientDTO(recipeIngredient);
            this.recipeIngredients.add(recipeIngredientDTO);
        }

        for (Category category : recipe.getRecipeCategory()) {
            this.recipeCategories.add(category.getName());
        }

        for (AppUser appUser : recipe.getRecipesLiked()){
            if (userId == appUser.getId()) {
                this.isLiked = true;
                break;
            }
        }

    }

    private Long id;
    private String name;
    private String description;
    private int servings;
    private int prepTime;
    private int cookTime;
    private String imgId = "";
    private Long creatorId;

    private String creatorUsername;
    private List<String> steps = new ArrayList<>();
    private List<RecipeIngredientDTO> recipeIngredients = new ArrayList<>();
    private List<String> recipeCategories = new ArrayList<>();
    private boolean isLiked = false;
}
