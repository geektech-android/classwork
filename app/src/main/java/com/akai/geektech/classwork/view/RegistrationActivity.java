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
import com.akai.geektech.classwork.data.model.UserEntity;
import com.akai.geektech.classwork.service.UserService;

public class RegistrationActivity extends AppCompatActivity {
    private EditText mEditFirstName;
    private EditText mEditSecondName;
    private EditText mEditEmail;
    private EditText mEditPassword;
    private Button mBtnSignUp;

    private UserService mUserService;

    public static Intent getIntent(Context context) {
        return new Intent(context, RegistrationActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
    }

    private void onSignUpClicked(View view) {
        String fName = mEditFirstName.getText().toString();
        String sName = mEditSecondName.getText().toString();
        String email = mEditEmail.getText().toString();
        String pswrd = mEditPassword.getText().toString();

        UserEntity user = new UserEntity.Builder()
                .first(fName)
                .second(sName)
                .email(email)
                .password(pswrd)
                .build();

        long id = mUserService.saveUser(user);
        mUserService.saveId(id);
        startActivity(MainActivity.getIntent(this));
        finish();
    }

    private void init() {
        mUserService = SourceProvider.getUserService(this);

        mEditFirstName = findViewById(R.id.edit_fName);
        mEditSecondName = findViewById(R.id.edit_sName);
        mEditEmail = findViewById(R.id.edit_email);
        mEditPassword = findViewById(R.id.edit_password);
        mBtnSignUp = findViewById(R.id.btn_signUp);

        mBtnSignUp.setOnClickListener(this::onSignUpClicked);
    }
}
