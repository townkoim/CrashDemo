package com.example.lb.crash.crashdemo.activity;

import android.os.Bundle;

import com.example.lb.crash.crashdemo.FileUtils;
import com.example.lb.crash.crashdemo.R;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void sendErrorMsg(){
        //得到错误的日志
        String errorMsg= FileUtils.getErrorLog();
        //然后就可以将这个errorMsg上传到服务器了。 上传完成之后，再调用下面的方法，将日志文件删除
        FileUtils.deleteErrorLog();;
    }
}
