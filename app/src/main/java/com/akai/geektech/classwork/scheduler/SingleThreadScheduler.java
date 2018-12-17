package com.akai.geektech.classwork.scheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadScheduler implements Scheduler {
    private static final ExecutorService SINGLE_THREAD_EXECUTOR = Executors.newSingleThreadExecutor();
    private static SingleThreadScheduler mInstance;

    private SingleThreadScheduler() {}

    public static Scheduler getInstance() {
        if (mInstance == null) {
            mInstance = new SingleThreadScheduler();
        }
        return mInstance;
    }

    @Override
    public void runOnThread(Runnable runnable) {
        SINGLE_THREAD_EXECUTOR.execute(runnable);
    }

    @Override
    public Future runWithFuture(Runnable runnable) {
        return SINGLE_THREAD_EXECUTOR.submit(runnable);
    }
}
