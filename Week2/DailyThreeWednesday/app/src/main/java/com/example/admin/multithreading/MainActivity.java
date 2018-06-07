package com.example.admin.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.admin.multithreading.tasks.MyRunnable;
import com.example.admin.multithreading.tasks.MyThread;

public class MainActivity extends AppCompatActivity implements  Handler.Callback{

    private TextView tvResult;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        //this message recieves the message object
        //this class is a callback, so whernever i hangle a message
        handler = new Handler(this);
    }

    public void onHandleWorkers(View view) {

        Log.d(MainActivity.class.getSimpleName() + "+TAG", "onHandleWorkers: Thread:" + Thread.currentThread().getName());

        switch (view.getId()){
            case R.id.btnThread:
                //it crashes cause you are trying to change the ui, and only the main thread can do that
                MyThread myThread = new MyThread(tvResult);
                myThread.start();


                break;
            case R.id.btnRunnable:
                MyRunnable myRunnable = new MyRunnable(handler);
                //                here it crashes cause of the main
//                Thread thread = new Thread(myRunnable);
                Thread thread = new Thread(myRunnable);
                thread.start();
                break;
            case R.id.btnAsyncTask:
                break;
        }
    }

    //WE are gonna send a message back
    @Override
    public boolean handleMessage(Message msg) {
        tvResult.setText(msg.getData().getString("data"));
        return false;
    }
}
