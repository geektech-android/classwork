package com.akai.geektech.classwork.player;

import android.content.Context;
import android.net.Uri;

import com.akai.geektech.classwork.R;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class MediaPlayerImpl implements MediaPlayer {
    private Context mContext;
    private ExoPlayer mExoPlayer;

    private void initializePlayer() {
        DefaultTrackSelector trackSelector = new DefaultTrackSelector();
        DefaultLoadControl loadControl = new DefaultLoadControl();
        DefaultRenderersFactory renderersFactory = new DefaultRenderersFactory(mContext);

        mExoPlayer = ExoPlayerFactory.newSimpleInstance(renderersFactory, trackSelector, loadControl);
    }

    @Override
    public void play(String url) {
        String userAgent = Util.getUserAgent(mContext, mContext.getString(R.string.app_name));
        ExtractorMediaSource mediaSource = new ExtractorMediaSource
                .Factory(new DefaultDataSourceFactory(mContext, userAgent))
                .setExtractorsFactory(new DefaultExtractorsFactory())
                .createMediaSource(Uri.parse(url));
        mExoPlayer.prepare(mediaSource);
        mExoPlayer.setPlayWhenReady(true);
    }

    @Override
    public ExoPlayer getPlayerImpl(Context context) {
        mContext = context;
        initializePlayer();
        return mExoPlayer;
    }

    @Override
    public void releasePlayer() {
        mExoPlayer.stop();
        mExoPlayer.release();
    }
}
