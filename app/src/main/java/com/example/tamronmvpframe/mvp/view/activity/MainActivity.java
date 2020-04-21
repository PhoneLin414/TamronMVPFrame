package com.example.tamronmvpframe.mvp.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.mvp.view.fragment.CategoryFragment;
import com.example.tamronmvpframe.mvp.view.fragment.FavouriteFragment;
import com.example.tamronmvpframe.mvp.view.fragment.HomeFragment;
import com.example.tamronmvpframe.mvp.view.fragment.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.btmNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(new HomeFragment());

    }


    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(new HomeFragment());
                            return true;
                        case R.id.navigation_category:
                            openFragment(new CategoryFragment());
                            return true;
                        case R.id.navigation_readlater:
                            openFragment(new FavouriteFragment());
                            return true;
//                        case R.id.navigation_more:
//                            openFragment(new MoreFragment());
//                            return true;
                    }
                    return false;
                }
            };




}
