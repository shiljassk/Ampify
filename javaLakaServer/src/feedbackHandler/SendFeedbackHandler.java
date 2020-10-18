package feedbackHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import request.SendFeedbackRequest;
import tools.DBConnection;

public class SendFeedbackHandler {
    private final SendFeedbackRequest sendFeedbackRequest;
    
    public SendFeedbackHandler(SendFeedbackRequest sendFeedbackRequest){
        this.sendFeedbackRequest = sendFeedbackRequest;
        
        new Thread(new Runnable() {
            @Override
            public void run(){
                String query = "SELECT * FROM feedback WHERE username=? AND sid=?";
                try{
                    PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
                    pdt.setString(1,SendFeedbackHandler.this.sendFeedbackRequest.getUserName());
                    pdt.setInt(2,SendFeedbackHandler.this.sendFeedbackRequest.getSID());
                    ResultSet rs = pdt.executeQuery();
                    
                    if(rs.next()){
                        pdt.close();
                        query = "UPDATE feedback SET feedback=? WHERE username=? AND sid=?";
                        pdt = DBConnection.connectDB().prepareStatement(query);
                        pdt.setString(1,String.valueOf(SendFeedbackHandler.this.sendFeedbackRequest.getFeedbackCode()));
                        pdt.setString(2,SendFeedbackHandler.this.sendFeedbackRequest.getUserName());
                        pdt.setInt(2,SendFeedbackHandler.this.sendFeedbackRequest.getSID());
                        pdt.executeQuery();
                        pdt.close();
                    }
                    else{
                        pdt.close();
                        query = "INSERT INTO feedback (username, sid, feedback) VALUES(?,?,?)";
                        pdt = DBConnection.connectDB().prepareStatement(query);
                        pdt.setString(3,String.valueOf(SendFeedbackHandler.this.sendFeedbackRequest.getFeedbackCode()));
                        pdt.setString(1,SendFeedbackHandler.this.sendFeedbackRequest.getUserName());
                        pdt.setInt(2,SendFeedbackHandler.this.sendFeedbackRequest.getSID());
                        pdt.executeQuery();
                        pdt.close();
                    }
                } catch(SQLException e) {}
            }
        }).start();
    }
}
