package com.example.jwn.radiogroupfragment;

import android.app.Application;
import org.xutils.x;

/**
 * Created by Administrator on 2017-03-23.
 */

public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        //xutils3在此初始化
        x.Ext.init(this);
        // 是否输出debug日志, 开启debug会影响性能.
        x.Ext.setDebug(true);

    }
}
