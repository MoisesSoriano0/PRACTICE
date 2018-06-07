package com.example.admin.multithreading.tasks;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.admin.multithreading.utils.HandlerUtils;

public class MyRunnable implements Runnable {

    //handler instance
    Handler handler;

    public MyRunnable(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {

//        Message message = new Message();
//        Bundle bundle = new Bundle();
//        bundle.putString("data", "Executing Thread");
//        message.setData(bundle);
//        handler.sendMessage(message);

        HandlerUtils.with(handler).sendMessage("Executing Thread");

        try {
            TaskFactory.createSimpleTask(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HandlerUtils.with(handler).sendMessage("Task completed");

//        Message message1 = new Message();
//        Bundle bundle1 = new Bundle();
//        bundle1.putString("data", "Task Completed");
//        message1.setData(bundle1);
//        handler.sendMessage(message1);
    }
}
