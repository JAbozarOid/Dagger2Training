package com.example.daggersample.login;

public interface LoginRepository {

    // two method one for getUser and the other for save user in memory

    User getUser();

    void saveUser(User user);
}
