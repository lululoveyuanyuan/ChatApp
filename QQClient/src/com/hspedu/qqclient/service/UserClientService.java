package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * This class is used to provide the service for the user.
 */
public class UserClientService {
    private User u = new User();
    private Socket socket;
    //check whether the user id and password are correct
    public boolean checkUser(String userId, String passwd) {
        boolean b = false;
        u.setUserId(userId);
        u.setPasswd(passwd);
        //send userId and passwd to server
        try {
            Socket socket = new Socket(String.valueOf(Arrays.toString(InetAddress.getAllByName("localhost"))), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//send user object to server
            //get the response from server
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();

            if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                //login succeed
                //create a new thread to keep the connection
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                //start the thread
                ccst.start();
                // we will put the thread object into the hashmap for later use
                ManageClientConnectServerThread.addClientConnectServerThread(userId, ccst);
                b = true;
            } else {
                //login fail, close the socket
                socket.close();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}
