package com.akai.geektech.classwork.data.network;

import com.akai.geektech.classwork.data.network.api.CloudinaryApi;
import com.akai.geektech.classwork.data.network.model.ApiResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class VideoService {
    private static final String BASE_URL = "https://res.cloudinary.com/";
    private static Retrofit mRetrofitInstance;

    public static Single<ApiResponse> fetchVideos() {
        return createCloudinaryVideoService().fetchVideos();
    }

    private static Retrofit createRetrofitInstance() {
        if (mRetrofitInstance == null) {
            mRetrofitInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofitInstance;
    }

    private static CloudinaryApi createCloudinaryVideoService() {
        return createRetrofitInstance().create(CloudinaryApi.class);
    }

}
