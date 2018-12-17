package com.akai.geektech.classwork.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String fName;
    private String sName;
    private String email;
    private String password;
    private String phone;
    private String age;

    public UserEntity() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static class Builder {
        private String fName;
        private String sName;
        private String email;
        private String password;
        private String phone;
        private String age;

        public Builder first(String fName) {
            this.fName = fName;
            return this;
        }

        public Builder second(String sName) {
            this.sName = sName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserEntity build() {
            UserEntity entity = new UserEntity();
            entity.fName = this.fName;
            entity.sName = this.sName;
            entity.email = this.email;
            entity.password = this.password;
            return entity;
        }
    }
}
