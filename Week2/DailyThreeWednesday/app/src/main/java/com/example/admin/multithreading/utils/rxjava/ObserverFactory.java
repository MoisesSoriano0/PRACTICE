package com.example.admin.multithreading.utils.rxjava;

import android.util.Log;

import com.example.admin.multithreading.RxJavaHelper;



import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverFactory {

    public static final String TAG = RxJavaHelper.class.getSimpleName() + "_TAG";

    public static Observer getIntegetObserver() {
        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSuscribe: Thread: " + getThreadName());
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer + getThreadName());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.toString() + getThreadName());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: " + getThreadName());
            }
        };
        return integerObserver;


    }

    private static String getThreadName() {
        return " Thread: " + Thread.currentThread().getName();
    }

}
