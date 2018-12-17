package com.akai.geektech.classwork.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.akai.geektech.classwork.data.model.UserEntity;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE id = :id")
    UserEntity getById(long id);

    @Insert
    long insert(UserEntity entity);

    @Update
    void update(UserEntity entity);

    @Delete
    void delete(UserEntity entity);
}
