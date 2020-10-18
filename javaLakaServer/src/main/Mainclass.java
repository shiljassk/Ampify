package main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.sql.Connection;
import tools.DBConnection;

public class Mainclass {
    public static Connection con = DBConnection.connectDB();
    public static Socket socket;
    public static ServerSocket serversocket;
    public static ServerSocketChannel serverClientSocketChannel;
   
    public static void main(String[] args) {
        try {
            serverClientSocketChannel = ServerSocketChannel.open();
            serverClientSocketChannel.socket().bind(new InetSocketAddress(9000));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            serversocket = new ServerSocket(2345);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        while(true){
            try{
                socket = serversocket.accept();
                Thread t = new Thread(new handleClientRequest(socket));
                t.start();
                System.out.println("Client connected");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
