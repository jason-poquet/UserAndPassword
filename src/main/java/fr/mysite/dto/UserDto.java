package fr.mysite.dto;

import fr.mysite.entities.User;

/**
 * DTO for the class {@link User}. Extends {@link EntityDto}
 * 
 * @author Jason POQUET
 *
 */
public class UserDto extends EntityDto {
    
   private String name;
   
   private String phone;
   
   private String password;
   
   

   public UserDto() {
    super();
    // TODO Auto-generated constructor stub
}

public UserDto(String name, String phone, String password) {
    this.name = name;
    this.phone = phone;
    this.password = password;
}

public String getName() {
    return name;
   }

   public void setName(String name) {
    this.name = name;
   }

   public String getPhone() {
    return phone;
   }

   public void setPhone(String phone) {
    this.phone = phone;
   }
   
   public String getPassword() {
    return password;
   }

   public void setPassword(String password) {
    this.password = password;
   }
   
   

   
   
}
