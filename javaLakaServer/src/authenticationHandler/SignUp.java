package authenticationHandler;

import constants.ResponseCode;
import data.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import request.Response;
import request.SignUpRequest;
import tools.DBConnection;

public class SignUp{
    private final SignUpRequest signUpRequest;
    private Response response;
    
    public SignUp(SignUpRequest signUpRequest){
        this.signUpRequest = signUpRequest;
    }
    
    public Response getResponse(){
        String query = "INSERT INTO user(name, username, email, password, genre, language) VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
            pdt.setString(1,this.signUpRequest.getName());
            pdt.setString(2, this.signUpRequest.getUserName());
            pdt.setString(3,this.signUpRequest.getEmail());
            pdt.setString(4,this.signUpRequest.getPassword());
            pdt.setString(5, this.signUpRequest.getGenre());
            pdt.setString(6, this.signUpRequest.getLanguage());
            
            if(pdt.executeUpdate()>0){
                User user = new User();
                user.setUserName(this.signUpRequest.getUserName());
                user.setName(this.signUpRequest.getName());
                user.setGenre(this.signUpRequest.getGenre());
                user.setLanguage(this.signUpRequest.getLanguage());
                return this.response = new Response(user, ResponseCode.SUCCESSFUL);
            }
            else{
                return this.response = new Response(null, ResponseCode.FAILURE);
            }
        } catch(SQLException e){}
        return this.response = new Response(null, ResponseCode.FAILURE);
    }
}
