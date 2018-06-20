package com.example.admin.day2mvpexample.home;

import android.util.Log;

import com.example.admin.day2mvpexample.data.RandomAPI;
import com.example.admin.day2mvpexample.entities.Result;
import com.example.admin.day2mvpexample.entities.UserResponse;
import com.example.admin.day2mvpexample.helper.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements  HomeContract.Presenter{

    private static final String TAG = HomePresenter.class.getSimpleName() + "_TAG";
    private HomeContract.View homeView;
    private RandomAPI randomAPI;
    public static final int USER_COUNT = 10;

    //whenever the view is created will recieve an instance
    public HomePresenter(HomeContract.View homeView) {
        this.homeView = homeView;
        randomAPI = RetrofitHelper.getInstance().getRandomAPI();
    }

    @Override
    public void getResult(int userCount) {
//        Here we call the  model/service/interactors
//        Use cases, repository, etc
//        homeView.showResult();
        getRandomUsers(userCount);
    }

    @Override
    public void onNavigateToDetail() {
//        Chance to prepare data to be shared
        homeView.navigateToDetail();
    }

    //This one was added after extendind the BasePresentes in the homecontract presenter
    @Override
    public void onViewDestroyed() {
        this.homeView = null; //you have to get rid of the view once the activity is being destrroy
    }

    private void getRandomUsers(int count) {
        randomAPI.getUsers(count).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: URL:" + call.request().url());
                    UserResponse userResponse = response.body(); //after you call response.body you can't call it again
                    homeView.showResult(userResponse.getResults());
//                    List<Result> results = userResponse.getResults();
//                    for (Result result : results) {
//                        Log.d(TAG, "onResponse: " + result.getName().getFirst());
//                    }
//                    homeView.showResult();
                } else {
                    homeView.showError();
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                //no access to medium/timeout
                homeView.showError();
                Log.d(TAG, "onFailure: " + t);

            }
        });
    }
}

