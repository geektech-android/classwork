package com.akai.geektech.classwork;

public interface Preferences {

    boolean contains(String key);

    String getEmail();

    void saveEmail(final String email);

    String getPassword();

    void savePassword(String password);

    void clear();
}
