package requestHandler;

import constants.ResponseCode;
import data.PlaylistName;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import request.CreatePlaylistRequest;
import request.Response;
import tools.DBConnection;

public class CreatePlaylistHandler {
    private final CreatePlaylistRequest createPlaylistRequest;
    
    public CreatePlaylistHandler(CreatePlaylistRequest createPlaylistRequest){
        this.createPlaylistRequest = createPlaylistRequest;
    }
    
    public Response getResponse(){
        String query = "INSERT INTO playlist(username, pname) VALUES(?,?)";
        try{
            PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
            pdt.setString(1,this.createPlaylistRequest.getUserName());
            pdt.setString(2,this.createPlaylistRequest.getPname());
            ResultSet rs = pdt.executeQuery();
            if(rs.next()){
                PlaylistName playlistName = new PlaylistName();
                playlistName.setPID(rs.getInt(1));
                playlistName.setPname(rs.getString(3));
                return new Response(playlistName, ResponseCode.SUCCESSFUL);
            }
        } catch(SQLException e) {}
        return new Response(null, ResponseCode.FAILURE);
    }
}
