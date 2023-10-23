package com.techelevator.repo;

import com.techelevator.entity.AppUser;
import com.techelevator.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    Recipe findByName (String name);
    List<Recipe> findByAppUser(AppUser appuser);

    @Query(value = "DELETE FROM recipe WHERE recipe_id = ?1", nativeQuery = true)
    void removeRecipe (Long recipeId);
}
