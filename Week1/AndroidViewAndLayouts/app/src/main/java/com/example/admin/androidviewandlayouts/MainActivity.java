package com.example.admin.androidviewandlayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvSecondView1;
    private TextView tvFirstView;
    private View btnFirst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirstView = findViewById(R.id.tvFirstView);
        tvSecondView1 = findViewById(R.id.tvSecondView);
        btnFirst = findViewById(R.id.btnFirst);

//        First Way
//        btnFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvFirstView.setText("Value changed");
//
//            }
//        });

//        Second Way
//        MyClickListener clickListener = new MyClickListener(tvFirstView);
//        btnFirst.setOnClickListener(clickListener);

//        Third Way
        //We implement the View.OnClickListener interface for the third
        btnFirst.setOnClickListener(this);

    }

    //For the third way of first button
    @Override
    public void onClick(View v) {
        tvFirstView.setText("Changed from activity");
    }

    public void onSecondClicked(View view) {

    }
}
