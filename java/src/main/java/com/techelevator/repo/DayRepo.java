package com.techelevator.repo;

import com.techelevator.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayRepo extends JpaRepository<Day, Long> {
    List<Day> findByMealPlanId(Long id);

}
