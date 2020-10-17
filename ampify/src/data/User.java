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
public class User implements Serializable,Cloneable {
    private String name;
    private String email;
    private String UID;
    private String genre;
    private String language;
    private String URL;
    
    public String getName(){ return name;}
    public void setName(String name){this.name=name;}
    
    public String getEmail(){ return email;}
    public void setEmail(String email){this.email=email;}
    
    public String getUID(){ return UID;}
    public void setUID(String UID){this.UID=UID;}
    
    public String getGenre(){ return genre;}
    public void setGenre(String genre){this.genre=genre;}
    
    public String getLanguage(){return genre;}
    public void setLanguage(String language){this.language=language;}
    
    public String getURL(){ return  URL;}
    public void setURL(String URL){this.URL=URL;}
    
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    
}
