package com.techelevator.model;

import com.techelevator.entity.Day;
import com.techelevator.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DayDTO {

    public DayDTO(Day day) {
        for (Meal meal : day.getMeals()) {
            MealDTO newMealDTO = new MealDTO(meal);
            this.meals.add(newMealDTO);
        }
    }

    @NotNull
    private List<MealDTO> meals = new ArrayList<>();
}
