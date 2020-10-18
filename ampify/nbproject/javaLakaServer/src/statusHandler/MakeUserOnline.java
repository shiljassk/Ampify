package statusHandler;

import data.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tools.DBConnection;

public class MakeUserOnline {
    private final User user;
    
    public MakeUserOnline(User user){
        this.user = user;
        
        new Thread(new Runnable() {
            @Override
            public void run(){
                String query = "INSERT INTO onlineusers(username, name) VALUES(?,?)";
                try{
                    PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
                    pdt.setString(1, MakeUserOnline.this.user.getUserName());
                    pdt.setString(2,MakeUserOnline.this.user.getName());
                    pdt.executeUpdate();
                } catch(SQLException e) {}
            }
        }).start();
    }
}
