package com.akai.geektech.classwork.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.akai.geektech.classwork.data.model.ProductEntity;
import com.akai.geektech.classwork.data.model.UserEntity;

@Database(entities = {UserEntity.class, ProductEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract ProductDao productDao();
}
