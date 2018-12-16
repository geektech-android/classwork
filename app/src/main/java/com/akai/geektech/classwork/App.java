package com.akai.geektech.classwork;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {
    private static App mInstance;
    private AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mDatabase = Room.databaseBuilder(this, AppDatabase.class, "Lesson4_Database").build();
    }

    private static App getInstance() {
        return mInstance;
    }

    public static AppDatabase getDb() {
        return getInstance().mDatabase;
    }
}
