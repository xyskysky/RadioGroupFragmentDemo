package com.example.jwn.radiogroupfragment.xutils3.annotation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.okhttp.util.ToastUtils;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

//Fragment 使用 xutils3注解
@ContentView(R.layout.fragment_demo)
public class DemoFragment extends Fragment
{
    @ViewInject(R.id.tv_text)
    private TextView tv_text;
    @ViewInject(R.id.btn_fragment)
    private Button btn_fragment;
    private Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mContext=getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //在Fragment中进行注解
      return  x.view().inject(this,inflater,container);
    }

    //使用xutils3j进行注解
    @Event(value = R.id.btn_fragment)
    public void onClick(View view)
    {
        ToastUtils.showToast(mContext,"我是按钮，我在fragment中初始化，并且被点击了");
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        tv_text.setText("我在Fragment中初始化了....");
    }
}
