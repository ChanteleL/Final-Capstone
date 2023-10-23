package com.techelevator.repo;

import com.techelevator.entity.AppUser;
import com.techelevator.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepo extends JpaRepository<Meal, Long> {
//    List<Meal> findByAppUser(AppUser appUser);
}
