package com.akai.geektech.classwork.player;

import android.content.Context;

import com.google.android.exoplayer2.ExoPlayer;

public interface MediaPlayer {

    void play(String url);

    ExoPlayer getPlayerImpl(Context context);

    void releasePlayer();
}
