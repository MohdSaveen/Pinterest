package com.example.pinterest.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pinterest.HomeScreenAdapter;
import com.example.pinterest.HomeScreenModel;
import com.example.pinterest.ItemClickedListener;
import com.example.pinterest.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements ItemClickedListener {
    private RecyclerView recyclerView;
    private final ArrayList<HomeScreenModel> homeScreenModelArrayList=new ArrayList<>();
    private HomeScreenAdapter homeScreenAdapter;
    private ImageView imageView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            recyclerView=view.findViewById(R.id.recyclerView);
            imageView=view.findViewById(R.id.imagePost);
        buildList();
        setRecyclerView();

    }

    private void setRecyclerView() {
         homeScreenAdapter=new HomeScreenAdapter(homeScreenModelArrayList,this);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(homeScreenAdapter);
    }

    private void buildList() {
        for(int i=0;i<10;i++){
            HomeScreenModel homeScreenModel=new HomeScreenModel(R.drawable.pics);
            HomeScreenModel homeScreenModel1=new HomeScreenModel(R.drawable.picss);
            HomeScreenModel homeScreenModel2=new HomeScreenModel(R.drawable.picsss);
            HomeScreenModel homeScreenModel3=new HomeScreenModel(R.drawable.pic2);
            HomeScreenModel homeScreenModel4=new HomeScreenModel(R.drawable.pic3);
            HomeScreenModel homeScreenModel5=new HomeScreenModel(R.drawable.pic4);
            HomeScreenModel homeScreenModel6=new HomeScreenModel(R.drawable.pic5);
            HomeScreenModel homeScreenModel7=new HomeScreenModel(R.drawable.pic6);
            HomeScreenModel homeScreenModel8=new HomeScreenModel(R.drawable.pic7);
            HomeScreenModel homeScreenModel9=new HomeScreenModel(R.drawable.pic8);
            HomeScreenModel homeScreenModel10=new HomeScreenModel(R.drawable.pic9);
            HomeScreenModel homeScreenModel11=new HomeScreenModel(R.drawable.pic10);
            homeScreenModelArrayList.add(homeScreenModel);
            homeScreenModelArrayList.add(homeScreenModel1);
            homeScreenModelArrayList.add(homeScreenModel2);
            homeScreenModelArrayList.add(homeScreenModel3);
            homeScreenModelArrayList.add(homeScreenModel4);
            homeScreenModelArrayList.add(homeScreenModel5);
            homeScreenModelArrayList.add(homeScreenModel6);
            homeScreenModelArrayList.add(homeScreenModel7);
            homeScreenModelArrayList.add(homeScreenModel8);
            homeScreenModelArrayList.add(homeScreenModel9);
            homeScreenModelArrayList.add(homeScreenModel10);
            homeScreenModelArrayList.add(homeScreenModel11);
        }
    }


    @Override
    public void onItemClicked(HomeScreenModel model, int position) {


        Bundle bundle=new Bundle();
        bundle.putInt("image", model.getImageId());

        ImageShowingFragment imageShowingFragment =new ImageShowingFragment();
        imageShowingFragment.setArguments(bundle);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, imageShowingFragment).commit();

    }
}