package com.techelevator.model;

import com.techelevator.entity.RecipeIngredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeIngredientDTO {

    public RecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        this.name = recipeIngredient.getIngredient().getName();
        this.quantity = recipeIngredient.getQuantity();
        this.isLiquid = recipeIngredient.getIngredient().isLiquid();
    }

    private String name;
    private int quantity;
    private boolean isLiquid;
}
