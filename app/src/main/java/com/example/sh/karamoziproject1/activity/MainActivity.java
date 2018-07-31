package com.example.sh.karamoziproject1.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sh.karamoziproject1.R;
import com.example.sh.karamoziproject1.fragment.AboutFragment;
import com.example.sh.karamoziproject1.fragment.CategoriesFragment;
import com.example.sh.karamoziproject1.fragment.ContactFragment;
import com.example.sh.karamoziproject1.fragment.MainPageFragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setValueDrawerLayout();
        setValueBottomNavigation();
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.main_dl_layout);
        bottomNavigationView = findViewById(R.id.main_main_bottom_navigation);
    }

    private void setValueDrawerLayout() {
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void setValueBottomNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.menu_main_bottom_navigation_categories);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_main_layout, new CategoriesFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_main_bottom_navigation_main_page:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.main_main_layout, new MainPageFragment()).commit();
                                break;
                            case R.id.menu_main_bottom_navigation_categories:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.main_main_layout, new CategoriesFragment()).commit();
                                break;
                        }
                        return true;
                    }
                });
    }

    public void onClickMainMenu(MenuItem item) {
        if (drawerLayout.isDrawerOpen(Gravity.END))
            drawerLayout.closeDrawer(Gravity.END);
        else
            drawerLayout.openDrawer(Gravity.END);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onClickMainNavigation(View view) {
        drawerLayout.closeDrawer(Gravity.END);
        switch (view.getId()){
            case R.id.main_navigation_tv_about:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_main_layout, new AboutFragment()).commit();
                break;
            case R.id.main_navigation_tv_contact:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_main_layout, new ContactFragment()).commit();
                break;
        }
    }
}