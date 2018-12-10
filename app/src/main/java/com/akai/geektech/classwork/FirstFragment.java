package com.akai.geektech.classwork;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends BaseTabFragment {
    private static final String TITLE = "Tab1";

    public static BaseTabFragment getInstance() {
        return new FirstFragment();
    }

    public String getTitle() {
        return TITLE;
    }

    public FirstFragment() {
        Log.d("ololo", "FirstFragment constructor");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}
