package com.example.jwn.radiogroupfragment.volley.adapter;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.jwn.radiogroupfragment.volley.BitmapCache;

/**
 * Created by Administrator on 2017-03-31.
 */

public class ImageCacheManager
{
    private  ImageCacheManager(){}

    private  static ImageCacheManager instance=new ImageCacheManager();
    public  static  ImageCacheManager getInstance()
    {
        return  instance;
    }
    public ImageLoader getImageLoader(Context context)
    {
        //请求队列
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        ImageLoader imageLoader=new ImageLoader(requestQueue,new BitmapCache());
        return  imageLoader;
    }
}
