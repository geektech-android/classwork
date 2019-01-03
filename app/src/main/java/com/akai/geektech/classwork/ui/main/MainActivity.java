package com.akai.geektech.classwork.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akai.geektech.classwork.R;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    private TextView mTextEmpty;
    private RecyclerView mRecyclerVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mProgress = findViewById(R.id.pb_main);
        mRecyclerVideo = findViewById(R.id.rv_videos);
        mTextEmpty = findViewById(R.id.tv_empty);
    }
}
