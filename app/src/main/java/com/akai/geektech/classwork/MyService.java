package com.akai.geektech.classwork;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ololo", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        hardTask();
        return START_NOT_STICKY;
    }

    private void hardTask() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Log.d("ololo", "i: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stopSelf();
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ololo", "onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
