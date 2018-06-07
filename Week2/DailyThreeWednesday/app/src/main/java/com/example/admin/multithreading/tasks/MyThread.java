package com.example.admin.multithreading.tasks;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class MyThread extends Thread {

    //    i can pass the instance of the textview to this calss and update it right here
    TextView tvResult;

    //    Handler from android os
//    this handler will need to be used bu a looper to associate it
//    This handler has access to the main thread
//    initialized by the message queue of the main thread
    Handler handler = new Handler(Looper.getMainLooper());


    public MyThread(TextView tvResult) {
        this.tvResult = tvResult;
    }

    @Override
    public void run() {
        super.run();

        // with this
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("Executing task");
            }
        });

//        before
//        tvResult.setText("Executing task");
//        task
        try {
            TaskFactory.createSimpleTask(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        handler.post(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("Task completed");
            }
        });

    }
}
