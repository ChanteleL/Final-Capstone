package com.techelevator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipePayload {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private int servings;
    @NotNull
    private int prepTime;
    @NotNull
    private int cookTime;
    private String imgId;
    @NotNull
    private List<String> recipeCategories;
    @NotNull
    private List<RecipeIngredientDTO> recipeIngredients;
    @NotNull
    private List<String> steps;
    @NotNull
    private boolean liked;
}
