package com.akai.geektech.classwork.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("resources")
    private List<ApiVideo> resources;

    @SerializedName("updated_at")
    private String updatedAt;

    public List<ApiVideo> getResources() {
        return resources;
    }

    public void setResources(List<ApiVideo> resources) {
        this.resources = resources;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
