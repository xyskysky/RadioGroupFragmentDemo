package com.example.jwn.radiogroupfragment.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.adapter.OKHttpListAdapter;
import com.example.jwn.radiogroupfragment.domain.DataBean;
import com.example.jwn.radiogroupfragment.util.CacheUtils;
import com.example.jwn.radiogroupfragment.util.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OKHttpListActivity extends Activity
{

    private static final String TAG =OKHttpListActivity.class.getSimpleName() ;
    private ListView lv_list;
    private TextView tv_nodata;
    private ProgressBar pb_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_list);
        initView();
        getFromServerData();

    }
  private String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
    private void getFromServerData()
    {
        //读取缓存
        String saveData=CacheUtils.getString(this,url);
        if(!TextUtils.isEmpty(saveData))
        {
            //加载缓存数据
            processData(saveData);
        }

        OkHttpUtils.get().url(url).id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id)
            {
                  tv_nodata.setVisibility(View.VISIBLE);
            }

            @Override
            public void onBefore(Request request, int id)
            {
                super.onBefore(request, id);
                setTitle("加载中.....");
            }

            @Override
            public void onAfter(int id)
            {
                super.onAfter(id);
                setTitle("加载完成");
            }

            @Override
            public void onResponse(String response, int id)
            {

                Log.e(TAG, "onResponse：complete");
                tv_nodata.setVisibility(View.GONE);

                switch (id) {
                    case 100:
                        ToastUtils.showToast(OKHttpListActivity.this,"http");
                        break;
                    case 101:
                        ToastUtils.showToast(OKHttpListActivity.this,"https");
                        break;
                }
                if (!TextUtils.isEmpty(response))
                {
                    CacheUtils.putString(OKHttpListActivity.this,url,response);
                    processData(response);
                }
            }
        });
    }

    private void processData(String response)
    {
        //json解析数据
        DataBean dataBean = parsedJson(response);
        List<DataBean.ItemData> datas = dataBean.getTrailers();
        if (datas!=null&&datas.size()>0)
        {
            tv_nodata.setVisibility(View.GONE);
            OKHttpListAdapter adapter=new OKHttpListAdapter(OKHttpListActivity.this,datas);
            lv_list.setAdapter(adapter);
        }
        else
        {
            //没有数据
            tv_nodata.setVisibility(View.VISIBLE);
        }
        pb_progress.setVisibility(View.GONE);
    }

    private void initView()
    {
        lv_list = (ListView) findViewById(R.id.lv_list);
        pb_progress = (ProgressBar) findViewById(R.id.pb_progress);
        tv_nodata = (TextView) findViewById(R.id.tv_nodata);


    }
    /**
     * 解析json数据
     *
     * @param response
     * @return
     */
    private DataBean parsedJson(String response) {
        DataBean dataBean = new DataBean();
        try {

            JSONObject jsonObject = new JSONObject(response);

            JSONArray jsonArray = jsonObject.optJSONArray("trailers");
            if (jsonArray != null && jsonArray.length() > 0) {

                List<DataBean.ItemData> trailers = new ArrayList<>();
                dataBean.setTrailers(trailers);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObjectItem = (JSONObject) jsonArray.get(i);

                    if (jsonObjectItem != null) {

                        DataBean.ItemData mediaItem = new DataBean.ItemData();

                        String movieName = jsonObjectItem.optString("movieName");//name
                        mediaItem.setMovieName(movieName);

                        String videoTitle = jsonObjectItem.optString("videoTitle");//desc
                        mediaItem.setVideoTitle(videoTitle);

                        String imageUrl = jsonObjectItem.optString("coverImg");//imageUrl
                        mediaItem.setCoverImg(imageUrl);

                        String hightUrl = jsonObjectItem.optString("hightUrl");//data
                        mediaItem.setHightUrl(hightUrl);

                        //把数据添加到集合
                        trailers.add(mediaItem);
                    }
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataBean;
    }
}
