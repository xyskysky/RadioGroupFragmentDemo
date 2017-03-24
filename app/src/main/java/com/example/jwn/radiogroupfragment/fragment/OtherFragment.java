package com.example.jwn.radiogroupfragment.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.base.BaseFragment;

/**
 * Created by Administrator on 2017-03-23.
 */

public class OtherFragment extends BaseFragment
{

    private static final String TAG = OtherFragment.class.getSimpleName();
    private TextView textView;

    @Override
    public View initView()
    {
        Log.i(TAG,"其他控件Fragment页面被初始化了......");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);

        return textView;
    }

    @Override
    protected void initData()
    {
        super.initData();
        textView.setText("其他控件");
        Log.i(TAG,"其他控件数据被初始化了.......");
    }
}
