package com.example.daggersample.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * this class where dagger will keep track of dependencies
 */

// کلاس‌هایی که متدهاشون وابستگی‌های ما رو تامین (provide) میکنن.
    // کلاس های تامین وابستگی
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    /**
     * the singelton annotation also says to dagger compiler that the instance should be created only once in the application
     * @return
     */
    //  متدهاییه که داخل کلاس‌های Module هستن provide نام دارد
    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }
}
