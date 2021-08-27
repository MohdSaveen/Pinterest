package com.example.pinterest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeScreenAdapter extends RecyclerView.Adapter<HomeScreenViewHolder> {
    private final ArrayList<HomeScreenModel> homeScreenModelArrayList;
    private ItemClickedListener itemClickedListener;

    public HomeScreenAdapter(ArrayList<HomeScreenModel> homeScreenModelArrayList,ItemClickedListener itemClickedListener) {
        this.homeScreenModelArrayList = homeScreenModelArrayList;
        this.itemClickedListener=itemClickedListener;
    }

    @NonNull
    @Override
    public HomeScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homescreen_item_layout,parent,false);
        return new HomeScreenViewHolder(view,itemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeScreenViewHolder holder, int position) {
        HomeScreenModel homeScreenModel=homeScreenModelArrayList.get(position);
        holder.setData(homeScreenModel);
    }



    @Override
    public int getItemCount() {
        return homeScreenModelArrayList.size();
    }
}
