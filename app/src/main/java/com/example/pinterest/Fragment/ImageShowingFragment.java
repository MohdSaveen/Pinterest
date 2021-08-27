package com.example.pinterest.Fragment;

import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pinterest.Fragment.HomeFragment;
import com.example.pinterest.Fragment.SavedFragment;
import com.example.pinterest.R;

public class ImageShowingFragment extends Fragment {

    private ImageView imageView;
    private Button btnAdd;



    public ImageShowingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView=view.findViewById(R.id.imgShowing);
        btnAdd=view.findViewById(R.id.button);
        Bundle bundle=this.getArguments();
        int data=bundle.getInt("image");
        imageView.setImageResource(data);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdd.setText("Added");
            }
        });
    }
}