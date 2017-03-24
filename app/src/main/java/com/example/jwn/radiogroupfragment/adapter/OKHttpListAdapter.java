package com.example.jwn.radiogroupfragment.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.domain.DataBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2017-03-24.
 */

public class OKHttpListAdapter extends BaseAdapter
{

    private Context mContext;
    private List<DataBean.ItemData>mDatas;
    public OKHttpListAdapter(Context context, List<DataBean.ItemData> datas)
    {
        this.mContext=context;
        this.mDatas=datas;
    }
    @Override
    public int getCount()
    {
        return mDatas.size();
    }

    @Override
    public DataBean.ItemData getItem(int position)
    {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewHolder holder;
        if (convertView==null)
        {
            convertView=View.inflate(mContext, R.layout.okhttp_list_item,null);
            holder=new ViewHolder();
            holder.iv_icon= (ImageView) convertView.findViewById(R.id.iv_icon);
            holder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_desc= (TextView) convertView.findViewById(R.id.tv_desc);
            convertView.setTag(holder);
        }
        else
        {
            holder= (ViewHolder) convertView.getTag();
        }
        DataBean.ItemData data=getItem(position);
        holder.tv_name.setText(data.getMovieName());
        holder.tv_desc.setText(data.getVideoTitle());
        OkHttpUtils.get().url(data.getCoverImg()).id(100)
                         .tag(this).build().connTimeOut(20000)
                         .writeTimeOut(20000).readTimeOut(20000)
                         .execute(new BitmapCallback() {
                             @Override
                             public void onError(Call call, Exception e, int id)
                             {

                             }

                             @Override
                             public void onResponse(Bitmap response, int id)
                             {
                                 holder.iv_icon.setImageBitmap(response);
                             }
                         });
        return convertView;
    }
    static  class ViewHolder
    {
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_desc;
    }
}
