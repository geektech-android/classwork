package com.akai.geektech.classwork;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AuthActivity extends AppCompatActivity {
    public static final String AUTH_KEY = "com.akai.geektech.classwork.AUTH_KEY";

    private TextView mTextEmail;
    private EditText mEditEmail;
    private EditText mEditPassword;
    private Button mBtnAuth;

    private Preferences mPreferences;
    private boolean isAuth;

    public static Intent getIntent(Context context, boolean isAuthenticated) {
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra(AUTH_KEY, isAuthenticated);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        init();
    }

    private void onAuthClicked(View view) {
        if (isAuth) {
            String pswrd = mEditPassword.getText().toString();
            if (pswrd.equals(mPreferences.getPassword())) {
                startActivity(MainActivity.getIntent(this));
                finish();
            } else {
                mEditPassword.setError("Invalid password");
            }
        } else {
            String email = mEditEmail.getText().toString();
            String pswrd = mEditPassword.getText().toString();

            if (!isValid(email, pswrd)) {
                return;
            }

            mPreferences.saveEmail(email);
            mPreferences.savePassword(pswrd);
            startActivity(MainActivity.getIntent(this));
            finish();
        }
    }

    private boolean isValid(String email, String password) {
        return isValidEmail(email) && isValidPassword(password);
    }

    private boolean isValidEmail(String email) {
        if (email.isEmpty() || !email.contains("@")) {
            mEditEmail.setError("Invalid email");
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password) {
        if (password.isEmpty()) {
            mEditPassword.setError("Invalid password");
            return false;
        }
        return true;
    }

    private void setUp() {
        Intent intent = getIntent();
        if (intent == null) {
            throw new IllegalArgumentException("Auth key argument is missing!");
        }

        isAuth = intent.getBooleanExtra(AUTH_KEY, false);
        mBtnAuth.setText(getString(isAuth ? R.string.sign_in : R.string.sign_up));
        mTextEmail.setText(mPreferences.getEmail());
        mTextEmail.setVisibility(isAuth ? View.VISIBLE : View.GONE);
        mEditEmail.setVisibility(isAuth ? View.GONE : View.VISIBLE);
        mBtnAuth.setOnClickListener(this::onAuthClicked);
    }

    private void init() {
        mPreferences = PreferencesImpl.getInstance(this);
        mTextEmail = findViewById(R.id.text_email);
        mEditEmail = findViewById(R.id.edit_email);
        mEditPassword = findViewById(R.id.edit_password);
        mBtnAuth = findViewById(R.id.btn_auth);
        setUp();
    }
}
