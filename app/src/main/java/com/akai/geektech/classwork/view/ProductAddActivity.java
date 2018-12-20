package com.akai.geektech.classwork.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.akai.geektech.classwork.R;
import com.akai.geektech.classwork.data.SourceProvider;
import com.akai.geektech.classwork.data.model.Product;
import com.akai.geektech.classwork.service.ProductService;

public class ProductAddActivity extends AppCompatActivity {
    private EditText mEditProductName;
    private Button mBtnAdd;
    private ProductService mProductService;

    public static Intent getIntent(Context context) {
        return new Intent(context, ProductAddActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);
        mProductService = SourceProvider.getProductService(this);
        mEditProductName = findViewById(R.id.edit_productName);
        mBtnAdd = findViewById(R.id.btn_add);

        mBtnAdd.setOnClickListener((this::onCreateClicked));
    }

    private void onCreateClicked(View view) {
        String name = mEditProductName.getText().toString();
        Product product = new Product();
        product.setName(name);
        mProductService.addProduct(product);
        finish();
    }
}
