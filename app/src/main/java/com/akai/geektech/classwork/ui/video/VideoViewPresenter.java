package com.akai.geektech.classwork.ui.video;

import com.akai.geektech.classwork.player.MediaPlayer;
import com.akai.geektech.classwork.player.MediaPlayerImpl;

public class VideoViewPresenter implements VideoViewContract.Presenter {
    private MediaPlayer mMediaPlayer = new MediaPlayerImpl();

    @Override
    public MediaPlayer getPlayer() {
        return mMediaPlayer;
    }

    @Override
    public void play(String url) {
        mMediaPlayer.play(url);
    }

    @Override
    public void releasePlayer() {
        mMediaPlayer.releasePlayer();
    }
}
