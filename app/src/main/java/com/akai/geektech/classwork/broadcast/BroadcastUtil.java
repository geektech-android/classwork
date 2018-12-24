package com.akai.geektech.classwork.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.ViewGroup;

public class BroadcastUtil {
    public static final String STRING_INTENT_FILTER = "com.akai.geektech.classwork.broadcast.INTENT_FILTER_LESSON_6";
    public static final String MESSAGE_FIELD_KEY = "com.akai.geektech.classwork.broadcast.MESSAGE_FIELD_KEY";
    public static IntentFilter MESSAGE_INTENT_FILTER = new IntentFilter(STRING_INTENT_FILTER);

    private static LocalBroadcastManager getManager(Context context) {
        return LocalBroadcastManager.getInstance(context);
    }

    public static void registerLocalReceiver(Context context,
                                             BroadcastReceiver receiver,
                                             IntentFilter filter) {

        getManager(context).registerReceiver(receiver, filter);
    }

    public static void unregisterLocalReceiver(Context context,
                                               BroadcastReceiver receiver) {

        getManager(context).unregisterReceiver(receiver);
    }

    public static void sendMessage(Context context,
                                   String message) {

        Intent intent = new Intent(STRING_INTENT_FILTER);
        intent.putExtra(MESSAGE_FIELD_KEY, message);
        getManager(context).sendBroadcast(intent);
    }
}
