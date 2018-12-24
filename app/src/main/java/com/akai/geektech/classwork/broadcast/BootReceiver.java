package com.akai.geektech.classwork.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.akai.geektech.classwork.MainActivity;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("ololo", "Boot receiver");

        Intent intent1 = new Intent(context, MainActivity.class);
        context.startActivity(intent1);
    }
}
