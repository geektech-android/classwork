package com.akai.geektech.classwork.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.akai.geektech.classwork.data.model.ProductEntity;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM ProductEntity")
    List<ProductEntity> getAll();

    @Query("SELECT * FROM user WHERE id = :id")
    ProductEntity getById(long id);

    @Insert
    long insert(ProductEntity entity);

    @Update
    void update(ProductEntity entity);

    @Delete
    void delete(ProductEntity entity);
}
