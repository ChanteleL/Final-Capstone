package com.techelevator.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="app_user")
public class AppUser {

   @Id
   @Column(name = "appuser_id")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @NotNull(message = "Username should not be null")
   @Pattern(regexp = "^[a-zA-Z0-9_-]{4,15}$", message="Username not valid")
   private String username;
   @JsonIgnore
   @NotNull
   private String password;
   @JsonIgnore
   private boolean activated;

   @ManyToMany(mappedBy = "appUserRoles", fetch = FetchType.EAGER)
   private Set<Role> appUserRoles = new HashSet<>();

   @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
   @JsonIgnore
   private Set<Recipe> recipes = new HashSet<>();

   @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
   @JsonIgnore
   private Set<MealPlan> mealPlans = new HashSet<>();

   @ManyToMany(mappedBy = "recipesLiked")
   @JsonIgnore
   private Set<Recipe> recipesLiked = new HashSet<>();

   @Override
   public String toString() {
      return "AppUser{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", password='" + password + '\'' +
              ", activated=" + activated +
              ", roles=" + appUserRoles +
              '}';
   }

   public void removeRole(Role role) {
      this.getAppUserRoles().remove(role);
      role.getAppUserRoles().remove(this);
   }

   public void removeRoles() {
      for (Role role : new HashSet<>(appUserRoles)) {
         removeRole(role);
      }
   }
}
