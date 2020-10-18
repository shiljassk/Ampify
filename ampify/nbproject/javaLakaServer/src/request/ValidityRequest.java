package request;

import constants.RequestCode;
import java.io.Serializable;


public class ValidityRequest extends Request implements Serializable{
    private String userName;
    private String email;
    
    public ValidityRequest(String userName, String email){
        this.userName = userName;
        this.email = email;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    @Override
    public RequestCode getRequestCode(){
        return RequestCode.USER_EMAIL_VALIDATION;
    }
}
