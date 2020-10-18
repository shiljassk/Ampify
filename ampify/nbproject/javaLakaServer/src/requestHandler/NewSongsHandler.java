package requestHandler;

import constants.ResponseCode;
import data.Song;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import request.NewSongsRequest;
import request.Response;
import tools.DBConnection;

public class NewSongsHandler {
    private NewSongsRequest newSongsRequest;
    
    public NewSongsHandler(NewSongsRequest newSongsRequest){
        this.newSongsRequest = newSongsRequest;
    }
    
    public Response getResponse(){
         String query = "SELECT * FROM music ORDER BY date DESC";
         try{
             PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
             ResultSet rs = pdt.executeQuery();
             int i=0;
             ArrayList<Song> songs=new ArrayList<>();
             
             while(rs.next() && i<this.newSongsRequest.getNumberOfSongs()){
                Song song = new Song();
                song.setSID(rs.getInt(1));
                song.setName(rs.getString(3));
                song.setSongName(rs.getString(4));
                song.setLength(rs.getLong(11));
                song.setDownloadLink(rs.getString(12));
                song.setLyricFile(rs.getString(13));
                songs.add(song);
                i++;
             }
             return new Response(songs, ResponseCode.SUCCESSFUL);
         } catch(SQLException e) {}
         return new Response(null, ResponseCode.FAILURE);
    }
}
