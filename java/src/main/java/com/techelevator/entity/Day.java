package com.techelevator.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Day {

    @Id
    @Column(name = "day_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mealplan_id", referencedColumnName = "mealplan_id")
    @JsonIgnore
    private MealPlan mealPlan;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private Set<Meal> meals = new HashSet<>();

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return id.equals(day.id) && Objects.equals(mealPlan, day.mealPlan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mealPlan);
    }
}
