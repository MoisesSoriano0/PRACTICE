package com.example.mvpexample.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvpexample.R;
import com.example.mvpexample.home.HomePresenter;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private HomePresenter homePresenter;

    public HomeAdapter(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new HomeViewHolder(itemView, homePresenter);
    }

//    /it attachs every elements it recieves to the view
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        homePresenter.onBindUserRowViewAtPosition(position, holder);
//        Items instance -> dataset.get(position)
        //
    }

    @Override
    public int getItemCount() {
        return homePresenter.getResultsCount();
    }
}
