package com.techelevator.entity;

import com.techelevator.model.RecipePayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    @Id
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    // add not null
    @ManyToOne
    @JoinColumn(name = "appuser_id", referencedColumnName = "appuser_id")
    private AppUser appUser;

    // add not null
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Step> steps = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<MealRecipe> mealRecipes = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> recipeCategory = new HashSet<>();

//    @ManyToMany(mappedBy = "recipeCategory", fetch = FetchType.EAGER)
//    private Set<Category> recipeCategory = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="recipes_liked",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "appuser_id")
    )
    Set<AppUser> recipesLiked = new HashSet<>();

    public void addUserToLiked(AppUser appUser) {
        recipesLiked.add(appUser);
    }

    public void addRecipePayload(RecipePayload recipePayload) {
        this.name = recipePayload.getName();
        this.description = recipePayload.getDescription();
        this.cookTime = recipePayload.getCookTime();
        this.prepTime = recipePayload.getPrepTime();
        this.servings = recipePayload.getServings();
        this.imgId = recipePayload.getImgId();
    }

    public void removeCategory(Category category) {
        this.getRecipeCategory().remove(category);
        category.getRecipeCategory().remove(this);
    }

    public void removeCategories() {
        for (Category category : new HashSet<>(recipeCategory)){
            removeCategory(category);
        }
    }

    public void removeLike(AppUser appUser) {
        this.getRecipesLiked().remove(appUser);
        appUser.getRecipesLiked().remove(this);
    }

    public void removeLikes() {
        for (AppUser appUser : new HashSet<>(recipesLiked)) {
            removeLike(appUser);
        }
    }

    public void removeStep(Step step) {
        this.getSteps().remove(step);
    }

    public void removeSteps() {
        for (Step step : new HashSet<>(steps)) {
            removeStep(step);
        }
    }

    public void removeRecipeIngredient(RecipeIngredient recipeIngredient) {
        this.getRecipeIngredients().remove(recipeIngredient);
    }

    public void removeRecipeIngredients() {
        for (RecipeIngredient recipeIngredient : new HashSet<>(recipeIngredients)) {
            removeRecipeIngredient(recipeIngredient);
        }
    }

    public void removeAppUser() {
        this.appUser = null;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", servings=" + servings +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", imgUrl='" + imgId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return servings == recipe.servings && prepTime == recipe.prepTime && cookTime == recipe.cookTime && Objects.equals(id, recipe.id) && Objects.equals(name, recipe.name) && Objects.equals(description, recipe.description) && Objects.equals(imgId, recipe.imgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, servings, prepTime, cookTime, imgId);
    }
}
