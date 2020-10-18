package requestHandler;

import constants.ResponseCode;
import data.Song;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import request.RecommendationRequest;
import request.Response;
import tools.DBConnection;

public class RecommendationHandler {
    private RecommendationRequest recommendationRequest;
    
    public RecommendationHandler(RecommendationRequest recommendationRequest){
        this.recommendationRequest = recommendationRequest;
    }
    
    public Response getResponse(){
        String query = "SELECT * FROM music WHERE genre LIKE '" + this.recommendationRequest.getGenre() + "%' AND language LIKE '"
                + this.recommendationRequest.getLanguage() +"'";
               
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
             if(!songs.isEmpty()){
                 return new Response(songs, ResponseCode.SUCCESSFUL);
             }
        } catch(SQLException e) {}
        return new Response(null, ResponseCode.FAILURE);
    }
}
