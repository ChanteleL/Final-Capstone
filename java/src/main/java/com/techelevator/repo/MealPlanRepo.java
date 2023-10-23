package com.techelevator.repo;

import com.techelevator.entity.AppUser;
import com.techelevator.entity.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealPlanRepo extends JpaRepository<MealPlan, Long> {

//    MealPlan findMealPlanByTitle(Long userId, String title); //Useful if we impl a search feature
    List<MealPlan> findByAppUser(AppUser appUser);

}
