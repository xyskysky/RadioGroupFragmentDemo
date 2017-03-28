package com.example.jwn.radiogroupfragment.xutils3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.okhttp.util.ToastUtils;
import com.example.jwn.radiogroupfragment.xutils3.annotation.FragmentXutilsActivity;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

//使用xutils3进行注解
@ContentView(R.layout.activity_xutils)
public class XutilsActivity extends Activity
{

    //使用xutils3进行注解
    @ViewInject(R.id.tv_title)
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //使用注解
        x.view().inject(this);
        tv_title.setText("Xutils3详解");
    }
    @Event(value ={R.id.btn_annotation,R.id.btn_net,R.id.btn_image,R.id.btn_image_list})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_annotation:
                Intent intent=new Intent(XutilsActivity.this, FragmentXutilsActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_net:
                break;
            case R.id.btn_image:
                break;
            case R.id.btn_image_list:
                break;
        }
    }
}
