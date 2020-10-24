package request;

import constants.RequestCode;
import java.io.Serializable;
import java.util.ArrayList;

public class CreateGroupRequest  extends Request implements Serializable{
     private String gname;
     private ArrayList<String> members;

    public CreateGroupRequest(String gname ,ArrayList members) {
        
        this.gname=gname;
        this.members=members;
        
    }
     
     
     
     public String getGroupName(){
         return gname;
     }
     
     public ArrayList getMembers(){
         return members;
     }
     
     @Override
    public RequestCode getRequestCode(){
        return RequestCode.CREATE_GROUP;
    }
}
