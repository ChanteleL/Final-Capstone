package com.techelevator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealPlanPayload {
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private List<DayDTO> days;
}
