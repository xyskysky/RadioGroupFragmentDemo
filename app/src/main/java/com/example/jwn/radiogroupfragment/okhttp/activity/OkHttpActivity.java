package com.example.jwn.radiogroupfragment.okhttp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.okhttp.util.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpActivity extends Activity implements View.OnClickListener
{

    private static final int GET = 1;//Get请求
    private static final int POST = 2;//Post请求
    private static final String TAG = OkHttpActivity.class.getSimpleName();
    private TextView tv_title;
    private Button btn_okhttp_getpost;
    private TextView tv_result;//显示请求的结果

    private final String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

    //原生okHttp请求
    private OkHttpClient client = new OkHttpClient();

    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if (msg.what == GET)
            {
                tv_result.setText((String) msg.obj);
            } else if (msg.what == POST)
            {
                tv_result.setText((String) msg.obj);
            }
            super.handleMessage(msg);
        }
    };
    private Button btn_okhttputils_getpost;
    private Button btn_okhttputils_downfile;
    private Button btn_okhttputils_upfile;
    private ProgressBar pb_progress;
    private Button btn_okhttputils_image;
    private Button btn_okhttputils_imagelist;
    private ImageView iv_ico;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        initView();
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_okhttp_getpost:
                //调用原生的okhttp 进行get和post请求
                //getOkHttpDataFromGet();
                getOkHttpDataFromPost();
                break;
            case R.id.btn_okhttputils_getpost:
                //使用okhttp-utils进行get和post调用
                //getDataGetByOkhttpUtils();
                getDataPostByOkhttpUtils();
                break;
            case R.id.btn_okhttputils_dwonfile:
                downloadBigFile();
                break;
            case R.id.btn_okhttputils_upfile:
                multiFileUpload();
                break;
            case R.id.btn_okhttputils_image:
                getLoadImage();
                break;
            case R.id.btn_okhttputils_imagelist:
                Intent intent=new Intent(OkHttpActivity.this,OKHttpListActivity.class);
                startActivity(intent);
                break;


        }
    }

    private void getLoadImage()
    {
        String imageUrl="http://images.csdn.net/20150817/1.jpg";
        OkHttpUtils.get().url(imageUrl).id(100)
                         .tag(this).build().connTimeOut(20000)
                         .readTimeOut(20000).writeTimeOut(20000)
                         .execute(new BitmapCallback() {

                             @Override
                             public void onError(Call call, Exception e, int id)
                             {
                                 Log.i(TAG,"onError=====================:"+e.getMessage());
                                 e.printStackTrace();
                                 tv_result.setText(e.getMessage());
                             }

                             @Override
                             public void onBefore(Request request, int id)
                             {
                                 super.onBefore(request, id);
                                 Log.i(TAG,"onBefore=====================:"+id);
                             }

                             @Override
                             public void onAfter(int id)
                             {
                                 super.onAfter(id);
                                 Log.i(TAG,"onAfter=====================:"+id);
                             }

                             @Override
                             public void inProgress(float progress, long total, int id)
                             {
                                 super.inProgress(progress, total, id);
                                 Log.i(TAG,"inProgress==============progress:"+progress+"========total:"+total);
                             }

                             @Override
                             public boolean validateReponse(Response response, int id)
                             {
                                 Log.i(TAG,"validateReponse=====================:"+id);
                                 return super.validateReponse(response, id);
                             }

                             @Override
                             public void onResponse(Bitmap response, int id)
                             {
                                 Log.i(TAG,"onResponse=====================:"+id);
                                 iv_ico.setImageBitmap(response);
                             }
                         });
    }

    private void multiFileUpload()
    {
        String mBaseUrl = "http://192.168.0.78:8080/FileUpload/FileUploadServlet";
        File file1=new File(Environment.getExternalStorageDirectory(),"jwnsaic.apk");
        File file2=new File(Environment.getExternalStorageDirectory(),"//Download//mei2.jpg");

        if (!file1.exists()||!file2.exists())
        {
            Log.i(TAG,"文件不存在!");
            return;
        }
        Map<String,String> params=new HashMap<>();
        params.put("username","谢勇");
        params.put("password","123456");
        OkHttpUtils.post().url(mBaseUrl).id(100).addFile("mFile","server-jwnsaic.apk",file1)
                                                .addFile("mFile","server-mei2.jpg",file2)
                                                .params(params).build().execute(new MyStringCallback());


    }

    private void downloadBigFile()
    {
        String dwonload_url = "http://vfx.mtime.cn/Video/2016/07/24/mp4/160724055620533327_480.mp4";

        String destFileDir= Environment.getExternalStorageDirectory().getAbsolutePath();//文件存放路径
        String destFileName="okhttp-utils-test.mp4";//存放文件的名称
        OkHttpUtils.get().url(dwonload_url).id(100).build().execute(new FileCallBack(destFileDir,destFileName) {
            @Override
            public void onError(Call call, Exception e, int id)
            {
            }
            @Override
            public void onBefore(Request request, int id)
            {
                super.onBefore(request, id);
                Log.i(TAG,"onBefore========================================"+id);

            }

            @Override
            public void onAfter(int id)
            {
                super.onAfter(id);
                Log.i(TAG,"onAfter========================================"+id);
            }

            @Override
            public void inProgress(float progress, long total, int id)
            {
                super.inProgress(progress, total, id);
                Log.i(TAG,"inProgress===progress:"+progress+"=====total:"+total+"======"+id);
                pb_progress.setProgress((int) (100 * progress));
            }

            @Override
            public boolean validateReponse(Response response, int id)
            {
                Log.i(TAG,"validateReponse========================================"+id);
                return super.validateReponse(response, id);
            }

            @Override
            public void onResponse(File response, int id)
            {
                Log.i(TAG,"onResponse=====文件名："+response.getName()+"=====文件大小："+response.length()+"====="+id);
            }
        });
    }

    private void getDataPostByOkhttpUtils()
    {
       OkHttpUtils.post().url(url).id(100).build().execute(new MyStringCallback());
        /*
        //传json数据到接口
        String saicUrl="http://114.55.105.25:8080/qrsys/api/station";
        String content="{\n" +
               "    \"stationCode\":\"4104030\"\n" +
               "}";
        OkHttpUtils.postString().url(saicUrl).id(100)
                .mediaType(MediaType.parse("application/json;charset=utf-8"))
                .content(content).build().execute(new MyStringCallback());
         */


    }

    /**
     * 使用okhttp-utis进行get请求数据
     */
    private void getDataGetByOkhttpUtils()
    {
        OkHttpUtils.get().url(url).id(100).build().execute(new MyStringCallback());
    }

    private class MyStringCallback extends StringCallback
    {

        @Override
        public void onBefore(Request request, int id)
        {
            super.onBefore(request, id);
            Log.i(TAG, "onBefore======" + id);
        }

        @Override
        public void onAfter(int id)
        {
            super.onAfter(id);
            Log.i(TAG, "onAfter======" + id);
        }

        @Override
        public void inProgress(float progress, long total, int id)
        {
            super.inProgress(progress, total, id);
            Log.i(TAG, "inProgress=====progress:" + progress + " total:" + total + "  id=" + id);
        }

        @Override
        public boolean validateReponse(Response response, int id)
        {
            Log.i(TAG, "validateReponse=======" + id);
            return super.validateReponse(response, id);

        }

        //出错时调用
        @Override
        public void onError(Call call, Exception ex, int id)
        {
            ex.printStackTrace();
            tv_result.setText("调用出错:" + ex.getMessage());
        }

        @Override
        public void onResponse(String response, int id)
        {
            Log.i(TAG, "onResponse======结果:"+response);
            tv_result.setText("返回结果:" + response);

            switch (id)
            {
                case 100:
                    ToastUtils.showToast(OkHttpActivity.this, "Http协议");
                    break;
                case 101:
                    ToastUtils.showToast(OkHttpActivity.this, "Https协议");
                    break;
            }
        }

    }


    /**
     * 原生OkHttp进行Post请求
     */
    private void getOkHttpDataFromPost()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                MediaType contentType = MediaType.parse("application/json;charset=utf-8");
                String json = "";
                RequestBody body = RequestBody.create(contentType, json);
                Request request = new Request.Builder().url(url).post(body).build();

                try
                {
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();
                    Message msg = mHandler.obtainMessage();
                    msg.what = POST;
                    msg.obj = result;
                    mHandler.sendMessage(msg);

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 原生OkHttp进行Get请求
     */
    private void getOkHttpDataFromGet()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                //进行get请求
                try
                {
                    Request request = new Request.Builder().url(url).build();
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();//返回的结果
                    Log.i(TAG, result);
                    Message msg = Message.obtain();
                    msg.what = GET;
                    msg.obj = result;
                    mHandler.sendMessage(msg);

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initView()
    {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("OkHttp");
        tv_result = (TextView) findViewById(R.id.tv_result);
        btn_okhttp_getpost = (Button) findViewById(R.id.btn_okhttp_getpost);
        btn_okhttp_getpost.setOnClickListener(this);
        btn_okhttputils_getpost = (Button) findViewById(R.id.btn_okhttputils_getpost);
        btn_okhttputils_getpost.setOnClickListener(this);
        btn_okhttputils_downfile = (Button) findViewById(R.id.btn_okhttputils_dwonfile);
        btn_okhttputils_upfile = (Button) findViewById(R.id.btn_okhttputils_upfile);
        btn_okhttputils_downfile.setOnClickListener(this);
        btn_okhttputils_upfile.setOnClickListener(this);
        pb_progress = (ProgressBar) findViewById(R.id.progressBar);
        btn_okhttputils_image = (Button) findViewById(R.id.btn_okhttputils_image);
        btn_okhttputils_imagelist = (Button) findViewById(R.id.btn_okhttputils_imagelist);
        btn_okhttputils_image.setOnClickListener(this);
        btn_okhttputils_imagelist.setOnClickListener(this);
        iv_ico = (ImageView) findViewById(R.id.iv_icon);

    }


}
