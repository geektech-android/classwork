package com.akai.geektech.classwork.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesImpl implements Preferences {
    private static final String SHARED_TITLE = "com.akai.geektech.classwork";
    private static final String USER_ID_KEY = "com.akai.geektech.classwork.data.prefs.USER_ID_KEY";
    private static Preferences mInstance;
    private SharedPreferences mPreferences;

    private PreferencesImpl(Context context) {
        mPreferences = context.getSharedPreferences(SHARED_TITLE, Context.MODE_PRIVATE);
    }

    public static Preferences getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new PreferencesImpl(context);
        }
        return mInstance;
    }

    @Override
    public boolean isAuth() {
        return getUserId() >= 0;
    }

    @Override
    public long getUserId() {
        return mPreferences.getLong(USER_ID_KEY, -1);
    }

    @Override
    public void saveUserId(long id) {
        exec(editor -> editor.putLong(USER_ID_KEY, id));
    }

    @Override
    public void clear() {
        exec(SharedPreferences.Editor::clear);
    }

    private String getStringValue(String key) {
        return mPreferences.getString(key, "");
    }

    private void exec(EditorRunnable runnable) {
        SharedPreferences.Editor editor = mPreferences.edit();
        runnable.run(editor);
        editor.apply();
    }

    interface EditorRunnable {

        void run(SharedPreferences.Editor editor);
    }
}
