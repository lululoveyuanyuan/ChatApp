package com.hspedu.qqcommom;

import java.io.Serializable;

/*
    * This class is used to represent a message.
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;//serialVersionUID
    private String sender; //sender
    private String getter; //receiver
    private String content; //content
    private String sendTime; //sendTime
    private String messageType; //messageType[define the type of message]

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
