/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import core.GamesStockServerDetails;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ME
 */
public class Server {
    public static void main(String[] args) {
        new Server();
    }
    
    public Server(){
        //take incomming connection & start thread
        try{
            ServerSocket socket = new ServerSocket(GamesStockServerDetails.PORT_NUM);
            //flag to keep listening for new connections
            boolean keepRunning = true;
            while(keepRunning){
                //accept an incomming client connection
                Socket data = socket.accept();
                
                //create a new thread and pass the client connection to run on it.
                Connection threadedConnection = new Connection(data);
                //start the conncetion thread
                Thread t = new Thread(threadedConnection);
                t.start();
            }
        } catch (IOException e){
            
        }
    }
}
