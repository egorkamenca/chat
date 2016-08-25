package com.chat.networking;

import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by egorka on 23.08.16.
 */
public class MessageListener extends  Thread{

    ServerSocket server;
    int port = 8877;
    WritableGUI gui;
    public MessageListener(WritableGUI gui, int port){
        this.port = port;
        this.gui = gui;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MessageListener(){
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        Socket clientSocket;
        try {
            while ((clientSocket = server.accept()) != null){
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                if(line != null){
                    gui.write(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
