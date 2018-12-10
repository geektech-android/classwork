package com.akai.geektech.classwork;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mPager;
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tab_layout);
        mPager = findViewById(R.id.view_pager);
        mAdapter = new PagerAdapter(getSupportFragmentManager(), getFragments());
        mPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mPager);
    }

    private List<BaseTabFragment> getFragments() {
        List<BaseTabFragment> list = new ArrayList<>();
        list.add(FirstFragment.getInstance());
        list.add(SecondFragment.getInstance());
        list.add(ThirdFragment.getInstance());
        return list;
    }
}
