package com.example.admin.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.multithreading.model.MyEvent;
import com.example.admin.multithreading.tasks.MyAsyncTask;
import com.example.admin.multithreading.tasks.MyRunnable;
import com.example.admin.multithreading.tasks.MyThread;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements  Handler.Callback{

    private TextView tvResult;
    Handler handler;
    private TextView tvEventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        //this message recieves the message object
        //this class is a callback, so whernever i hangle a message
        handler = new Handler(this);
    }

    private void bindViews() {
        String something = "something";
        tvResult = findViewById(R.id.tvResult);
        tvEventBus = findViewById(R.id.tvEventBus);
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
                MyAsyncTask myAsyncTask = new MyAsyncTask(tvResult);
                myAsyncTask.execute("Task parameters");
//                myAsyncTask.cancel(true);
                break;
            case R.id.btnRxJava:
                RxJavaHelper.executeTask();
                break;
        }
    }

    //WE are gonna send a message back
    @Override
    public boolean handleMessage(Message msg) {
        tvResult.setText(msg.getData().getString("data"));
        return false;
    }


    //    subscribe for eventbus results
    @Subscribe(threadMode = ThreadMode.MAIN) //its a subscriber on the main
    public void onEventRecieved(MyEvent myEvent) {
        tvEventBus.setText(myEvent.getData());
    }

    //    subscribe for eventbus results
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventToast(MyEvent myEvent) {
        Toast.makeText(this, myEvent.getData(), Toast.LENGTH_SHORT).show();
    }

//    Eventbus library overridden methods
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
