package com.example.mvpexample.data;

import com.example.mvpexample.entities.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomAPI {

    String BASE_URL = "https://randomuser.me/";

    // https://randomuser.me/api?results={}
    @GET("api")
    Call<UserResponse> getUsers(@Query("results") int results);

}
