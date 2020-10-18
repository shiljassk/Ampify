package statusHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import request.LogOutRequest;
import tools.DBConnection;

public class MakeUserOffline {
    private LogOutRequest logOutRequest;
    
    public MakeUserOffline(LogOutRequest logOutRequest){
        this.logOutRequest = logOutRequest;
        
        new Thread(new Runnable(){
            @Override
            public void run(){
                String query = "DELETE FROM onlineusers WHERE username=?";
                try{
                    PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
                    pdt.setString(1, MakeUserOffline.this.logOutRequest.getUserName());
                    pdt.executeUpdate();
                } catch(SQLException e) {}
        }
    }).start();
}
}
