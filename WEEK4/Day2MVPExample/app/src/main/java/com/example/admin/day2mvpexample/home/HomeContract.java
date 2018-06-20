package com.example.admin.day2mvpexample.home;

import com.example.admin.day2mvpexample.base.BasePresenter;
import com.example.admin.day2mvpexample.entities.Result;

import java.util.List;

public interface HomeContract {

//    Define the responsabilities or role of the presenter
//    What is the view responsible of doing
//    What is the presenter responsible of doing

    interface View {
        void showResult(List<Result> results);
        void showError();
        void navigateToDetail();
    }

//    You extend from a base presnter that has common behavior for all the presenters
    interface Presenter extends BasePresenter{
        void getResult(int userCount);
        void onNavigateToDetail();
    }
}
