package com.example.admin.activitylifecycleandintent;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity{

    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TagIt.with(this), "onCreate");

        String tvString = getIntent().getStringExtra(Constants.KEY.TV_MAIN);
        tvMain = findViewById(R.id.tvMain);
//        tvMain.setText(tvString);

        //recieve the person object
//        YOu need to cast it cause it returns an object
//        Person person = (Person)getIntent().getSerializableExtra(Constants.KEY.PERSON);
//        tvMain.setText(person.toString());

        PersonP personP = getIntent().getParcelableExtra(Constants.KEY.PERSON);
        tvMain.setText(personP.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TagIt.with(this), "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Show message in screen
//        Toast.makeText(this,"onPause()", Toast.LENGTH_LONG).show();
        Log.d(TagIt.with(this), "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TagIt.with(this), "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TagIt.with(this), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TagIt.with(this), "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TagIt.with(this), "onRestart");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        newConfig.orientation portrait = 1
        Log.d(TagIt.with(this), "onConfigurationChanged " + newConfig.orientation);
    }


}
