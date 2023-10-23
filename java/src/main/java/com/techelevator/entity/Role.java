package com.techelevator.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Long.class)
public class Role {

   @Id
   @Column(name = "role_id")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
           name = "appuser_roles",
           joinColumns = @JoinColumn(name = "role_id"),
           inverseJoinColumns = @JoinColumn(name = "appuser_id"))
   @JsonIgnore
   private Set<AppUser> appUserRoles = new HashSet<>();

   @Override
   public String toString() {
      return "Role{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Role role = (Role) o;
      return Objects.equals(id, role.id) && Objects.equals(name, role.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name);
   }
}
