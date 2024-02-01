package com.hspedu.qqclient.service;
import com.hspedu.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread {
    // This class is used to connect to the server,this thread holds the socket object
    private Socket socket;

    //constructor receives the socket object
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    //getter method for the socket object
    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {

        //use while loop to keep the connection
        while (true) {
            try {
                System.out.println("ClientConnectServerThread is running and keep the connection");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //if the server sends a message, we can read it
                Message message = (Message) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
