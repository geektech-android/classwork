package com.akai.geektech.classwork.ui.video;

import com.akai.geektech.classwork.player.MediaPlayer;

public interface VideoViewContract {

    interface View {

    }

    interface Presenter {

        MediaPlayer getPlayer();

        void play(String url);

        void releasePlayer();
    }
}
