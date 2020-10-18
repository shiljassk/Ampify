package request;

import constants.FeedbackCode;
import constants.RequestCode;
import java.io.Serializable;

public class SendFeedbackRequest extends Request implements Serializable{
    private String userName;
    private int sid;
    private FeedbackCode feedbackCode;
    
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
    
    public void setFeedbackCode(FeedbackCode feedbackCode){
        this.feedbackCode = feedbackCode;
    }
    
    public FeedbackCode getFeedbackCode(){
        return feedbackCode;
    }
    
    @Override
    public RequestCode getRequestCode(){
        return RequestCode.SEND_FEEDBACK;
    }
}
