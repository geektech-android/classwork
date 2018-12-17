package com.akai.geektech.classwork.service;

import com.akai.geektech.classwork.data.model.UserEntity;

public interface UserService {

    boolean isAuth();

    void saveId(long id);

    long getId();

    UserEntity getUser(long id);

    long saveUser(UserEntity entity);

    UserEntity updateUser(UserEntity entity);

    void deleteUser(UserEntity entity);

    void signOut(UserEntity entity);
}
