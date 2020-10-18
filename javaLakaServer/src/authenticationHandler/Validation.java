package authenticationHandler;

import constants.ResponseCode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import request.Response;
import request.ValidityRequest;
import tools.DBConnection;


public class Validation {
    private ValidityRequest validityRequest;
    private Response response;
    
    public Validation(ValidityRequest validityRequest){
        this.validityRequest = validityRequest;
    }
    
    public Response getResponse(){
        String query = "SELECT * FROM user WHERE username=?  OR email=?";
        try{
            PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
            pdt.setString(1, validityRequest.getUserName());
            pdt.setString(2, validityRequest.getEmail());
            ResultSet rs = pdt.executeQuery();
            
            if(rs.next()){
                return this.response = new Response(null, ResponseCode.FAILURE);
            }
              return this.response = new Response(null, ResponseCode.SUCCESSFUL);
        }catch(SQLException e){}
          return this.response = new Response(null, ResponseCode.FAILURE);
    }
}
