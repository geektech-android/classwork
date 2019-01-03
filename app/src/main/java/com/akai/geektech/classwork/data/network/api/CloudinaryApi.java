package com.akai.geektech.classwork.data.network.api;

import com.akai.geektech.classwork.data.network.model.ApiResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CloudinaryApi {

    @GET("demo/video/list/samples.json")
    Single<ApiResponse> fetchVideos();
}
