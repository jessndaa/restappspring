package com.developper.restapp.object;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.cloud.Timestamp;

/**
 * NewsModel
 */
public class NewsModel {

    String title;
    String time;
    String message;
    String sender;

    public String getTitle(){
        return title;
    }

    public String getTime(){
        return time;
    }

    public String getMessage(){
        return message;
    }

    public String getSender(){
        return sender;
    }

}