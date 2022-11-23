package fr.mysite.dto;
/**
 * Dto to display the errors
 * @author Jason POQUET
 *
 */
public class ApiErrorDto {
    
    /**
     * the error code
     */
    private int errorCode;
    
    /**
     *  the message of the error
     */
    private String message;
    
    /**
     * the path
     */
    private String path;
    
    
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

}
