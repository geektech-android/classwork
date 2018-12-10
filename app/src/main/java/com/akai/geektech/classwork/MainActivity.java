package com.akai.geektech.classwork;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mPager;
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = findViewById(R.id.view_pager);
        mAdapter = new PagerAdapter(getSupportFragmentManager(), getFragments());
        mPager.setAdapter(mAdapter);
    }

    private List<Fragment> getFragments() {
        List<Fragment> list = new ArrayList<>();
        list.add(FirstFragment.getInstance());
        list.add(SecondFragment.getInstance());
        list.add(ThirdFragment.getInstance());
        return list;
    }
}
