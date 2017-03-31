package com.example.jwn.radiogroupfragment.imageloader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.imageloader.adapter.ImageloaderGridViewAdaper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageloaderGridviewActivity extends Activity
{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.gv_imageloader_gridview)
    GridView gvImageloaderGridview;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageloader_gridview);
        ButterKnife.bind(this);
        initData();
    }

    private void initData()
    {
        tvTitle.setText("Imageloader在GridView中使用");
        ImageloaderGridViewAdaper adapter=new ImageloaderGridViewAdaper(ImageloaderGridviewActivity.this);
        gvImageloaderGridview.setAdapter(adapter);
    }
}
