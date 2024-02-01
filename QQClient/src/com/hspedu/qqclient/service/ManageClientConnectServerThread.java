package com.hspedu.qqclient.service;

import java.util.HashMap;

/**
 * This class is used to manage the ClientConnectServerThread
 */

public class ManageClientConnectServerThread {
    //use HashMap to store the multi ClientConnectServerThread
    //key is userId, value is ClientConnectServerThread
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    //add ClientConnectServerThread to hm
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userId, clientConnectServerThread);
    }
    //get ClientConnectServerThread by userId
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }
}
