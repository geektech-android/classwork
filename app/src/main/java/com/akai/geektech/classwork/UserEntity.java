package com.akai.geektech.classwork;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {

    @PrimaryKey
    private long id;
    private String fName;
    private String sName;
    private String email;
    private String password;
    private String phone;
    private String age;

    public UserEntity(String fName, String sName, String email, String password, String phone, String age) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
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
}
