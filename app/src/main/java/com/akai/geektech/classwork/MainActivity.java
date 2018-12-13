package com.akai.geektech.classwork;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnChangeAccount;
    private Preferences mPreferences;

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPreferences = PreferencesImpl.getInstance(this);
        mBtnChangeAccount = findViewById(R.id.btn_changeAcc);
        mBtnChangeAccount.setOnClickListener(this::changeAccount);
    }

    private void changeAccount(View view) {
        mPreferences.clear();
        startActivity(AuthActivity.getIntent(this, false));
        finish();
    }
}
