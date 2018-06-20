package com.example.admin.day2mvpexample.data;

import com.example.admin.day2mvpexample.entities.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RandomAPI {
    String BASE_URL = "https://randomuser.me/";

//    https://randomuser.me/api?results={}
//    https://randomuser.me/{name}/api?results={} using path
    @GET("api")
    Call<UserResponse> getUsers(@Query("results") int results);
//    Call<UserResponse> getUsers(@Query("results") int results, @Path("name") String name); //using path

}
