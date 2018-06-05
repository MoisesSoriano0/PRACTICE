package com.example.admin.activitylifecycleandintent;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText etMain;
    private TextView tvMain;
    private EditText etPersonName;
    private EditText etPersonAge;

//    What activity is it coming from
//    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TagIt.with(this), "onCreate");

//        select all methos and press ctrl + alt + M
//        etMain = findViewById(R.id.etMain);
//        tvMain = findViewById(R.id.tvMain);
//        etPersonName = findViewById(R.id.etPersonName);
//        etPersonAge = findViewById(R.id.etPersonAge);


        bindViews();

    }

    private void bindViews() {
        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);
        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
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

    public void onChangeTextView(View view) {
        tvMain.setText(etMain.getText().toString());
    }


    //how do we save the state of the activity on rotation change
    //before the activityu is destroyed
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TagIt.with(this), "onSaveInstanceState");

        outState.putString(Constants.KEY.TV_MAIN, tvMain.getText().toString());
    }

    //After de activity starts
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TagIt.with(this), "onRestoreInstanceState");

        String string = savedInstanceState.getString(Constants.KEY.TV_MAIN);
        tvMain.setText(string);
    }

    public void onSecondActivity(View view) {
//        Best practices the todo
        // TODO: 6/5/2018 implement logic for starting second activity

//        Explicit Intent, because we know the second
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra(Constants.KEY.TV_MAIN, etMain.getText().toString());

        switch (view.getId()){
            case R.id.btnFirst:
//               create person object
                Person person = new Person(etPersonName.getText().toString(), etPersonAge.getText().toString());
//                put person as extra to intent
                intent.putExtra(Constants.KEY.PERSON, person);

                break;
            case R.id.btnSecond:
                //               create person object
                PersonP personP = new PersonP(etPersonName.getText().toString(), etPersonAge.getText().toString());
//                put person as extra to intent
                intent.putExtra(Constants.KEY.PERSON, personP);
                break;
        }

//        start activity
        startActivity(intent);



    }
}
