package com.example.jwn.radiogroupfragment.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.activity.OkHttpActivity;
import com.example.jwn.radiogroupfragment.adapter.CommonFrameFragmentAdapter;
import com.example.jwn.radiogroupfragment.base.BaseFragment;

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
        datas = new String[]{"OKHttp", "xUtils3","Retrofit2","Fresco","Glide","greenDao","RxJava","volley","Gson","FastJson","picasso","evenBus","jcvideoplayer","pulltorefresh","Expandablelistview","UniversalVideoView","....."};
        adapter = new CommonFrameFragmentAdapter(mContext,datas);
        lv_data.setAdapter(adapter);

        Log.i(TAG,"常用框架数据被初始化了......");
    }
}