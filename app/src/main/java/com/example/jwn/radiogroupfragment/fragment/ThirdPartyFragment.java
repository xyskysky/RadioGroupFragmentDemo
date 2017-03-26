package com.example.jwn.radiogroupfragment.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.okhttp.base.BaseFragment;



/**
 * Created by Administrator on 2017-03-23.
 */

public class ThirdPartyFragment extends BaseFragment
{
    private static final String TAG = ThirdPartyFragment.class.getSimpleName();
    private TextView textView;

    @Override
    public View initView()
    {

        Log.i(TAG,"第三方控件Fragment页面被初始化了........");
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
        textView.setText("第三方框架");
        Log.i(TAG,"第三方控件数据初始化了...........");
    }
}
