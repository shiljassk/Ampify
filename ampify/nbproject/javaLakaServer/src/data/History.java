package data;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

public class History implements Serializable{
    private int sid;
    private String song;
    private Date date;
    private static final long serialVersionUID = 3434334897764765L;
    
    public void setSID(int sid){
        this.sid = sid;
    }
    
    public int getSID(){
        return sid;
    }
    
    public void setSong(String song){
        this.song = song;
    }
    
    public String getSong(){
        return song;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public Date getDate(){
        return date;
    }
}
