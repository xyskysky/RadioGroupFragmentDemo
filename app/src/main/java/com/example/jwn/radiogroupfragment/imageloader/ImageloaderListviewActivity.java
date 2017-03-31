package com.example.jwn.radiogroupfragment.imageloader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.imageloader.adapter.ImageloaderListViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageloaderListviewActivity extends Activity
{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_imageloader)
    ListView lvImageloader;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageloader_listview);
        ButterKnife.bind(this);
        initData();

    }

    private void initData()
    {
        tvTitle.setText("Imageloader加载图片ListView");
        ImageloaderListViewAdapter adapter=new ImageloaderListViewAdapter(ImageloaderListviewActivity.this);
        lvImageloader.setAdapter(adapter);

    }
}
