package com.tallto.card;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application{
    private static MyApplication applicationInstance;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance = this;
        context = getApplicationContext();
    }

    public static MyApplication get() {
        return applicationInstance;
    }
    public static MyApplication getInstance() {
        return applicationInstance;
    }
    public static Context getContextObject(){
        return context;
    }
}
