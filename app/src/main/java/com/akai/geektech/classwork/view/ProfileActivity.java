package com.akai.geektech.classwork.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akai.geektech.classwork.R;
import com.akai.geektech.classwork.data.SourceProvider;
import com.akai.geektech.classwork.data.model.UserEntity;
import com.akai.geektech.classwork.service.UserService;

public class ProfileActivity extends AppCompatActivity {
    private TextView mTextFirstName;
    private TextView mTextSecondName;
    private Button mBtnSignOut;
    private UserService mUserService;
    private UserEntity mUser;

    public static Intent getIntent(Context context) {
        return new Intent(context, ProfileActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
    }

    private void onSignOutClicked(View view) {
        mUserService.signOut(mUser);
        startActivity(SplashActivity.getIntent(this));
        finish();
    }

    private void setUp() {
        mBtnSignOut.setOnClickListener(this::onSignOutClicked);
        mUser = mUserService.getUser(mUserService.getId());
        mTextFirstName.setText(mUser.getFName());
        mTextSecondName.setText(mUser.getSName());
    }

    private void init() {
        mUserService = SourceProvider.getUserService(this);
        mTextFirstName = findViewById(R.id.text_fName);
        mTextSecondName = findViewById(R.id.text_sName);
        mBtnSignOut = findViewById(R.id.btn_signOut);
        setUp();
    }
}
