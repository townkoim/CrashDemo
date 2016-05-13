package com.example.lb.crash.crashdemo;

import android.app.Application;

/**
 * Created by Administrator on 2016/5/13.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(getApplicationContext());
    }
}
