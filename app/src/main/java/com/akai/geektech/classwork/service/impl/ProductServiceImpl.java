package com.akai.geektech.classwork.service.impl;

import com.akai.geektech.classwork.data.db.ProductDao;
import com.akai.geektech.classwork.data.model.Product;
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
    public void addProduct(Product product) {
        runWithFuture(() -> mDao.insert(product));
    }

    @Override
    public Product getProduct(long id) {
        return (Product) runWithFuture(() -> mDao.getById(id));
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) runWithFuture(() -> mDao.getAll());
    }

    private void runOnScheduler(Runnable runnable) {
        mScheduler.runOnThread(runnable);
    }

    private Object runWithFuture(Callable runnable) {
        return mScheduler.runWithFuture(runnable);
    }

}
