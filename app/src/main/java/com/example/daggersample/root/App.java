package com.example.daggersample.root;

import android.app.Application;

import com.example.daggersample.DaggerApplicationComponent;
import com.example.daggersample.login.LoginModel;
import com.example.daggersample.root.ApplicationComponent;
import com.example.daggersample.root.ApplicationModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .loginModule(new LoginModel())
                    .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
