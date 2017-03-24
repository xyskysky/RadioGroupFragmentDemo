package com.example.jwn.radiogroupfragment.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Administrator on 2017-03-23.
 */
public class ToastUtils
{
    /**
     * 在屏幕中央显示 Toast
     * @param context
     * @param text
     */
    public static void showToast(Context context, CharSequence text)
    {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
