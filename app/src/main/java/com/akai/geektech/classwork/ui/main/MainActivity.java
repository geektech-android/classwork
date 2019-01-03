package com.akai.geektech.classwork.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akai.geektech.classwork.R;
import com.akai.geektech.classwork.data.network.model.ApiVideo;
import com.akai.geektech.classwork.ui.video.VideoViewActivity;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements MainContract.View{

    private ProgressBar mProgress;
    private TextView mTextEmpty;
    private RecyclerView mRecyclerVideo;

    private MainContract.Presenter mPresenter;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.deactivate();
    }

    @Override
    public void renderVideos(List<ApiVideo> videos) {
        hideLoadingIndicator();
        hideEmptyView();
        mAdapter.onVideosUpdate(videos);
    }

    @Override
    public void showErrorMessage() {
        hideLoadingIndicator();
        showEmptyView();
    }

    private void init() {
        mProgress = findViewById(R.id.pb_main);
        mRecyclerVideo = findViewById(R.id.rv_videos);
        mTextEmpty = findViewById(R.id.tv_empty);

        initializeRecyclerView();

        mPresenter = new MainPresenter(this);
        mPresenter.fetchSampleVideos();
        showLoadingIndicator();
        hideEmptyView();
    }

    private void initializeRecyclerView() {
        mRecyclerVideo.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerVideo.setHasFixedSize(true);
        mAdapter = new MainAdapter(this::onVideoItemClick);
        mRecyclerVideo.setAdapter(mAdapter);
    }

    private void onVideoItemClick(ApiVideo video) {
        startActivity(VideoViewActivity.getIntent(this, buildUrl(video)));
    }

    private void showLoadingIndicator() {
        mProgress.setVisibility(View.VISIBLE);
    }

    private void hideLoadingIndicator() {
        mProgress.setVisibility(View.GONE);
    }

    private void showEmptyView() {
        mTextEmpty.setVisibility(View.VISIBLE);
    }

    private void hideEmptyView() {
        mTextEmpty.setVisibility(View.GONE);
    }

    private String buildUrl(ApiVideo video) {
        return String.format(Locale.getDefault(),
                "https://res.cloudinary.com/demo/video/%s/v%d/%s.%s", video.getType(), video.getVersion(), video.getPublicId(), video.getFormat());
    }
}
