package com.akai.geektech.classwork.scheduler;

import java.util.concurrent.Callable;

public interface Scheduler {

    void runOnThread(Runnable runnable);

    Object runWithFuture(Callable callable);
}
