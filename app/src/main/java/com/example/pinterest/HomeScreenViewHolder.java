package com.example.pinterest;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeScreenViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvHomeScreenImg;
    private ItemClickedListener itemClickedListener;
    public HomeScreenViewHolder(@NonNull View itemView,ItemClickedListener itemClickedListener) {
        super(itemView);
        this.itemClickedListener=itemClickedListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvHomeScreenImg=itemView.findViewById(R.id.imagePost);

    }
    public void setData(HomeScreenModel homeScreenModel){
        mIvHomeScreenImg.setImageResource(homeScreenModel.getImageId());
        mIvHomeScreenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickedListener.onItemClicked(homeScreenModel,getAdapterPosition());
            }
        });

    }
}
