package com.techelevator.repo;

import com.techelevator.entity.MealRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRecipeRepo extends JpaRepository<MealRecipe, Long> {

}
