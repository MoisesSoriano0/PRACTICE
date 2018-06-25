package com.example.mvpexample.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mvpexample.R;
import com.example.mvpexample.home.HomeContract;
import com.example.mvpexample.home.HomePresenter;

public class HomeViewHolder extends RecyclerView.ViewHolder
        implements HomeContract.UserRowView, View.OnClickListener {

    HomePresenter homePresenter;
    TextView userName;

    public HomeViewHolder(View itemView, HomePresenter homePresenter) {
        super(itemView);
        userName = itemView.findViewById(R.id.tvUserName);
        itemView.setOnClickListener(this);
        this.homePresenter = homePresenter;
    }

    @Override
    public void setUserName(String name) {
        userName.setText(name);
    }

    @Override
    public void onClick(View v) {
        if(homePresenter != null) {
            homePresenter.onItemInteraction(getAdapterPosition());
        }
    }
}
