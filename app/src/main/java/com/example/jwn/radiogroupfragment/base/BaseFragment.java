package com.example.jwn.radiogroupfragment.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jwn.radiogroupfragment.util.ToastUtils;

/**
 * Created by Administrator on 2017-03-23.
 */

public abstract class BaseFragment extends Fragment
{
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return initView();
    }

    protected void showToast(CharSequence text)
    {
        ToastUtils.showToast(mContext, text);
    }

    /**
     * 强制子类重写，实现子类特有的ui
     *
     * @return
     */
    public abstract View initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 当孩子需要初始化数据，或者联网请求绑定数据，展示数据的 等等可以重写该方法
     */
    protected void initData()
    {
    }


}
