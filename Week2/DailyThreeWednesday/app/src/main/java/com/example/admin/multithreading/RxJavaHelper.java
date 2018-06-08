package com.example.admin.multithreading;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaHelper {

    public static final String TAG = RxJavaHelper.class.getSimpleName() + "_TAG";

    public static void executeTask(){
        //calls taha emits the values, sequence of values that will send the emissions
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5);

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

//        subscribe to emissions
        integerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integerObserver);
    }

    private static String getThreadName() {
        return " Thread: " + Thread.currentThread().getName();
    }
}
