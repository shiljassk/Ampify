package requestHandler;

import constants.ResponseCode;
import data.History;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import request.HistoryRequest;
import request.Response;
import tools.DBConnection;

public class HistoryHandler {
    private final HistoryRequest historyRequest;
    
    public HistoryHandler(HistoryRequest historyRequest){
        this.historyRequest = historyRequest;
    }
    
    public Response getResponse(){
        String query = "SELECT * FROM history WHERE username=?";
        try{
            PreparedStatement pdt = DBConnection.connectDB().prepareStatement(query);
            pdt.setString(1,this.historyRequest.getUserName());
            ResultSet rs = pdt.executeQuery();
            ArrayList<History> histories = new ArrayList<>();
            
            while(rs.next()){
                History history = new History();
                history.setSID(rs.getInt(2));
                history.setSong(rs.getString(3));
                history.setDate(rs.getDate(4));
                histories.add(history);
            }
            if(!histories.isEmpty()){
            return new Response(histories, ResponseCode.SUCCESSFUL);
            }
        } catch(SQLException e) {}
        return new Response(null, ResponseCode.FAILURE);
    }
}
