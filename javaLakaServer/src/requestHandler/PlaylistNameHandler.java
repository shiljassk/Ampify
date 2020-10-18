package requestHandler;

import constants.ResponseCode;
import data.PlaylistName;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import request.GetPlaylistRequest;
import request.Response;
import tools.DBConnection;

public class PlaylistNameHandler {
    private final GetPlaylistRequest getPlaylistRequest;
    
    public PlaylistNameHandler(GetPlaylistRequest getPlaylistRequest){
        this.getPlaylistRequest = getPlaylistRequest;
    }
    
    public Response getResponse(){
        String query = "SELECT * FROM playlist WHERE username=?";
        try{
            PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
            pdt.setString(1,this.getPlaylistRequest.getUserName());
            ResultSet rs = pdt.executeQuery();
            ArrayList<PlaylistName> playlistNames = new ArrayList<>();
            
            while(rs.next()){
                PlaylistName playlistName = new PlaylistName();
                playlistName.setPID(rs.getInt(1));
                playlistName.setPname(rs.getString(3));
                playlistNames.add(playlistName);
            }
            return new Response(playlistNames, ResponseCode.SUCCESSFUL);
        } catch(SQLException e) {}
        return new Response(null, ResponseCode.FAILURE);
    }
}
