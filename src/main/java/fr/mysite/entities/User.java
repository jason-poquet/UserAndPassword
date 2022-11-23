package fr.mysite.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
/**
 * 
 * @author Jason POQUET
 *
 */
@Entity
public class User extends MyEntity {
    
    /**
     * the user name
     */
    @Column
    private String name;
    
    /**
     * the user phone
     */
    @Column
    private String phone;
    
    /**
     * the user password
     */
    @Column
    private String password;
    
    

    public User() {
    }
    
    
    
    public User(String name, String phone, String password) {
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
