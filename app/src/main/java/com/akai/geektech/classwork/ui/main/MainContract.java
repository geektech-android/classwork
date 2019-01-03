package com.akai.geektech.classwork.ui.main;

import com.akai.geektech.classwork.data.network.model.ApiVideo;

import java.util.List;

public interface MainContract {

    interface View {

        void renderVideos(List<ApiVideo> videos);

        void showErrorMessage();
    }

    interface Presenter {

        void fetchSampleVideos();

        void deactivate();
    }
}
