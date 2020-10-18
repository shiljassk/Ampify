package request;

import constants.RequestCode;
import java.io.Serializable;

public class SongRequest extends Request implements Serializable{
    private int sid;
    
    public void setSID(int sid){
        this.sid = sid;
    }
    
    public int getSID(){
        return sid;
    }
    
    @Override
    public RequestCode getRequestCode(){
        return RequestCode.GET_SONG;
    }
}
