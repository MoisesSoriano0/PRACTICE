package com.example.mvpexample.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mvpexample.R;
import com.example.mvpexample.detail.DetailActivity;
import com.example.mvpexample.entities.Result;
import com.example.mvpexample.home.adapter.HomeAdapter;

public class HomeActivity extends AppCompatActivity
        implements HomeContract.View, View.OnClickListener {

    private static final String TAG = HomeActivity.class.getSimpleName() + "_TAG";

    private Button resultBT;
    private RecyclerView usersRecycler;

    private HomeAdapter homeAdapter;
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //init presenter
        homePresenter = new HomePresenter(this);
        // init adapter, this order matters
        homeAdapter = new HomeAdapter(homePresenter);
        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.onViewDestroyed();
        homePresenter = null;
    }

    @Override
    public void showResult() {
//        what you could do instead of using the passive way is
//        Atlernative: update the dataset in the adapter
//        Alt: the adapter internally calls notifyDatasetChange
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToDetail(Result result) {
        startActivity(DetailActivity.getDetailIntent(this, result));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btResult:
                homePresenter.getResult();
                break;
        }
    }

    private void initViews() {
        resultBT = findViewById(R.id.btResult);
        resultBT.setOnClickListener(this);
        //init the recycler view
        usersRecycler = findViewById(R.id.userRecycler);
        usersRecycler.setAdapter(homeAdapter);
        usersRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
