package com.example.jwn.radiogroupfragment.xutils3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.okhttp.domain.DataBean;
import com.example.jwn.radiogroupfragment.xutils3.adapter.XutilsImageListAdapter;
import com.google.gson.Gson;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

@ContentView(R.layout.activity_xutils_image_list)
public class XutilsImageListActivity extends Activity
{

    private static final String TAG =XutilsImageListActivity.class.getSimpleName() ;
    @ViewInject(R.id.lv_xutils_listview)
    private ListView lv_xutils_listview;
    @ViewInject(R.id.tv_title)
    private TextView tv_title;
    @ViewInject(R.id.tv_nodata)
    private TextView tv_nodata;
    @ViewInject(R.id.pb_progress)
    private ProgressBar pb_progress;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        tv_title.setText("Xutils3加载图片列表");
        tv_nodata.setVisibility(View.GONE);

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
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback)
            {
                Log.e(TAG,"onError=================="+ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex)
            {
                Log.e(TAG,"onCancelled=================="+cex.getMessage());
            }

            @Override
            public void onFinished()
            {
                Log.e(TAG,"onFinished===================================");
            }
        });
    }

    private void processData(String result)
    {
        Gson gson=new Gson();
        DataBean dataBean = gson.fromJson(result, DataBean.class);
        Log.e(TAG,dataBean.toString());
        List<DataBean.ItemData> trailers = dataBean.getTrailers();
        if (trailers!=null||trailers.size()>0)
        {
            XutilsImageListAdapter adapter=new XutilsImageListAdapter(XutilsImageListActivity.this,trailers);
            lv_xutils_listview.setAdapter(adapter);
        }
        else
        {
            tv_nodata.setText("亲没有加载到数据!");
        }
        pb_progress.setVisibility(View.GONE);

    }
}
