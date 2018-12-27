package com.akai.geektech.classwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mBtnStart, mBtnStop;
    private EditText mEditSmth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart = findViewById(R.id.btn_start);
        mBtnStop = findViewById(R.id.btn_stop);
        mEditSmth = findViewById(R.id.edit_smth);

        mBtnStart.setOnClickListener((view -> startService(new Intent(this, MyService.class))));
        mBtnStop.setOnClickListener(view -> stopService(new Intent(this, MyService.class)));
    }
}
