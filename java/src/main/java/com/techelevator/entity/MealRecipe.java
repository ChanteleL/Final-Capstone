package com.techelevator.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealRecipe {

    @Id
    @Column(name = "meal_recipe_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private int servings;

    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "meal_id")
    @JsonIgnore
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private Recipe recipe;
}
