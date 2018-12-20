package com.akai.geektech.classwork.service.impl;

import com.akai.geektech.classwork.data.db.ProductDao;
import com.akai.geektech.classwork.data.model.Product;
import com.akai.geektech.classwork.data.prefs.Preferences;
import com.akai.geektech.classwork.scheduler.Scheduler;
import com.akai.geektech.classwork.service.ProductService;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl mInstance;
    private ProductDao mDao;
    private Preferences mPreferences;
    private Scheduler mScheduler;
    private List<Product> mProductList;
    private Product mProduct;
    private long mProductId;

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
        Future future = runWithFuture(() -> mProductId = mDao.insert(product));
        futureGet(future);
    }

    @Override
    public Product getProduct(long id) {
        Future future = runWithFuture(() -> mProduct = mDao.getById(id));
        futureGet(future);
        return mProduct;
    }

    @Override
    public List<Product> getProducts() {
        Future future = runWithFuture(() -> mProductList = mDao.getAll());
        futureGet(future);
        return mProductList;
    }

    private void runOnScheduler(Runnable runnable) {
        mScheduler.runOnThread(runnable);
    }

    private Future runWithFuture(Runnable runnable) {
        return mScheduler.runWithFuture(runnable);
    }

    private void futureGet(Future future) {
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
