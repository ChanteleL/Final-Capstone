package com.techelevator.entity;

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
public class MealPlan {

    @Id
    @Column(name = "mealplan_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Title should not be null")
    private String title;

    @ManyToOne
    @JoinColumn(name = "appuser_id", referencedColumnName = "appuser_id")
    private AppUser appUser;

    @OneToMany(mappedBy = "mealPlan", cascade = CascadeType.ALL)
    private Set<Day> days = new HashSet<>();

    @Override
    public String toString() {
        return "MealPlan{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealPlan mealPlan = (MealPlan) o;
        return id.equals(mealPlan.id) && title.equals(mealPlan.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
