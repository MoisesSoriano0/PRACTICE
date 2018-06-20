package com.example.admin.day2mvpexample.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.day2mvpexample.R;
import com.example.admin.day2mvpexample.detail.DetailActivity;
import com.example.admin.day2mvpexample.entities.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeActivity extends AppCompatActivity implements HomeContract.View, View.OnClickListener{

    private static final String TAG = HomeActivity.class.getSimpleName() + "_TAG";
//    private TextView resultTV;
    private Button resultBT;
    private Button detailBT;
    private HomePresenter homePresenter;

    private EditText etUserNumber;
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private List<Result> data = null;

//    private RandomAPI randomAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        homePresenter = new HomePresenter(this);
        recyclerView = findViewById(R.id.recycler);

//        randomAPI = createRandomAPI(prepareRetrofit());
    }

//Homecontract view methods -----------------------------------------------------------------------------------------------------------------
    @Override
    public void showResult(List<Result> results) {

//        ArrayList<String> names = new ArrayList<>();
//        for (Result result: results) {
//            names.add(result.getName().getFirst());
//
//        }

        homeAdapter = new HomeAdapter(results);
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        StringBuilder builder = new StringBuilder();
//        for (Result result : results) {
//            builder.append(result.getName().getFirst());
//            builder.append("\n");
//        }
//        resultTV.setText(builder.toString());
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToDetail() {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        startActivity(detailIntent);

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.onViewDestroyed();
        homePresenter = null;
    }

//   View Listener methods --------------------------------------------------------------------------------------------------------------------
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnResult:
                System.out.println("numerooooo"+ Integer.parseInt(etUserNumber.getText().toString()));
                homePresenter.getResult(Integer.parseInt(etUserNumber.getText().toString()));
//                getRandomUsers(); //we dont need it anymore
                break;
            case R.id.btnDetail:
                homePresenter.onNavigateToDetail();
                break;
//            case R.id.itemValue:
//                Intent intent = new Intent(this, DetailActivity.class);
////                intent.putExtra("lastName", data.get(0).getName().getLast());
//                intent.putExtra("title", "title");
//                intent.putExtra("lastName", "lopez");
//                startActivity(intent);
        }
    }


    //    Private Methods -------------------------------------------------------------------------------------------------------------------------------------

//    We moved this to the Hompresenter
//    private void getRandomUsers() {
//        randomAPI.getUsers(10).enqueue(new Callback<UserResponse>() {
//            @Override
//            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
//                if (response.isSuccessful()) {
//                    UserResponse userResponse = response.body();
//                    List<Result> results = userResponse.getResults();
//                    Log.d(TAG, "onResponse: URL:" + call.request().url());
//                    for (Result result : results) {
//                        Log.d(TAG, "onResponse: " + result.getName().getFirst());
//                    }
//                } else {
//                    showError();
//                    Log.d(TAG, "onResponse: " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserResponse> call, Throwable t) {
//                //no access to medium/timeout
//                showError();
//                Log.d(TAG, "onFailure: " + t);
//
//            }
//        });
//    }


    private void initViews() {
//        resultTV = findViewById(R.id.tvResult);
        resultBT = findViewById(R.id.btnResult);
        resultBT.setOnClickListener(this);
        detailBT = findViewById(R.id.btnDetail);
        detailBT.setOnClickListener(this);
        etUserNumber = findViewById(R.id.etUserNumber);
    }



}
