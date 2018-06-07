package com.example.admin.multithreading.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class HandlerUtils {

    //    static private instance null
    //static the memory reference can't be changed, but the contents can
    private static HandlerUtils instance = null;
    Handler handler;

    private HandlerUtils() {
        //avoid initialization of this class
    }

    //you give access to the public method HandlerUltis
//    if the instance is null, you create a new
//    if its not null you just return it
//    also the the method recieves a handler, and that can be changed from different clases
    public static HandlerUtils with(Handler handler) {

        if (instance == null) {
            instance = new HandlerUtils(handler);
        }
        instance.setHandler(handler);
        return instance;
    }

    private HandlerUtils(Handler handler) {
        this.handler = handler;
    }

    private void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void sendMessage(String MESSAGE) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", MESSAGE);
        message.setData(bundle);
        handler.sendMessage(message);

    }


}
