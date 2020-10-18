package request;

import constants.RequestCode;
import java.io.Serializable;

public class GetFeedbackRequest extends Request implements Serializable{
    private String userName;
    private int sid;
    
    public void setSID(int sid){
        this.sid = sid;
    }
    
    public int getSID(){
        return sid;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Override
    public RequestCode getRequestCode(){
        return RequestCode.GET_FEEDBACK;
    }
}
