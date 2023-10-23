package com.techelevator.repo;

import com.techelevator.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, Long> {
    RecipeIngredient findByRecipeId(Long id);
}
