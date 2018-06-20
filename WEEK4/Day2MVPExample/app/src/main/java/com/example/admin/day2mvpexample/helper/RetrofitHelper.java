package com.example.admin.day2mvpexample.helper;

import com.example.admin.day2mvpexample.data.RandomAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static RetrofitHelper INSTANCE;
    private RandomAPI randomAPI;

    private RetrofitHelper(){
        randomAPI = createRandomAPI(prepareRetrofit());
    }

    public synchronized static RetrofitHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitHelper();
        }
        return INSTANCE;
    }

    private Retrofit prepareRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(RandomAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private RandomAPI createRandomAPI(Retrofit client) {
        return client.create(RandomAPI.class); //the create is telling retrofit to use the methods in the RandomAPI class
    }

    public RandomAPI getRandomAPI() {
        return randomAPI;
    }
}
