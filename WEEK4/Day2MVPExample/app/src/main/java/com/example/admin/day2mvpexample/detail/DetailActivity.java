package com.example.admin.day2mvpexample.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.day2mvpexample.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvLastName;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvLastName = findViewById(R.id.tvLastname);
        tvTitle = findViewById(R.id.tvTitle);


        tvTitle.setText(getIntent().getExtras().getString("gender"));
        tvLastName.setText(getIntent().getExtras().getString("lastName"));

    }
}
