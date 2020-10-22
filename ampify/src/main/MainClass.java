/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllers.loginform;
import data.Song;
import data.User;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author rishi
 */
public class MainClass {
    
    public static final String serverIP ="localhost";
    public static final int portNO =2345;
    private final static int downloadPortNO =63423;
    
    public static Socket socket;
    public static Socket downloadsocket;
    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;
    
    public static ObjectOutputStream downloadoos;
    
    
    public static InputStream fileIS;
    
    public static User user;
    
  
   
    public static void main(String[] args) {
        
        try{
            socket =new Socket(serverIP,portNO);
            oos= new ObjectOutputStream(socket.getOutputStream());
            ois= new ObjectInputStream(socket.getInputStream());
            loginform lform =new loginform();
            lform.setVisible(true);
            //downloadsocket = new Socket(serverIP, downloadPortNO);
            //fileIS = downloadsocket.getInputStream();
            
            //downloadoos = new ObjectOutputStream(downloadsocket.getOutputStream());
            
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    
    
    
}
