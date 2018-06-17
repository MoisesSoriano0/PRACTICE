package com.example.admin.daily2broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    public static final String TAG = MyReceiver.class.getSimpleName() + "_TAG";

//        Bad practice, don't reuse a receiver
//        Have one for each reciever
//        Avoid ANR, application not responding
//        A receiver for just the one broadcast you are going to listen for
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceivedBroadcast Received");
//        Log.d(TAG, "onReceive: Thread is:" + Thread.currentThread().getName());
    }
}
