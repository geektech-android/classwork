package com.akai.geektech.classwork.ui.main;

import com.akai.geektech.classwork.data.network.VideoService;
import com.akai.geektech.classwork.data.network.model.ApiResponse;

import java.lang.ref.WeakReference;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {
    private WeakReference<MainContract.View> mView;
    private CompositeDisposable mDisposables = new CompositeDisposable();

    MainPresenter(MainContract.View view) {
        mView = new WeakReference<>(view);
    }

    @Override
    public void fetchSampleVideos() {
        Disposable disposable = VideoService.fetchVideos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onVideosFetchSuccessfully, this::onVideoFetchError);

        mDisposables.add(disposable);
    }

    @Override
    public void deactivate() {
        mDisposables.clear();
    }

    private void onVideosFetchSuccessfully(ApiResponse videoData) {
        mView.get().renderVideos(videoData.getResources());
    }

    private void onVideoFetchError(Throwable throwable) {
        mView.get().showErrorMessage();
    }
}
