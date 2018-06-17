package com.example.admin.recyclerapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<String> items;

    public MainAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //here you bind the dataset with the view
        String item = items.get(position);
        holder.itemValue.setText(item);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    //we created a class
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemValue;

        public ViewHolder(View itemView) {
            super(itemView);
            //here you bind the items
            itemValue = itemView.findViewById(R.id.itemValue);
        }
    }

}
