package com.example.pinterest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pinterest.Fragment.HomeFragment;
import com.example.pinterest.Fragment.ProfileFragment;
import com.example.pinterest.Fragment.SavedFragment;
import com.example.pinterest.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity {

    BottomNavigationView bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();


        bottomBar=findViewById(R.id.bottomBar);

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment temp=null;

                switch (item.getItemId()){
                    case R.id.home : temp=new HomeFragment();
                    break;
                    case R.id.search:temp=new SearchFragment();
                    break;
                    case R.id.favorite:temp=new SavedFragment();
                    break;
                    case R.id.profile:temp=new ProfileFragment();
                    break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,temp).commit();
                return true;

            }
        });
    }
}