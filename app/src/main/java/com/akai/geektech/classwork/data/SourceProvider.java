package com.akai.geektech.classwork.data;

import android.content.Context;

import com.akai.geektech.classwork.App;
import com.akai.geektech.classwork.data.prefs.PreferencesImpl;
import com.akai.geektech.classwork.scheduler.SingleThreadScheduler;
import com.akai.geektech.classwork.service.ProductService;
import com.akai.geektech.classwork.service.UserService;
import com.akai.geektech.classwork.service.impl.ProductServiceImpl;
import com.akai.geektech.classwork.service.impl.UserServiceImpl;

public class SourceProvider {

    public static UserService getUserService(Context context) {
        return UserServiceImpl.getInstance(App.getDb(context).userDao(), PreferencesImpl.getInstance(context), SingleThreadScheduler.getInstance());
    }

    public static ProductService getProductService(Context context) {
        return ProductServiceImpl.getInstance(App.getDb(context).productDao(), PreferencesImpl.getInstance(context), SingleThreadScheduler.getInstance());
    }
}
