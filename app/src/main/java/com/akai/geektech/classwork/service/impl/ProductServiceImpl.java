package com.akai.geektech.classwork.service.impl;

import com.akai.geektech.classwork.data.db.ProductDao;
import com.akai.geektech.classwork.data.model.ProductEntity;
import com.akai.geektech.classwork.data.prefs.Preferences;
import com.akai.geektech.classwork.scheduler.Scheduler;
import com.akai.geektech.classwork.service.ProductService;

import java.util.List;
import java.util.concurrent.Callable;

public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl mInstance;
    private ProductDao mDao;
    private Preferences mPreferences;
    private Scheduler mScheduler;

    private ProductServiceImpl(ProductDao dao, Preferences preferences, Scheduler scheduler) {
        mDao = dao;
        mPreferences = preferences;
        mScheduler = scheduler;
    }

    public static ProductServiceImpl getInstance(ProductDao dao, Preferences preferences, Scheduler scheduler) {
        if (mInstance == null) {
            mInstance = new ProductServiceImpl(dao, preferences, scheduler);
        }
        return mInstance;
    }

    @Override
    public void addProduct(ProductEntity entity) {
        runWithFuture(() -> mDao.insert(entity));
    }

    @Override
    public ProductEntity getProduct(long id) {
        return (ProductEntity) runWithFuture(() -> mDao.getById(id));
    }

    @Override
    public List<ProductEntity> getProducts() {
        return (List<ProductEntity>) runWithFuture(() -> mDao.getAll());
    }

    private void runOnScheduler(Runnable runnable) {
        mScheduler.runOnThread(runnable);
    }

    private Object runWithFuture(Callable runnable) {
        return mScheduler.runWithFuture(runnable);
    }

}
