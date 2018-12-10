package com.akai.geektech.classwork;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mPager;
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mTabLayout = findViewById(R.id.tab_layout);
        mPager = findViewById(R.id.view_pager);
        mAdapter = new PagerAdapter(getSupportFragmentManager(), getFragments());
        mPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_first: mPager.setCurrentItem(0); break;
            case R.id.item_second: mPager.setCurrentItem(1); break;
            case R.id.item_third: mPager.setCurrentItem(2); break;
            default: return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private List<BaseTabFragment> getFragments() {
        List<BaseTabFragment> list = new ArrayList<>();
        list.add(FirstFragment.getInstance());
        list.add(SecondFragment.getInstance());
        list.add(ThirdFragment.getInstance());
        return list;
    }
}
