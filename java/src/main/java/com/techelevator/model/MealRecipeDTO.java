package com.techelevator.model;

import com.techelevator.entity.MealRecipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MealRecipeDTO {

    public MealRecipeDTO(MealRecipe mealRecipe) {
        this.servings = mealRecipe.getServings();
        MealPlanRecipeDTO mealPlanRecipeDTO = new MealPlanRecipeDTO(mealRecipe);
        this.recipe = mealPlanRecipeDTO;
    }

    @NotNull
    private int servings;
    @NotNull
    private MealPlanRecipeDTO recipe;
}
