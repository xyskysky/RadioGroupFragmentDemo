package com.example.jwn.radiogroupfragment.xutils3.annotation;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_fragment_xutils)
public class FragmentXutilsActivity extends FragmentActivity
{

    @ViewInject(R.id.tv_title)
    private TextView tv_title;
    @ViewInject(R.id.fl_content)
    private FrameLayout fl_content;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //进行注解
        x.view().inject(this);
        tv_title.setText("Fragment中使用Xutils3注解");
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fl_content,new DemoFragment());
        //提交
        transaction.commit();

    }
}
