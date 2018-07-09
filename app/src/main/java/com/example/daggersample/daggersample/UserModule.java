package com.example.daggersample.daggersample;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


// این کلاس شامل متدهایی است که وابستگیمون را فراهم میکنه
@Module
public class UserModule {

    @Provides // . یعنی اگر جایی احتیاج به Contact داشتی بیا و از این provide استفاده کن
    @Singleton // به dagger میگیم که میخوایم یک نسخه از این شیء در برنامه وجود داشته باشه.
    Contact provideContact(){
        return new Contact();
    }

    @Provides
    @Singleton
    User provideUser(){
        return new User(new Contact());
    }

}
