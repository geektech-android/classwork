package com.akai.geektech.classwork;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.akai.geektech.classwork.data.db.AppDatabase;

public class App extends Application {
    private AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mDatabase = Room.databaseBuilder(this, AppDatabase.class, "Lesson4_Database").build();
    }

    private static App getInstance(Context context) {
        return (App) context.getApplicationContext();
    }

    public static AppDatabase getDb(Context context) {
        return getInstance(context).mDatabase;
    }
}
