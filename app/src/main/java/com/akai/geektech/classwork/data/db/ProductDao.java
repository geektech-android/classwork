package com.akai.geektech.classwork.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.akai.geektech.classwork.data.model.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    List<Product> getAll();

    @Query("SELECT * FROM user WHERE id = :id")
    Product getById(long id);

    @Insert
    long insert(Product entity);

    @Update
    void update(Product entity);

    @Delete
    void delete(Product entity);
}
