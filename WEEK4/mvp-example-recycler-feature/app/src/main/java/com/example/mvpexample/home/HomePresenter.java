package com.example.mvpexample.home;

//import android.util.Log;

import com.example.mvpexample.data.RandomAPI;
import com.example.mvpexample.entities.Result;
import com.example.mvpexample.entities.UserResponse;
import com.example.mvpexample.helper.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements HomeContract.Presenter {

//    no more reference to android, a simple class
//    private static final String TAG = HomePresenter.class.getSimpleName() + "_TAG";
    private static final int USER_COUNT = 10;

    private HomeContract.View homeView;
    private RandomAPI randomAPI;
    private List<Result> results;

    public HomePresenter(HomeContract.View homeView) {
        this.homeView = homeView;
        randomAPI = RetrofitHelper.getInstance().getRandomAPI();
    }

    @Override
    public void getResult() {
        getRandomUsers(USER_COUNT);
    }

//    The presenter tells the view to get the value
    @Override
    public void onBindUserRowViewAtPosition(int position, HomeContract.UserRowView userRowView) {
        userRowView.setUserName(results.get(position).getName().toString());
    }

    @Override
    public void onItemInteraction(int position) {
        homeView.navigateToDetail(results.get(position));
    }

    @Override
    public int getResultsCount() {
        return results == null ? 0 : results.size();
    }

    @Override
    public void onViewDestroyed() {
        this.homeView = null;
    }

    private void getRandomUsers(int count) {
        randomAPI.getUsers(count).enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()) {
                    UserResponse userResponse = response.body();
                    results = userResponse.getResults();
                    homeView.showResult();
                } else {
                    homeView.showError();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                // no access to medium/timeout
                homeView.showError();
//                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}
