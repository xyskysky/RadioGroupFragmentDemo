package com.example.jwn.radiogroupfragment.volley;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.json.bean.DataInfo;
import com.example.jwn.radiogroupfragment.okhttp.domain.DataBean;
import com.example.jwn.radiogroupfragment.okhttp.util.ToastUtils;
import com.example.jwn.radiogroupfragment.volley.adapter.VolleyImageListAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VolleyListImageActivity extends Activity
{

    private static final String TAG = VolleyListImageActivity.class.getSimpleName();
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_data)
    ListView lvData;
    @BindView(R.id.pb_progress)
    ProgressBar pbProgress;
    @BindView(R.id.tv_nodata)
    TextView tvNodata;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_list_image);
        mContext = this;
        ButterKnife.bind(this);
        tvTitle.setText("Volley显示图片列表");
        getFromServerData();
    }

    private String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

    private void getFromServerData()
    {
        //1.创建请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        //2.创建文本请求
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String resut)
            {
                Log.i(TAG, "Get请求成功:" + resut);
                processData(resut);

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError volleyError)
            {
                Log.e(TAG, "Get请求失败:" + volleyError.getMessage());
            }
        });
        //3.添加到请求队列
        requestQueue.add(stringRequest);
    }

    private void processData(String resut)
    {
        Gson gson = new Gson();
        DataBean dataBean=gson.fromJson(resut,DataBean.class);

        List<DataBean.ItemData> trailers = dataBean.getTrailers();
        if(trailers!=null&&trailers.size()>0)
        {
            ToastUtils.showToast(mContext,"解析数据!");
            VolleyImageListAdapter adapter=new VolleyImageListAdapter(mContext,trailers);
            lvData.setAdapter(adapter);
        }
        else
        {
            tvNodata.setText("亲没有请求到数据!");
        }
        pbProgress.setVisibility(View.GONE);
    }
}
