package request;

import constants.RequestCode;
import java.io.Serializable;

public class SearchSongRequest extends Request implements Serializable{
    private String searchSong;
    
    public void setSearchSong(String searchSong){
        this.searchSong = searchSong;
    }
    
    public String getSearchSong(){
        return searchSong;
    }
    
     @Override
    public RequestCode getRequestCode(){
        return RequestCode.SEARCH_SONG;
    }
}

