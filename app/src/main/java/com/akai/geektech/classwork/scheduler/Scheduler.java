package com.akai.geektech.classwork.scheduler;

import java.util.concurrent.Future;

public interface Scheduler {

    void runOnThread(Runnable runnable);

    Future runWithFuture(Runnable runnable);
}
