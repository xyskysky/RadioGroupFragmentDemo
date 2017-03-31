package com.example.jwn.radiogroupfragment.imageloader.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.imageloader.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017-03-31.
 */

public class ImageloaderListViewAdapter extends BaseAdapter
{
    private Context mContext;
    private final ImageLoader imageLoader;

    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showStubImage(R.drawable.atguigu_logo)          // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.atguigu_logo)  // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.atguigu_logo)       // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(true)                          // 设置下载的图片是否缓存在SD卡中
            .displayer(new RoundedBitmapDisplayer(20))  // 设置成圆角图片
            .build();                                   // 创建配置过得DisplayImageOption对象;

    public ImageloaderListViewAdapter(Context context)
    {
        this.mContext=context;
        //1.初始化Imageloader
        imageLoader = ImageLoader.getInstance();

    }
    @Override
    public int getCount()
    {
        return Constants.IMAGES.length;
    }
    @Override
    public Object getItem(int position)
    {
        return Constants.IMAGES[position];
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
            convertView=View.inflate(mContext,R.layout.item_imageloader_listview,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else
        {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv_name.setText("Position============="+position);
        imageLoader.displayImage(Constants.IMAGES[position],holder.iv_image,options);

        return convertView;
    }
    static  class ViewHolder
    {
        public ViewHolder(View view)
        {
            ButterKnife.bind(this,view);
        }
        @BindView(R.id.iv_imageloader_listview)
        ImageView iv_image;
        @BindView(R.id.tv_imageloader_name)
        TextView tv_name;
    }
}
