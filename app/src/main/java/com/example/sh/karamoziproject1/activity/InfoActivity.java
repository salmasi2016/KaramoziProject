package com.example.sh.karamoziproject1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.sh.karamoziproject1.R;
import com.example.sh.karamoziproject1.model.User;

public class InfoActivity extends AppCompatActivity {
    final static String KEY_MAINPAGE_TO_INFO_USER = "user";
    TextView tvFirstName, tvLastName, tvEmail;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        user = getIntent().getExtras().getParcelable(KEY_MAINPAGE_TO_INFO_USER);
        initViews();
    }

    private void initViews() {
        tvFirstName = findViewById(R.id.info_tv_firstName);
        tvLastName = findViewById(R.id.info_tv_lastName);
        tvEmail = findViewById(R.id.info_tv_email);
        tvFirstName.setText("name : " + user.getStrFirstName());
        tvLastName.setText("family : " + user.getStrLastName());
        tvEmail.setText("email : " + user.getStrEmail());
    }
}