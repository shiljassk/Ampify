package request;

import constants.RequestCode;
import java.io.Serializable;

public class CreatePlaylistRequest extends Request implements Serializable{
    private String userName;
    private String pname;
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setPname(String pname){
        this.pname = pname;
    }
    
    public String getPname(){
        return pname;
    }
    
    @Override
    public RequestCode getRequestCode(){
        return RequestCode.CREATE_PLAYLIST;
    }
}
