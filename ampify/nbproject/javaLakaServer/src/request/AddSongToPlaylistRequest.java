package request;

import constants.RequestCode;
import java.io.Serializable;

public class AddSongToPlaylistRequest extends Request implements Serializable{
    private int sid;
    private int pid;
    
    public void setSID(int sid){
        this.sid = sid;
    }
    
    public int getSID(){
        return sid;
    }
    
    public void setPID(int pid){
        this.pid = pid;
    }
    
    public int getPID(){
        return pid;
    }
    
    @Override
    public RequestCode getRequestCode(){
        return RequestCode.ADD_SONG_TO_PLAYLIST;
    }
}
