package com.techelevator.repo;

import com.techelevator.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
    Ingredient findByName(String name);
}
