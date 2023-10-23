package com.techelevator.model;

import com.techelevator.entity.MealRecipe;
import com.techelevator.entity.RecipeIngredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MealPlanRecipeDTO {

    public MealPlanRecipeDTO(MealRecipe mealRecipe) {
        this.id = mealRecipe.getRecipe().getId();
        this.name = mealRecipe.getRecipe().getName();

        for (RecipeIngredient recipeIngredient : mealRecipe.getRecipe().getRecipeIngredients()) {
            RecipeIngredientDTO recipeIngredientDTO = new RecipeIngredientDTO(recipeIngredient);
            this.recipeIngredients.add(recipeIngredientDTO);
        }
    }

    @NotNull
    private Long id;
    @NotNull
    private String name;

    @NotNull
    private Set<RecipeIngredientDTO> recipeIngredients = new HashSet<>();
}
