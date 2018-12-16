package com.akai.geektech.classwork;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE email = :email")
    UserEntity getByEmail(String email);

    @Insert
    void insert(UserEntity entity);

    @Update
    void update(UserEntity entity);

    @Delete
    void delete(UserEntity entity);
}
