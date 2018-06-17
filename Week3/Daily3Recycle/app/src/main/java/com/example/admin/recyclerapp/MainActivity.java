package com.example.admin.recyclerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = generateItems();
        mainAdapter = new MainAdapter((items));
        recyclerView = findViewById(R.id.recycler);

        recyclerView.setAdapter(mainAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private ArrayList<String> generateItems() {
        ArrayList<String> items = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            items.add("item "+i);
        }
        return items;
    }
}
