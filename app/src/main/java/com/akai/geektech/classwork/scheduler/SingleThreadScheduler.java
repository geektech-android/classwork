package com.akai.geektech.classwork.scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

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
    public Object runWithFuture(Callable callable) {
        FutureTask futureTask = new FutureTask<>(callable);
        SINGLE_THREAD_EXECUTOR.execute(futureTask);
        Object obj = null;
        try {
            obj = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
