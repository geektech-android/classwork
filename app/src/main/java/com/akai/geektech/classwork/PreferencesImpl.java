package com.akai.geektech.classwork;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesImpl implements Preferences {
    private static final String STORAGE_TITLE = "com.akai.geektech.classwork.Lesson3";
    public static final String EMAIL_KEY = "com.akai.geektech.classwork.EMAIL_KEY";
    public static final String PASSWORD_KEY = "com.akai.geektech.classwork.PASSWORD_KEY";
    private static PreferencesImpl mInstance;

    private SharedPreferences mPreferences;

    private PreferencesImpl(Context context) {
        mPreferences = context.getSharedPreferences(STORAGE_TITLE, Context.MODE_PRIVATE);
    }

    public static Preferences getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new PreferencesImpl(context);
        }
        return mInstance;
    }

    @Override
    public boolean contains(String key) {
        return mPreferences.contains(EMAIL_KEY);
    }

    @Override
    public String getEmail() {
        return getStringValue(EMAIL_KEY);
    }

    @Override
    public void saveEmail(String email) {
        exec(editor -> editor.putString(EMAIL_KEY, email));
    }

    @Override
    public String getPassword() {
        return getStringValue(PASSWORD_KEY);
    }

    @Override
    public void savePassword(String password) {
        exec(editor -> editor.putString(PASSWORD_KEY, password));
    }

    @Override
    public void clear() {
        exec(SharedPreferences.Editor::clear);
    }

    private String getStringValue(String key) {
        return mPreferences.getString(key, "");
    }

    private void exec(PreferencesOperation call) {
        SharedPreferences.Editor editor = mPreferences.edit();
        call.operation(editor);
        editor.apply();
    }

    @FunctionalInterface
    interface PreferencesOperation {
        void operation(SharedPreferences.Editor editor);
    }
}
