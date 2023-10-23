package com.techelevator.model;

import javax.validation.constraints.NotNull;

/**
 * DTO for storing a user's credentials.
 */
public class LoginDTO {

   @NotNull
   private String username;
   @NotNull
   private String password;

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "LoginDTO{" +
              "username='" + username + '\'' +
              ", password='" + password + '\'' +
              '}';
   }
}
