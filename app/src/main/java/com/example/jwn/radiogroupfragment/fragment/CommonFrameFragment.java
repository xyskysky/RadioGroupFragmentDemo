package com.example.jwn.radiogroupfragment.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.afinal.AfinalActivity;
import com.example.jwn.radiogroupfragment.eventbus.EventBusActivity;
import com.example.jwn.radiogroupfragment.imageloader.ImageloaderActivity;
import com.example.jwn.radiogroupfragment.json.activity.FastJsonActivity;
import com.example.jwn.radiogroupfragment.json.activity.GsonActivity;
import com.example.jwn.radiogroupfragment.json.activity.NativeJsonPraseActivity;
import com.example.jwn.radiogroupfragment.okhttp.activity.OkHttpActivity;
import com.example.jwn.radiogroupfragment.okhttp.adapter.CommonFrameFragmentAdapter;
import com.example.jwn.radiogroupfragment.okhttp.base.BaseFragment;
import com.example.jwn.radiogroupfragment.volley.VolleyActivity;
import com.example.jwn.radiogroupfragment.xutils3.XutilsActivity;
import org.xutils.common.task.AbsTask;

/**
 * Created by Administrator on 2017-03-23.
 */
public class CommonFrameFragment extends BaseFragment
{
    private static final String TAG = CommonFrameFragment.class.getSimpleName();
    private String[] datas;
    private ListView lv_data;
    private AdapterView.OnItemClickListener listener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String data=datas[position];
            showToast(data);
            if ("OKHttp".equals(data))
            {
                Intent intent=new Intent(mContext, OkHttpActivity.class);

                startActivity(intent);
            }
            else if ("nativeJsonPrase".equals(data))
            {
                Intent intent=new Intent(mContext, NativeJsonPraseActivity.class);
                startActivity(intent);
            }
            else if ("Gson".equals(data))
            {
                Intent intent=new Intent(mContext, GsonActivity.class);
                startActivity(intent);
            }
            else  if ("FastJson".equals(data))
            {
                Intent intent=new Intent(mContext, FastJsonActivity.class);
                startActivity(intent);
            }
            else if ("xUtils3".equals(data))
            {
                Intent intent=new Intent(mContext, XutilsActivity.class);
                startActivity(intent);
            }
            else if ("AFinal".equals(data))
            {
                Intent intent=new Intent(mContext, AfinalActivity.class);
                startActivity(intent);
            }
            else if ("Volley".equals(data))
            {
                Intent intent=new Intent(mContext, VolleyActivity.class);
                startActivity(intent);
            }
            else  if ("EvenBus".equals(data))
            {
                Intent intent=new Intent(mContext, EventBusActivity.class);
                startActivity(intent);
            }
            else if ("ImageLoader".equals(data))
            {
                Intent intent=new Intent(mContext, ImageloaderActivity.class);
                startActivity(intent);
            }
        }
    };
    private CommonFrameFragmentAdapter adapter;


    @Override
    public View initView()
    {
        Log.i(TAG,"常用框架Fragment页面被初始化了......");
        View view=View.inflate(mContext, R.layout.fragment_common_frame,null);
        lv_data = (ListView) view.findViewById(R.id.lv_data);
        lv_data.setOnItemClickListener(listener);
        return  view;
    }
    @Override
    protected void initData()
    {
        super.initData();
        datas = new String[]{"OKHttp","FastJson","xUtils3","AFinal","Volley","EvenBus","ImageLoader","nativeJsonPrase", "Gson","Retrofit2","Fresco","Glide","greenDao","RxJava","picasso","evenBus","jcvideoplayer","pulltorefresh","Expandablelistview","UniversalVideoView","....."};
        adapter = new CommonFrameFragmentAdapter(mContext,datas);
        lv_data.setAdapter(adapter);

        Log.i(TAG,"常用框架数据被初始化了......");
    }
}
