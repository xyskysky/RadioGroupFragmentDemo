package com.example.jwn.radiogroupfragment;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

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

        //初始化Imageloader
        initImageLoader(this);

    }

    private void initImageLoader(Context context)
    {
        // 初始化参数
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)               // 线程优先级
                .denyCacheImageMultipleSizesInMemory()                  // 当同一个Uri获取不同大小的图片，缓存到内存时，只缓存一个。默认会缓存多个不同的大小的相同图片
                .discCacheFileNameGenerator(new Md5FileNameGenerator()) // 将保存的时候的URI名称用MD5
                .tasksProcessingOrder(QueueProcessingType.LIFO)         // 设置图片下载和显示的工作队列排序
                .writeDebugLogs()                                       // 打印debug log
                .build();
        ImageLoader.getInstance().init(config);
    }
}
