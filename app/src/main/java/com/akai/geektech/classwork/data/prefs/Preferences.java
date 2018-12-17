package com.akai.geektech.classwork.data.prefs;

public interface Preferences {

    boolean isAuth();

    long getUserId();

    void saveUserId(long id);

    void clear();
}
