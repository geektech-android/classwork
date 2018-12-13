package com.akai.geektech.classwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private Preferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mPreferences = PreferencesImpl.getInstance(this);

        boolean isAuth = mPreferences.contains(PreferencesImpl.EMAIL_KEY);
        startActivity(AuthActivity.getIntent(this, isAuth));
        finish();
    }
}
