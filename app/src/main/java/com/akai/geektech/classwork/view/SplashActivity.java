package com.akai.geektech.classwork.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akai.geektech.classwork.R;
import com.akai.geektech.classwork.data.SourceProvider;
import com.akai.geektech.classwork.service.UserService;

public class SplashActivity extends AppCompatActivity {
    private UserService mUserService;

    public static Intent getIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mUserService = SourceProvider.getUserService(this);

        if (mUserService.isAuth()) {
            startActivity(AuthActivity.getIntent(this));
        } else {
            startActivity(RegistrationActivity.getIntent(this));
        }
        finish();
    }
}
