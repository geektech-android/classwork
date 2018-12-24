package com.akai.geektech.classwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.akai.geektech.classwork.broadcast.BroadcastUtil;

import static com.akai.geektech.classwork.broadcast.BroadcastUtil.MESSAGE_FIELD_KEY;
import static com.akai.geektech.classwork.broadcast.BroadcastUtil.MESSAGE_INTENT_FILTER;
import static com.akai.geektech.classwork.broadcast.BroadcastUtil.STRING_INTENT_FILTER;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceivers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BroadcastUtil.sendMessage(
                this, "Hello hey! I am broadcast receiver ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceivers();
    }

    private void registerReceivers() {
        BroadcastUtil.registerLocalReceiver(this,
                mBroadcastDataReceiver, MESSAGE_INTENT_FILTER);
        registerReceiver(
                mBroadcastTickReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
    }

    private void unregisterReceivers() {
        BroadcastUtil.unregisterLocalReceiver(
                this, mBroadcastDataReceiver);

        unregisterReceiver(mBroadcastTickReceiver);
    }

    BroadcastReceiver mBroadcastDataReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ololo", "message: " + intent.getStringExtra(MESSAGE_FIELD_KEY));
        }
    };

    BroadcastReceiver mBroadcastTickReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ololo", "Time tick!");
        }
    };

}
