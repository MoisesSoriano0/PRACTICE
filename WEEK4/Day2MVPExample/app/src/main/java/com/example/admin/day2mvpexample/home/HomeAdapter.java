package com.example.admin.day2mvpexample.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.day2mvpexample.R;
import com.example.admin.day2mvpexample.detail.DetailActivity;
import com.example.admin.day2mvpexample.entities.Result;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

//    private ArrayList<String> items;
    private List<Result> items;

    public HomeAdapter(List<Result> items) {
        this.items = items;
    }
    Context cxt;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        cxt = parent.getContext();
        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        String item = items.get(position);
        holder.itemValue.setText(items.get(position).getName().getFirst());

        final int pos = position;

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cxt, DetailActivity.class);
                intent.putExtra("lastName", items.get(pos).getName().getLast());
                intent.putExtra("gender", items.get(pos).getGender());
                cxt.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 :  items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemValue;
        LinearLayout layoutItem;

        public ViewHolder(View itemView) {
            super(itemView);
            itemValue = itemView.findViewById(R.id.itemValue);
            layoutItem = itemView.findViewById(R.id.reclyclerItem);
        }
    }
}
