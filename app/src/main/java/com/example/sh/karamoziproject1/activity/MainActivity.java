package com.example.sh.karamoziproject1.activity;

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
import com.example.sh.karamoziproject1.fragment.CategoriesFragment;
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
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

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

    public boolean onClickMainMenu(MenuItem item) {
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT))
            drawerLayout.closeDrawer(Gravity.RIGHT);
        else
            drawerLayout.openDrawer(Gravity.RIGHT);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}