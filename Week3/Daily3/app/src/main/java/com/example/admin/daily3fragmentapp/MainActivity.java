package com.example.admin.daily3fragmentapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;





public class MainActivity extends AppCompatActivity {

//    private FirstFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();

//        For When the app goes onResume, onRestart
//        if (fragment == null) {
//            fragment = new FirstFragment();
//        }
//        manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();


        manager.beginTransaction().add(R.id.fragmentContainer, new FirstFragment()).commit();
    }
}
