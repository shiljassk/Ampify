package request;

import constants.RequestCode;
import java.io.Serializable;

public class CreateGroupRequest  extends Request implements Serializable{
     private String gname;
     
     public void setGroupName(String gname){
         this.gname = gname;
     }
     
     public String getGroupName(){
         return gname;
     }
     
     @Override
    public RequestCode getRequestCode(){
        return RequestCode.CREATE_GROUP;
    }
}
