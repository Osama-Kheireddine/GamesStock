/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import classes.User;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import patterns.Observable;
import patterns.Observer;

/**
 *
 * @author ME
 */
public class Connection extends Thread implements Observer {

    private Socket dataSocket;
    private PrintWriter output;
    private Scanner input;

    public Connection(Socket dataSocket) {
        this.dataSocket = dataSocket;
    }

    @Override
    public void run() {
        try {
            //when a connection is made, a user is instantly created, this will
            //keep track of if bids are new or ammended
            User u = new User();
            // create the input and output streams
            OutputStream out = dataSocket.getOutputStream();
            output = new PrintWriter(new OutputStreamWriter(out));

            InputStream in = dataSocket.getInputStream();
            input = new Scanner(new InputStreamReader(in));

            System.out.println("Connection Started...");
            String inp = "";
            //wait for messages coming in
            while (!inp.equalsIgnoreCase("exit")) {
                //obtain the message
                inp = input.nextLine().toLowerCase();
                //set the input all to lowercase for switch case
                //inp = inp.toLowerCase();
                //use a switch case to then determine what action we will take
                switch (inp.charAt(0)) {//depending on the character in the first pos, we will decide what to do
                    //b = bid
                    case 'b':

                        break;
                    //s = sell
                    case 's':
                        //take the price
                        //take the user
                        //create a new game
                        break;
                    //e = exiit
                    case 'e':

                        break;
                }
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void update(Observable o) {
        
    }

}
