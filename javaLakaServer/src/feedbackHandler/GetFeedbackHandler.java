package feedbackHandler;

import constants.FeedbackCode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import request.GetFeedbackRequest;
import tools.DBConnection;

public class GetFeedbackHandler {
    private final GetFeedbackRequest getFeedbackRequest;
    
    public GetFeedbackHandler(GetFeedbackRequest getFeedbackRequest){
        this.getFeedbackRequest = getFeedbackRequest;
    }
    
    public FeedbackResponse getFeedbackResponse(){
        String query = "SELECT * FROM feedback WHERE username=? AND sid=?";
        try{            
                PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
                pdt.setString(1,GetFeedbackHandler.this.getFeedbackRequest.getUserName());
                pdt.setInt(2,GetFeedbackHandler.this.getFeedbackRequest.getSID());
                ResultSet rs = pdt.executeQuery();
                
                if(rs.next()){
                    return new FeedbackResponse(null, FeedbackCode.valueOf(rs.getString(3)));
                }
        } catch (SQLException e) {}
        return new FeedbackResponse(null, FeedbackCode.NONE);
    }
}
