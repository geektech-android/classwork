package com.akai.geektech.classwork.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.akai.geektech.classwork.R;

public class MainActivity extends AppCompatActivity {
    private Button mBtnProfile;

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnProfile = findViewById(R.id.btn_profile);
        mBtnProfile.setOnClickListener((view -> startActivity(ProfileActivity.getIntent(this))));
    }
}
