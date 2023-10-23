package com.techelevator.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Long.class)
public class Step {

    @Id
    @Column(name = "step_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String info;

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    @JsonIgnore
    private Recipe recipe;

}
