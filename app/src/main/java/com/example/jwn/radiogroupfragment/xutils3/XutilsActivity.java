package com.example.jwn.radiogroupfragment.xutils3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.okhttp.util.ToastUtils;
import com.example.jwn.radiogroupfragment.xutils3.annotation.FragmentXutilsActivity;
import com.example.jwn.radiogroupfragment.xutils3.net.XutilsNetActivity;
import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

//使用xutils3进行注解
@ContentView(R.layout.activity_xutils)
public class XutilsActivity extends Activity
{

    private static final String TAG =XutilsActivity.class.getSimpleName() ;
    //使用xutils3进行注解
    @ViewInject(R.id.tv_title)
    private TextView tv_title;
    @ViewInject(R.id.iv_xutils_image)
    private ImageView iv_xutils_image;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //使用注解
        x.view().inject(this);
        tv_title.setText("Xutils3详解");
    }
    @Event(value ={R.id.btn_annotation,R.id.btn_net,R.id.btn_image,R.id.btn_image_list})
    private void getEvent(View view)
    {
        ToastUtils.showToast(XutilsActivity.this,view.getId()+"");
        switch (view.getId())
        {
            case R.id.btn_annotation:

                Intent intent=new Intent(XutilsActivity.this, FragmentXutilsActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_net:

                intent=new Intent(XutilsActivity.this, XutilsNetActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_image:
                loadNetWorkImage();
                break;
            case R.id.btn_image_list:
               intent=new Intent(XutilsActivity.this,XutilsImageListActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void loadNetWorkImage()
    {
        String url="http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
        x.image().bind(iv_xutils_image, url, new Callback.CommonCallback<Drawable>()
       {
           @Override
           public void onSuccess(Drawable result)
           {
               Log.e(TAG,"图片加载完成:"+result.toString());
           }

           @Override
           public void onError(Throwable ex, boolean isOnCallback)
           {
               Log.e(TAG,"图片加载异常 ："+ex.getMessage());
           }

           @Override
           public void onCancelled(CancelledException cex)
           {
               Log.e(TAG,"onCancelled ："+cex.getMessage());
           }

           @Override
           public void onFinished()
           {
               Log.e(TAG,"onFinished========================");
           }
       });
    }
}
