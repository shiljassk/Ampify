package requestHandler;

import constants.ResponseCode;
import data.Song;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import request.Response;
import tools.DBConnection;


public class SongListHandler {
    private Response response;
    
    public Response getResponse(){
        String query = "SELECT * FROM music";
        try{
            PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
            ResultSet rs = pdt.executeQuery();
            ArrayList<Song> songs=new ArrayList<>();
            
            while(rs.next()){
                Song song = new Song();
                song.setSID(rs.getInt(1));
                song.setName(rs.getString(3));
                song.setSongName(rs.getString(4));
                song.setLength(rs.getLong(11));
                song.setDownloadLink(rs.getString(12));
                song.setLyricFile(rs.getString(13));
                songs.add(song);
            }
            return new Response(songs, ResponseCode.SUCCESSFUL);
        }catch(SQLException e){}
        return new Response(null, ResponseCode.FAILURE);
    }
}
