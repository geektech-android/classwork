package com.akai.geektech.classwork.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.akai.geektech.classwork.R;
import com.akai.geektech.classwork.data.SourceProvider;
import com.akai.geektech.classwork.service.ProductService;

public class MainActivity extends AppCompatActivity {
    private Button mBtnProfile;
    private Button mBtnAddProduct;
    private RecyclerView mRecyclerProduct;

    private ProductService mProductService;
    private ProductAdapter mAdapter;

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProductService = SourceProvider.getProductService(this);
        mBtnProfile = findViewById(R.id.btn_profile);
        mBtnAddProduct = findViewById(R.id.btn_addProduct);
        mRecyclerProduct = findViewById(R.id.recycler_product);

        mBtnAddProduct.setOnClickListener(view -> startActivity(ProductAddActivity.getIntent(this)));
        mBtnProfile.setOnClickListener((view -> startActivity(ProfileActivity.getIntent(this))));

        mAdapter = new ProductAdapter(mProductService.getProducts());
        mRecyclerProduct.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerProduct.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.onProductListUpdated(mProductService.getProducts());
    }
}
