package com.example.sh.karamoziproject1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sh.karamoziproject1.R;
import com.example.sh.karamoziproject1.activity.InfoActivity;
import com.example.sh.karamoziproject1.model.User;

public class MainPageFragment extends Fragment {
    final static String URL_IMG = "http://yaramobile.com/templates/sj_hexagon/images/styling/blue/logo.png";
    final static String KEY_MAINPAGE_TO_INFO_USER = "user";
    private EditText etFirstName, etLastName, etEmail;
    private ImageView ivLogo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        loadImage();
    }

    private void initViews(View view) {
        etFirstName = view.findViewById(R.id.fragment_main_page_et_first_name);
        etLastName = view.findViewById(R.id.fragment_main_page_et_last_name);
        etEmail = view.findViewById(R.id.fragment_main_page_et_email);
        ivLogo = view.findViewById(R.id.fragment_main_page_iv_logo);
        Button btnEnter = view.findViewById(R.id.fragment_main_page_btn_enter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputsIsValid()) {
                    User user = new User();
                    user.setStrFirstName(etFirstName.getText().toString());
                    user.setStrLastName(etLastName.getText().toString());
                    user.setStrEmail(etEmail.getText().toString());
                    Intent intent = new Intent(getActivity(), InfoActivity.class);
                    intent.putExtra(KEY_MAINPAGE_TO_INFO_USER, user);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadImage() {
        Glide.with(this).load(URL_IMG).into(ivLogo);
    }

    private boolean inputsIsValid() {
        return !etFirstName.getText().toString().isEmpty() &&
                !etLastName.getText().toString().isEmpty() &&
                !etEmail.getText().toString().isEmpty();
    }
}