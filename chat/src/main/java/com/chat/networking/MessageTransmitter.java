package com.chat.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 * Created by egorka on 23.08.16.
 */
public class MessageTransmitter extends Thread{

    String message, hostname;
    int port;

    public MessageTransmitter(){

    }

    public MessageTransmitter(String message, String hostname, int port){
        this.hostname = hostname;
        this.message = message;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
