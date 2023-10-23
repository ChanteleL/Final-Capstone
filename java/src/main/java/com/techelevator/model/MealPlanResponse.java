package com.techelevator.model;

import com.techelevator.entity.Day;
import com.techelevator.entity.MealPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealPlanResponse {

    public MealPlanResponse(MealPlan mealPlan) {
        this.id = mealPlan.getId();
        this.title = mealPlan.getTitle();
        this.creatorId = mealPlan.getAppUser().getId();

        for (Day day : mealPlan.getDays()) {
            DayDTO newDayDTO = new DayDTO(day);
            this.days.add(newDayDTO);
        }
    }

    private Long id;
    private Long creatorId;
    private String title;
    private List<DayDTO> days = new ArrayList<>();
}
