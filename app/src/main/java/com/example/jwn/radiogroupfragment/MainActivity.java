package com.example.jwn.radiogroupfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.jwn.radiogroupfragment.base.BaseFragment;
import com.example.jwn.radiogroupfragment.fragment.CommonFrameFragment;
import com.example.jwn.radiogroupfragment.fragment.CustomFragment;
import com.example.jwn.radiogroupfragment.fragment.OtherFragment;
import com.example.jwn.radiogroupfragment.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity
{
    private RadioGroup rg_group;
    private List<BaseFragment> mBaseFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        setListener();
    }

    /**
     * 选中的Fragment的对应的位置
     */
    private int position;
    /**
     * 上次切换的Fragment
     */
    private Fragment mFragment;

    class MyCheckedChangeListener implements RadioGroup.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            switch (checkedId)
            {
                case R.id.rb_common_frame:
                    position = 0;
                    break;
                case R.id.rb_thirdparty:
                    position = 1;
                    break;
                case R.id.rb_custom:
                    position = 2;
                    break;
                case R.id.rb_other:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;

            }
            BaseFragment toFragment = getFragment(position);
            switchFragment(mFragment, toFragment);
            //switchFragment(toFragment);
        }
    }

    private void switchFragment(Fragment fromFragment, Fragment toFragment)
    {

        if (fromFragment != toFragment)
        {
            //注意 局部变量 和 函数参数 同名 造成的异常问题。
            mFragment = toFragment;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            //判断是否已经添加
            if (toFragment.isAdded())
            {
                //已经被添加
                if (fromFragment != null)
                {
                    ft.hide(fromFragment);

                }
                if (toFragment != null)
                {
                    ft.show(toFragment).commit();
                }
            } else
            {
                //没有被添加
                if (fromFragment != null)
                {
                    ft.hide(fromFragment);
                }
                if (toFragment != null)
                {
                    ft.add(R.id.fl_content, toFragment).commit();
                }
            }
        }
    }


    /**
     * 每次点击 都会初始化 Fragment 页面 和 数据
     * @param fragment
     */
    private void switchFragment(BaseFragment fragment)
    {
        //1.得到FragmentManger
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        //3.替换
        transaction.replace(R.id.fl_content, fragment);
        //4.提交事务
        transaction.commit();
    }

    private void setListener()
    {
        rg_group.setOnCheckedChangeListener(new MyCheckedChangeListener());
        rg_group.check(R.id.rb_common_frame);
    }

    private void initFragment()
    {
        mBaseFragmentList = new ArrayList<>();
        mBaseFragmentList.add(new CommonFrameFragment());
        mBaseFragmentList.add(new ThirdPartyFragment());
        mBaseFragmentList.add(new CustomFragment());
        mBaseFragmentList.add(new OtherFragment());

    }

    private BaseFragment getFragment(int position)
    {
        BaseFragment fragment = mBaseFragmentList.get(position);
        return fragment;
    }

    private void initView()
    {

        rg_group = (RadioGroup) findViewById(R.id.rg_group);
    }


}
