package com.akai.geektech.classwork.service.impl;

import com.akai.geektech.classwork.data.db.UserDao;
import com.akai.geektech.classwork.data.model.UserEntity;
import com.akai.geektech.classwork.data.prefs.Preferences;
import com.akai.geektech.classwork.scheduler.Scheduler;
import com.akai.geektech.classwork.service.UserService;

import java.util.concurrent.Callable;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl mInstance;
    private UserDao mDao;
    private Preferences mPreferences;
    private Scheduler mScheduler;

    private UserServiceImpl(UserDao dao, Preferences preferences, Scheduler scheduler) {
        mDao = dao;
        mPreferences = preferences;
        mScheduler = scheduler;
    }

    public static UserServiceImpl getInstance(UserDao dao, Preferences preferences, Scheduler scheduler) {
        if (mInstance == null) {
            mInstance = new UserServiceImpl(dao, preferences, scheduler);
        }
        return mInstance;
    }

    @Override
    public boolean isAuth() {
        return mPreferences.isAuth();
    }

    @Override
    public void saveId(long id) {
        mPreferences.saveUserId(id);
    }

    @Override
    public long getId() {
        return mPreferences.getUserId();
    }

    @Override
    public UserEntity getUser(long id) {
        return (UserEntity) runWithFuture(() -> mDao.getById(id));
    }

    @Override
    public long saveUser(UserEntity entity) {
        return (long) runWithFuture(() -> mDao.insert(entity));
    }

    @Override
    public UserEntity updateUser(UserEntity entity) {
        runOnScheduler(() -> mDao.update(entity));
        return null;
    }

    @Override
    public void deleteUser(UserEntity entity) {
        runOnScheduler(() -> mDao.delete(entity));
    }

    @Override
    public void signOut(UserEntity user) {
        deleteUser(user);
        mPreferences.clear();
    }

    private void runOnScheduler(Runnable runnable) {
        mScheduler.runOnThread(runnable);
    }

    private Object runWithFuture(Callable runnable) {
        return mScheduler.runWithFuture(runnable);
    }
}
