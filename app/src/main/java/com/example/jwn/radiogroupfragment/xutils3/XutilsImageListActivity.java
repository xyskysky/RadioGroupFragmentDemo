package com.example.jwn.radiogroupfragment.xutils3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.json.bean.DataInfo;
import com.example.jwn.radiogroupfragment.okhttp.domain.DataBean;
import com.google.gson.Gson;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_xutils_image_list)
public class XutilsImageListActivity extends Activity
{

    private static final String TAG =XutilsImageListActivity.class.getSimpleName() ;
    @ViewInject(R.id.lv_xutils_listview)
    private ListView lv_xutils_listview;
    @ViewInject(R.id.tv_title)
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        tv_title.setText("Xutils3加载图片列表");
        getFromServerData();
    }
    String url="http://api.m.mtime.cn/PageSubArea/TrailerList.api";
    private void getFromServerData()
    {
        RequestParams params=new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>()
        {
            @Override
            public void onSuccess(String result)
            {
                //加载数据正常
                Log.e(TAG,"onSuccess===返回结果:"+result);
                Gson gson=new Gson();
                DataBean dataBean = gson.fromJson(result, DataBean.class);
                Log.e(TAG,dataBean.toString());


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback)
            {

            }

            @Override
            public void onCancelled(CancelledException cex)
            {

            }

            @Override
            public void onFinished()
            {

            }
        });
    }
}
