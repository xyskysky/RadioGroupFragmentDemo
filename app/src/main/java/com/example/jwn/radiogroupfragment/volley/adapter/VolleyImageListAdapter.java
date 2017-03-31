package com.example.jwn.radiogroupfragment.volley.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.okhttp.domain.DataBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017-03-31.
 */

public class VolleyImageListAdapter extends BaseAdapter
{
    private  Context mContext;
    private List<DataBean.ItemData>mDatas;
    public VolleyImageListAdapter(Context context, List<DataBean.ItemData> datas)
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
        ViewHolder holder=null;
        if(convertView==null)
        {

            convertView=View.inflate(mContext,R.layout.volley_list_item,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else
        {
            holder= (ViewHolder) convertView.getTag();
        }
        DataBean.ItemData item = getItem(position);
        holder.tv_name.setText(item.getMovieName());
        holder.tv_desc.setText(item.getSummary());

        holder.iv_icon.setImageUrl(item.getCoverImg(),ImageCacheManager.getInstance().getImageLoader(mContext));

        return convertView;
    }
    static  class ViewHolder
    {
        public ViewHolder(View view)
        {
            ButterKnife.bind(this,view);
        }
        @BindView(R.id.iv_icon)
        NetworkImageView iv_icon;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_desc)
        TextView tv_desc;
    }
}
