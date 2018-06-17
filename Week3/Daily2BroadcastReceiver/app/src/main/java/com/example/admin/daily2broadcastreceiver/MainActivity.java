package com.example.admin.daily2broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReceiver = new MyReceiver();
        filter = new IntentFilter();
        filter.addAction("com.moises.action.CUSTOM_BROADCAST");
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //this helps me avoid the memory leak
        unregisterReceiver(myReceiver);
    }

    public void sendCustomBroadcast(View view) {
        Intent myBroadcastIntent = new Intent(this, MyReceiver.class);
        myBroadcastIntent.setAction("com.moises.action.CUSTOM_BROADCAST");
        sendBroadcast(myBroadcastIntent);
    }
}
