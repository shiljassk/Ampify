package requestHandler;

import constants.ResponseCode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import request.AddSongToPlaylistRequest;
import request.Response;
import tools.DBConnection;

public class AddSongToPlaylist {
    private final AddSongToPlaylistRequest addSongToPlaylistRequest;
    
    public AddSongToPlaylist(AddSongToPlaylistRequest addSongToPlaylistRequest){
        this.addSongToPlaylistRequest = addSongToPlaylistRequest;
    }
    
    public Response getResponse(){
        String query = "INSERT INTO playlist_music(pid, sid) VALUES(?,?)";
        try{
            PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
            pdt.setInt(1,this.addSongToPlaylistRequest.getPID());
            pdt.setInt(2,this.addSongToPlaylistRequest.getSID());
            ResultSet rs = pdt.executeQuery();
            if(rs.next()){
                return new Response(null, ResponseCode.SUCCESSFUL);
            }
        } catch (SQLException e) {}
        return new Response(null, ResponseCode.FAILURE);
    }
}
