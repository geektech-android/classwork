package com.akai.geektech.classwork.ui.video;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akai.geektech.classwork.R;
import com.google.android.exoplayer2.ui.PlayerView;

public class VideoViewActivity extends AppCompatActivity implements VideoViewContract.View {
    private static final String VIDEO_URL_EXTRA = "com.akai.geektech.classwork.ui.video.VIDEO_URL_EXTRA";

    private VideoViewContract.Presenter mPresenter;
    private PlayerView mVideoView;

    public static Intent getIntent(Context context, String url) {
        Intent intent = new Intent(context, VideoViewActivity.class);
        intent.putExtra(VIDEO_URL_EXTRA, url);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mPresenter.releasePlayer();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            mPresenter.releasePlayer();
        }
    }

    private void init() {
        mPresenter = new VideoViewPresenter();
        mVideoView = findViewById(R.id.ep_video_view);
        mVideoView.setPlayer(mPresenter.getPlayer().getPlayerImpl(this));
        mPresenter.play(getUrl());
    }

    private String getUrl() {
        Intent intent = getIntent();
        if (!intent.hasExtra(VIDEO_URL_EXTRA)) {
            throw new IllegalArgumentException("Video url is missing!");
        }
        return intent.getStringExtra(VIDEO_URL_EXTRA);
    }
}
