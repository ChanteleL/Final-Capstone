package com.techelevator.model;

import com.techelevator.entity.Meal;
import com.techelevator.entity.MealRecipe;
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
public class MealDTO {

    public MealDTO(Meal meal) {
        this.title = meal.getTitle();
        for (MealRecipe mealRecipe : meal.getMealRecipes()) {
            MealRecipeDTO mealRecipeDTO = new MealRecipeDTO(mealRecipe);
            this.mealRecipes.add(mealRecipeDTO);
        }
    }

    @NotNull
    private String title;
    @NotNull
    private Set<MealRecipeDTO> mealRecipes = new HashSet<>();
}
