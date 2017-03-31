package com.example.jwn.radiogroupfragment.volley;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.ImageLoader;

/**
 * Volley进行图片缓存处理加载
 * Created by Administrator on 2017/3/30.
 */

public class BitmapCache implements ImageLoader.ImageCache
{
    private LruCache<String, Bitmap> mCache;
    public BitmapCache()
    {
        int maxSize = 10 * 1024 * 1024;// 10MB
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }
    @Override
    public Bitmap getBitmap(String url)
    {
        return mCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap)
    {
        mCache.put(url,bitmap);
    }
}
