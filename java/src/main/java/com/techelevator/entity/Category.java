package com.techelevator.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "recipeCategory", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Recipe> recipeCategory = new HashSet<>();

//    @ManyToMany
//    @JoinTable(
//            name = "recipe_category",
//            joinColumns = @JoinColumn(name = "category_id"),
//            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
//    @JsonIgnore
//    private Set<Recipe> recipeCategory = new HashSet<>();

    public void addRecipe(Recipe recipe) {
        this.recipeCategory.add(recipe);
    }
}
