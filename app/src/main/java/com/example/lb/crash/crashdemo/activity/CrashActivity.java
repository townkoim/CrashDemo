package com.example.lb.crash.crashdemo.activity;

import android.os.Bundle;
import android.provider.Settings;

/**
 * Created by Administrator on 2016/5/13.
 */
public class CrashActivity extends  BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在这里我模拟一个数字越界,然后就会抛出数组越界的异常
        int [] array = new int[]{1,2,3};
        int a=array[5];
        System.out.println(a);
    }
}
