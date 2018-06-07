package com.example.admin.multithreading.tasks;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TaskFactory {
    public static void createSimpleTask(Object worker) throws InterruptedException {

//        Example of shortcut
//        List<String> strings = new ArrayList<>();
//            strings.for shortcut for arraylist for
//        for (String string : strings) {
//
//        }

        String TAG = worker.getClass().getSimpleName() + "_TAG  Thread:" ;

        Log.d(TAG, "createSimpleTask: Starting Task on " + Thread.currentThread().getName());

        //fori shortcut, type fori and it suggests the complete for
        for (int i = 0; i < 5; i++) {
            Log.d(TAG, "createSimpleTask: Task Status: " +i);
            Thread.sleep(500);
        }

        Log.d(TAG, "createSimpleTask: Task Complete");
    }
}
