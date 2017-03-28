package com.example.jwn.radiogroupfragment.afinal;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.example.jwn.radiogroupfragment.R;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class AfinalActivity extends FinalActivity
{

    private static final String TAG = AfinalActivity.class.getSimpleName();
    @ViewInject(id = R.id.bt_afinal_loadimage,click ="onClick")
    private Button bt_afinal_loadimage;
    @ViewInject(id=R.id.bt_afinal_gettext,click ="onClick")
    private Button bt_afinal_gettext;

    @ViewInject(id=R.id.bt_afinal_loadfile,click = "onClick")
    private Button bt_afinal_loadfile;

    @ViewInject(id=R.id.bt_afinal_updatetext,click = "onClick")
    private Button bt_afinal_updatetext;

    @ViewInject(id=R.id.iv_afinal)
    private ImageView iv_afinal;

    @ViewInject(id=R.id.tv_afinal_result)
    private TextView tv_afinal_result;

    @ViewInject(id=R.id.tv_title)
    private TextView tv_title;
    @ViewInject(id=R.id.pb_progress)
    private ProgressBar pb_progress;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afinal);
        tv_title.setText("AFinal解析");

    }
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_afinal_gettext:
                afinalGetText();
                break;
            case R.id.bt_afinal_loadfile:
                afinalLoadFile();
                break;
            case R.id.bt_afinal_loadimage:
                afinalLoadImage();
                break;
            case R.id.bt_afinal_updatetext:
                afinalUpdateText();
                break;
        }
    }

    //上传文件到服务器
    private void afinalUpdateText()
    {
        //发送文件要到的服务器
        String url  = "http://192.168.0.78:8080/FileUpload/FileUploadServlet";
        //文件上传
        iv_afinal.setVisibility(View.GONE);
        FinalHttp finalHttp=new FinalHttp();


       AjaxParams params=new AjaxParams();
        try
        {
            params.put("File",new File(getFilesDir()+"/afinalmusic.mp4"));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finalHttp.post(url, params, new AjaxCallBack<Object>()
        {
            @Override
            public void onStart()
            {
                tv_afinal_result.setText("文件开始上传");
                super.onStart();
            }

            @Override
            public void onLoading(long count, long current)
            {
                pb_progress.setProgress((int) ((current*100)/count));
                super.onLoading(count, current);
            }

            @Override
            public void onSuccess(Object file)
            {
                tv_afinal_result.setText("文件上传成功");
                super.onSuccess(file);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg)
            {
                tv_afinal_result.setText("文件上传失败");
                super.onFailure(t, errorNo, strMsg);
            }
        });


    }

    //加载图片HttpEntity params;
    private void afinalLoadImage()
    {
        iv_afinal.setVisibility(View.VISIBLE);
        FinalBitmap finalBitmap=FinalBitmap.create(AfinalActivity.this);
        //先设置显示默认图片
        finalBitmap.configLoadingImage(R.drawable.atguigu_logo);
        String url="http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
        finalBitmap.display(iv_afinal, url);

    }

    private void afinalLoadFile()
    {
        FinalHttp finalHttp=new FinalHttp();
        String url = "http://vfx.mtime.cn/Video/2016/10/11/mp4/161011092841270064_480.mp4";

        iv_afinal.setVisibility(View.GONE);
        //存放视频的本地路径
        String target= getFilesDir()+"/afinalmusic.mp4";
        finalHttp.download(url, target, new AjaxCallBack<File>()
        {
            @Override
            public void onStart()
            {
                super.onStart();
                tv_afinal_result.setText("文件开始下载");
                Log.i(TAG,"onStart============================");


            }

            @Override
            public void onLoading(long count, long current)
            {
                Log.i(TAG,"onLoading=======count:"+count+"==============current:"+current);
                pb_progress.setProgress((int) (current*100/count));
                super.onLoading(count, current);


            }

            @Override
            public void onSuccess(File file)
            {
                tv_afinal_result.setText("文件下载成功");
                Log.i(TAG,"onSuccess=========Name:"+file.getName()+"==size:"+file.length()+"==="+file.getAbsolutePath());
                super.onSuccess(file);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg)
            {
                tv_afinal_result.setText("文件开始失败:"+strMsg);
                Log.i(TAG,"onFailure====================:"+strMsg);
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }

    private void afinalGetText()
    {
        iv_afinal.setVisibility(View.GONE);
        FinalHttp finalHttp=new FinalHttp();
        String url="http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        finalHttp.get(url, new AjaxCallBack<Object>()
        {
            @Override
            public void onStart()
            {
                tv_afinal_result.setText("开始加载文本");
                Log.i(TAG,"onStart=========================");
            }

            @Override
            public void onSuccess(Object s)
            {
                super.onSuccess(s);
                tv_afinal_result.setText("加载结果:"+ s.toString());
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg)
            {
                tv_afinal_result.setText("加载失败:"+strMsg);
                super.onFailure(t, errorNo, strMsg);
                Log.i(TAG,"onFailure========="+strMsg);
                t.printStackTrace();
            }

            @Override
            public void onLoading(long count, long current)
            {
                super.onLoading(count, current);
                Log.i(TAG,"进度====onLoading======count:"+count+"=====current:"+current);
            }
        });
    }
}
