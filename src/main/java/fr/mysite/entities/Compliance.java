package fr.mysite.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
/**
 * Compliance entity
 * @author Jason POQUET
 *
 */
@Entity
public class Compliance extends MyEntity {
    
    /**
     * boolean for the validation of the user password
     */
    @Column
    private boolean isValid;
    
    /**
     * the reasons why the user password is invalid
     */
    @Column
    private String reason;
    
    

    public Compliance() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Compliance(boolean isValid, String reason) {
        this.isValid = isValid;
        this.reason = reason;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
}
