package com.example.jwn.radiogroupfragment.xutils3.net;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import org.xutils.common.Callback;
import org.xutils.common.task.PriorityExecutor;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.util.concurrent.Executor;

//使用Xutils注解
@ContentView(R.layout.activity_xutils_net)
public class XutilsNetActivity extends Activity
{


    private static final String TAG = XutilsNetActivity.class.getSimpleName();
    @ViewInject(R.id.btn_get)
    private Button btn_get;
    @ViewInject(R.id.btn_post)
    private Button btn_post;
    @ViewInject(R.id.btn_downloadfile)
    private Button btn_downloadfile;

    @ViewInject(R.id.btn_uploadfile)
    private Button btn_uploadfile;

    @ViewInject(R.id.tv_result)
    private TextView tv_result;
    @ViewInject(R.id.pb_progressbar)
    private ProgressBar pb_progressBar;

    @ViewInject(R.id.tv_title)
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //注册注解
        x.view().inject(this);
        tv_title.setText("Xutils3网络详解");

    }

    @Event(value = {R.id.btn_get,R.id.btn_post, R.id.btn_downloadfile, R.id.btn_uploadfile})
    private void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.btn_get:
                getRequest();
                break;
            case R.id.btn_post:
                postRequest();
                break;
            case R.id.btn_downloadfile:
                downloadFile();
                break;
            case R.id.btn_uploadfile:
                uploadFile();
                break;
        }
    }

    private void uploadFile()
    {
        String url="http://192.168.199.164:8080/FileUpload/FileUploadServlet";
        RequestParams params=new RequestParams(url);
        //以表单方式上传
        params.setMultipart(true);
        //设置上传文件的路径
        params.addBodyParameter("File",new File(Environment.getExternalStorageDirectory()+"/jwn/480.mp4"),null,"opop.mp4");

        x.http().post(params, new Callback.ProgressCallback<File>()
        {
            @Override
            public void onSuccess(File result)
            {
                tv_result.setText("文件上传成功:"+result.getAbsolutePath());
                Log.e(TAG,"文件上传成功:"+result.getAbsolutePath());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback)
            {
                tv_result.setText("文件上传出错:"+ex.getMessage());
                Log.e(TAG,"文件上传出错:"+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex)
            {
                Log.e(TAG,"onCancelled================="+cex.getMessage());
            }

            @Override
            public void onFinished()
            {
                Log.e(TAG,"onFinished=================");
            }

            @Override
            public void onWaiting()
            {
                Log.e(TAG,"onWaiting=================");
            }

            @Override
            public void onStarted()
            {
                Log.e(TAG,"onWaiting============文件开始上传=====");
                tv_result.setText("文件开始上传");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading)
            {
                pb_progressBar.setProgress((int) (current*100/total));
            }
        });
    }

    private void downloadFile()
    {
        String url="http://vfx.mtime.cn/Video/2016/09/15/mp4/160915092608935956_480.mp4";
        RequestParams params=new RequestParams(url);
        //设置文件保存路径
        params.setSaveFilePath(Environment.getExternalStorageDirectory()+"/jwn/480.mp4");
        //设置是否可以立即取消
        params.setCancelFast(true);
        //设置是否自动根据头信息命名
        params.setAutoRename(false);
        //设置是否支持断点续传
        params.setAutoResume(true);
        //自定义线程池,有效的值范围[1, 3], 设置为3时, 可能阻塞图片加载.
        params.setExecutor(new PriorityExecutor(5,true));
        x.http().get(params, new Callback.ProgressCallback<File>()
        {
            @Override
            public void onSuccess(File result)
            {
                Log.e(TAG,"文件下载成功:"+result.getAbsolutePath());
                tv_result.setText("文件下载成功:"+result.getAbsolutePath());
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback)
            {
                Log.e(TAG,"文件下载出错:"+ex.getMessage());
                tv_result.setText("文件下载出错:"+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex)
            {
                Log.e(TAG,"onCancelled================"+cex.getMessage());
            }

            @Override
            public void onFinished()
            {
                Log.e(TAG,"onFinished================");
            }

            @Override
            public void onWaiting()
            {
                Log.e(TAG,"onWaiting================");
            }

            @Override
            public void onStarted()
            {
                tv_result.setText("文件开始下载");
                Log.e(TAG,"onStarted================");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading)
            {
                pb_progressBar.setProgress((int) (current*100/total));
            }
        });

    }

    private String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

    private void postRequest()
    {
        RequestParams params = new RequestParams(url);
        x.http().post(params, new Callback.CommonCallback<String>()
        {
            @Override
            public void onSuccess(String result)
            {
                Log.e(TAG, "Post请求成功:" + result);
                tv_result.setText("Post请求成功:" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback)
            {
                Log.e(TAG, "Post请求失败:" + ex.getMessage());
                tv_result.setText("Post请求失败:" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex)
            {
                Log.e(TAG, "onCancelled===========");

            }

            @Override
            public void onFinished()
            {
                Log.e(TAG, "onFinished===========");
            }
        });
    }

    private void getRequest()
    {

        //请求的参数
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>()
        {
            @Override
            public void onSuccess(String result)
            {
                tv_result.setText("Get请求成功:" + result);
                Log.i(TAG, "Get请求成功:" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback)
            {
                Log.e(TAG, "Xutils3请求失败:" + ex.getMessage());
                tv_result.setText("Xutils3请求失败 ：" + ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex)
            {
                Log.e(TAG, "onCancelled====请求取消=====");
            }

            @Override
            public void onFinished()
            {
                Log.e(TAG, "onFinished====请求完成=====");
            }
        });
    }


}
