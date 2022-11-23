package fr.mysite.dto;

/**
 *  Compliance Dto
 * @author Jason POQUET
 *
 */
public class ComplianceDto extends EntityDto {
    
    /**
     * boolean to see if the password is valid
     */
    private boolean isValid;
    
    
   /**
    * the reasons
    */
    private String reason;
    
    

    
    public ComplianceDto() {
    super();
    // TODO Auto-generated constructor stub
}

    public ComplianceDto(boolean isValid, String reason) {
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
