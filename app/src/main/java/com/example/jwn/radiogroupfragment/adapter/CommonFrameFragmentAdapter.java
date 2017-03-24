package com.example.jwn.radiogroupfragment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-03-23.
 */

public class CommonFrameFragmentAdapter extends BaseAdapter
{
    private Context mContext;
    private String[] mDatas;

    public CommonFrameFragmentAdapter(Context context,String[] datas)
    {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getCount()
    {
        return mDatas.length;
    }

    @Override
    public String getItem(int position)
    {
        return mDatas[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        TextView textView = new TextView(mContext);
        textView.setPadding(10,10,0,10);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(20);
        textView.setText(mDatas[position]);
        return textView;
    }
}
