/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author rishi
 */
public class Music implements Serializable,Cloneable {
    private String MID;
    private String name;
    private String artist;
    private String genre;
    private String downloadlink;
    private String lyricfile;
    private Integer likes=0;
    private Integer dislikes=0;
    
    public String getMID(){return MID;}
    public void setMID(String MID){this.MID=MID;}
    
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    
    public String getArtist(){return artist;}
    public void setArtist(String artist){this.artist=artist;}
    
    public String getGenre(){return genre;}
    public void setGenre(String genre){this.genre=genre;}
    
    public String getDownloadLink(){return downloadlink;}
    public void setDownloadLink(String downloadlink){this.downloadlink=downloadlink;}
    
    public String getLyricFile(){return lyricfile;}
    public void setLyricFile(String lyricfile){this.lyricfile=lyricfile;}
    
    public Integer getLikes() {return likes;}
    public void setLikes(Integer likes){this.likes =likes;}
    
    public Integer getDisikes() {return dislikes;}
    public void setDislikes(Integer dislikes){this.dislikes =dislikes;}
    
     public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
     @Override
    public String toString() {
        return this.getName();
    }
        
    }
            
    
    
    
    
    
    

