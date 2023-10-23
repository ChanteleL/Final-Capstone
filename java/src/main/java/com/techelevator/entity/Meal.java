package com.techelevator.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal {

    @Id
    @Column(name = "meal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Title should not be null")
    private String title;

    @ManyToOne
    @JoinColumn(name = "day_id", referencedColumnName = "day_id")
    @JsonIgnore
    private Day day;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    private Set<MealRecipe> mealRecipes = new HashSet<>();

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return id.equals(meal.id) && title.equals(meal.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
