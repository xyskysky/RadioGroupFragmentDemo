package com.example.jwn.radiogroupfragment.volley;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.okhttp.domain.DataBean;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.List;

public class VolleyActivity extends Activity
{

    private static final String TAG =VolleyActivity.class.getSimpleName() ;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.bt_volley_get)
    Button mBtVolleyGet;
    @BindView(R.id.bt_volley_post)
    Button mBtVolleyPost;
    @BindView(R.id.bt_volley_getjson)
    Button mBtVolleyGetjson;
    @BindView(R.id.bt_volley_imagerequest)
    Button mBtVolleyImagerequest;
    @BindView(R.id.bt_volley_imageloader)
    Button mBtVolleyImageloader;
    @BindView(R.id.bt_volley_networkimageview)
    Button mBtVolleyNetworkimageview;
    @BindView(R.id.bt_volley_listimage)
    Button mBtVilleyListImage;
    @BindView(R.id.iv_volley_result)
    ImageView mIvVolleyResult;
    @BindView(R.id.iv_volley_networkimagview)
    NetworkImageView mIvVolleyNetworkimagview;
    @BindView(R.id.tv_volley_result)
    TextView mTvVolleyResult;

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        mContext=this;
        ButterKnife.bind(this);
        initData();
    }

    private void initData()
    {
        mTvTitle.setText("Volley解析");
    }
    @OnClick({R.id.bt_volley_get,R.id.bt_volley_getjson,R.id.bt_volley_imageloader,R.id.bt_volley_imagerequest
    ,R.id.bt_volley_networkimageview,R.id.bt_volley_post,R.id.bt_volley_listimage})
    void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_volley_get:
                volleyGetRequest();
                break;
            case R.id.bt_volley_post:
                volleyPostRequest();
                break;
            case R.id.bt_volley_getjson:
                volleyGetJsonRequest();
                break;
            case R.id.bt_volley_imageloader:
                volleyImageLoader();
                break;
            case R.id.bt_volley_imagerequest:
                volleyImageRequest();
                break;
            case R.id.bt_volley_networkimageview:
                volleyNetworkImageView();
                break;
            case R.id.bt_volley_listimage:
                Intent intent=new Intent(mContext,VolleyListImageActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void volleyNetworkImageView()
    {
        mIvVolleyNetworkimagview.setVisibility(View.VISIBLE);
        //1.创建一个请求队列
        RequestQueue requestQueue=Volley.newRequestQueue(mContext);
        //2.创建imageLoader加载图片
        ImageLoader imageLoader=new ImageLoader(requestQueue,new BitmapCache());
        //设置默认显示图片 和异常显示图片
         mIvVolleyNetworkimagview.setDefaultImageResId(R.drawable.atguigu_logo);
        mIvVolleyNetworkimagview.setErrorImageResId(R.drawable.atguigu_logo);

        mIvVolleyNetworkimagview.setImageUrl(imageUrl,imageLoader);

    }

    private String imageUrl="http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
    private void volleyImageRequest()
    {
        //1.创建一个请求队列
        RequestQueue requestQueue=Volley.newRequestQueue(mContext);

        //2.创建一个图片请求队列

        ImageRequest imageRequest=new ImageRequest(imageUrl, new Response.Listener<Bitmap>()
        {
            @Override
            public void onResponse(Bitmap bitmap)
            {
                //正确接收图片
                mIvVolleyResult.setVisibility(View.VISIBLE);
                mIvVolleyResult.setImageBitmap(bitmap);

            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError volleyError)
            {
                //请求图片错误 显示默认错误图片
                mIvVolleyResult.setImageResource(R.drawable.atguigu_logo);
            }
        });
        //3.将图片请求添加到请求队列中
        requestQueue.add(imageRequest);
    }

    //对加载的图片进行缓存处理
    private void volleyImageLoader()
    {
        mIvVolleyResult.setVisibility(View.VISIBLE);
        //1.创建请求队列
        RequestQueue requestQueue=Volley.newRequestQueue(mContext);

        //2.创建图片请求
       ImageLoader imageLoader=new ImageLoader(requestQueue,new BitmapCache());
        //加载图片
        ImageLoader.ImageListener imageListener = imageLoader.getImageListener(mIvVolleyResult,
                R.drawable.atguigu_logo, R.drawable.atguigu_logo);
        imageLoader.get(imageUrl,imageListener);
    }

    private void volleyGetJsonRequest()
    {
        //1.创建一个请求队列
        RequestQueue requestQueue=Volley.newRequestQueue(mContext);
        //2.创建一个json请求
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject jsonObject)
            {
                Gson gson=new Gson();
                DataBean dataBean=gson.fromJson(jsonObject.toString(),DataBean.class);
                mTvVolleyResult.setText(dataBean.toString());
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError volleyError)
            {
                Log.e(TAG,"JsonObjectRequest请求失败:"+volleyError.getMessage());
                mTvVolleyResult.setText("JsonObjectRequest请求失败:"+volleyError.getMessage());
            }
        });
        //3.将JsonObjectRequest 添加到请求队列
        requestQueue.add(jsonObjectRequest);

    }

    private void volleyPostRequest()
    {
        //1.创建一个请求队列
        RequestQueue requestQueue=Volley.newRequestQueue(mContext);

        //2.创建一个Post请求
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String result)
            {
                Log.e(TAG,"请求结果:"+result);
                mTvVolleyResult.setText("Post请求:"+result);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError volleyError)
            {
                Log.e(TAG,"Post请求失败:"+volleyError.getMessage());
                mTvVolleyResult.setText("Post请求失败:"+volleyError.getMessage());
            }
        });
        //3.将Post请求添加到亲戚队列
        requestQueue.add(stringRequest);
    }

    private String url="http://api.m.mtime.cn/PageSubArea/TrailerList.api";
    private void volleyGetRequest()
    {
        //1.创建一个请求队列
        RequestQueue requestQueue= Volley.newRequestQueue(mContext);
        //2.创建一个请求
        StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String result)
            {
                Log.e(TAG,"请求结果:"+result);
                mTvVolleyResult.setText("Get请求:"+result);

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError volleyError)
            {
                Log.e(TAG,"Get请求失败:"+volleyError.getMessage());
                mTvVolleyResult.setText("Get请求失败:"+volleyError.getMessage());
            }
        });
        //3将请求添加的请求队列
        requestQueue.add(stringRequest);
    }
}
