package com.example.lb.crash.crashdemo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.lb.crash.crashdemo.AppManager;

/**
 * Created by Administrator on 2016/5/13.
 */
public class BaseActivity extends Activity {
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=this;
        AppManager.getAppManager().addActivity(activity);
    }
}
