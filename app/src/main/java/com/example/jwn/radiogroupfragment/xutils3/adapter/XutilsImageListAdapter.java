package com.example.jwn.radiogroupfragment.xutils3.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.okhttp.domain.DataBean;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class XutilsImageListAdapter extends BaseAdapter
{
    private  Context mContext;
    private List<DataBean.ItemData>mDatas;
    public XutilsImageListAdapter(Context context, List<DataBean.ItemData>datas)
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
            holder=new ViewHolder();
            convertView=View.inflate(mContext,R.layout.okhttp_list_item,null);
            x.view().inject(holder,convertView);
            convertView.setTag(holder);

        }
        else
        {
            holder= (ViewHolder) convertView.getTag();
        }
        DataBean.ItemData itemData=getItem(position);
        holder.tv_name.setText(itemData.getMovieName());
        holder.tv_desc.setText(itemData.getSummary());
        x.image().bind(holder.iv_icon,itemData.getCoverImg());
        return convertView;
    }
    static  class ViewHolder
    {
        @ViewInject(R.id.iv_icon)
        public ImageView iv_icon;
        @ViewInject(R.id.tv_name)
        public TextView tv_name;
        @ViewInject(R.id.tv_desc)
        public  TextView tv_desc;
    }

}
