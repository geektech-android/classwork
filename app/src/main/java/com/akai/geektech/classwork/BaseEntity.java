package com.akai.geektech.classwork;

import android.arch.persistence.room.PrimaryKey;

abstract class BaseEntity {

    @PrimaryKey
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
