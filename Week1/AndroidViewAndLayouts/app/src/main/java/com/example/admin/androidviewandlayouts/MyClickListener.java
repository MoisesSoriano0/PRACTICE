package com.example.admin.androidviewandlayouts;

import android.view.View;
import android.widget.TextView;


//Second way to implement an Onclick event
public class MyClickListener implements View.OnClickListener {


    TextView textView;


    public MyClickListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        textView.setText(getTextValue());
    }

    public String getTextValue() {
        return "Some Value";
    }
}
