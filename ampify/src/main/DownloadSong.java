/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import request.DownloadSongRequest;

/**
 *
 * @author rishi
 */
public class DownloadSong {
    
    private String songname;
    
    
    

    public DownloadSong(String songname) throws FileNotFoundException, IOException {
        this.songname=songname;
        DownloadSongRequest downloadSongRequest =new DownloadSongRequest(songname);
        
        MainClass.downloadoos.writeObject(downloadSongRequest);
        MainClass.downloadoos.flush();
        
        if(!Files.isDirectory(Paths.get("C:\\Ampify_Downloaded_Songs"))){
            new File("C:\\Ampify_Downloaded_Songs").mkdir();
            
        }
    
        
        OutputStream fileOS = new FileOutputStream("C:\\Ampify_Downloaded_Songs\\"+songname+".mp3");
        
        byte[] buffer = new byte[10*1024];
         
         int count;
          while ((count = MainClass.fileIS.read(buffer)) > 0) {
            fileOS.write(buffer, 0, count);
        }
          MainClass.fileIS.close();
         fileOS.close();
 
        JOptionPane.showMessageDialog(null, "Song Downloaded");
        
    }

    }
    
    
   

    
     
                
   

    

