package com.techelevator.controller;

import com.techelevator.entity.Ingredient;
import com.techelevator.exception.ApiException;
import com.techelevator.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("/{id}")
    public Optional<Ingredient> getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }

    @GetMapping("/{name}")
    public Ingredient getIngredientByName(@PathVariable String name) throws ApiException {
        return ingredientService.getIngredientByName(name);
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) throws ApiException {
        return ingredientService.addIngredient(ingredient);
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteIngredient(@PathVariable Long id) {return ingredientService.deleteIngredient(id);}
}
