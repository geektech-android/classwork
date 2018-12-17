package com.akai.geektech.classwork.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.akai.geektech.classwork.R;
import com.akai.geektech.classwork.data.SourceProvider;
import com.akai.geektech.classwork.data.model.UserEntity;
import com.akai.geektech.classwork.service.UserService;

public class AuthActivity extends AppCompatActivity {
    public static final String AUTH_KEY = "com.akai.geektech.classwork.view.AUTH_KEY";

    private TextView mTextEmail;
    private EditText mEditPassword;
    private Button mBtnSignIn;
    private UserService mUserService;
    private UserEntity mUser;

    public static Intent getIntent(Context context) {
        return new Intent(context, AuthActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        mUserService = SourceProvider.getUserService(this);

        mTextEmail = findViewById(R.id.text_email);
        mEditPassword = findViewById(R.id.edit_password);
        mBtnSignIn = findViewById(R.id.btn_signIn);

        mUser = mUserService.getUser(mUserService.getId());
        mTextEmail.setText(mUser.getEmail());
        mBtnSignIn.setOnClickListener(this::onSignInClicked);
    }

    private void onSignInClicked(View view) {
        String password = mEditPassword.getText().toString();
        if (password.equals(mUser.getPassword())) {
            startActivity(MainActivity.getIntent(this));
            finish();
        } else {
            mEditPassword.setError("Invalid password");
        }
    }
}
