package requestHandler;

import constants.ResponseCode;
import data.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import request.Response;
import request.UserSearchRequest;
import tools.DBConnection;

public class UserSearchHandler {
    private final UserSearchRequest userSearchRequest;
    
    public UserSearchHandler(UserSearchRequest userSearchRequest){
        this.userSearchRequest = userSearchRequest;
    }
    
    public Response getResponse(){
        String query = "SELECT * FROM user WHERE LOWER(name) LIKE '" + userSearchRequest.getSearchString().toLowerCase() +"%' "
                + "OR username LIKE '" + userSearchRequest.getSearchString().toLowerCase() + "%'"; //dont lower username
        try{
         PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
         ResultSet rs = pdt.executeQuery();            
         ArrayList<User> users=new ArrayList<>();    
         
         while(rs.next()){
                User user = new User();
                user.setUserName(rs.getString(2));
                user.setName(rs.getString(1));
                user.setGenre(null);
                user.setLanguage(null);
                // no need to return genre and language
                users.add(user);
             }
         if(!users.isEmpty()){
                return new Response(users, ResponseCode.SUCCESSFUL);
                 }
        } catch(SQLException e) {}
        return new Response(null, ResponseCode.FAILURE);
    }
}
