package com.example.sh.karamoziproject1.retrofit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.sh.karamoziproject1.R;

public class RetrofitActivity extends AppCompatActivity implements UserFragment.Interaction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        setFragment(new UserFragment());
    }

    private void setFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment instanceof UserFragment) {
            fragmentTransaction.replace(R.id.retrofit_fl_layout, fragment);
        } else if (fragment instanceof PostFragment) {
            fragmentTransaction.replace(R.id.retrofit_fl_layout, fragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void goToPostFragment(User user) {
        setFragment(PostFragment.newSlide(user));
    }
}