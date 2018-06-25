package com.example.mvpexample.home;

import com.example.mvpexample.base.BasePresenter;
import com.example.mvpexample.entities.Result;

public interface HomeContract {

    interface View {
        void showResult();
        void showError();
        void navigateToDetail(Result result);
    }

    //new view
    interface UserRowView {
        void setUserName(String name);
    }

    interface Presenter extends BasePresenter {
        void getResult();
        void onBindUserRowViewAtPosition(int position, UserRowView userRowView);
        void onItemInteraction(int position);
        int getResultsCount();
    }

}
