package com.example.daggersample;


import javax.inject.Singleton;
import dagger.Component;

/**
 * application component is for dagger knows where the inject dependency to.
 * in dagger 2 the injector class called component
 * this component assign refrences in our activities ,  services,or fragments
 */

// یک interface هست که بین moduleها (یعنی کلاس‌های تامین کننده وابستگی) و injectها (یعنی جاهایی که وابستگی داریم) ارتباط بر قرار میکنن.
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity target);
}
