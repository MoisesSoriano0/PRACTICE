package com.example.mvpexample.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvpexample.R;
import com.example.mvpexample.entities.Result;

public class DetailActivity extends AppCompatActivity {

    private static final String RESULT_DETAIL_EXTRA = "com.example.mvpexample.detail.RESULT_DETAIL_EXTRA";

    private TextView userNameTV;

    public static Intent getDetailIntent(Context context, Result result) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(RESULT_DETAIL_EXTRA, result);
        return detailIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        userNameTV = findViewById(R.id.tvDetailUserName);

        Result result = getIntent().getParcelableExtra(RESULT_DETAIL_EXTRA);

        if (result != null) {
            userNameTV.setText(result.getName().toString());
        }
    }
}
