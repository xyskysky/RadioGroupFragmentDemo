package com.example.jwn.radiogroupfragment.imageloader;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.imageloader.adapter.ImageloaderGridViewAdaper;
import com.example.jwn.radiogroupfragment.imageloader.adapter.ImageloaderViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageloaderViewpagerActivity extends Activity
{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.vp_imageloader_viewpager)
    ViewPager vpImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageloader_viewpager);
        ButterKnife.bind(this);
        initData();
    }

    private void initData()
    {
        tvTitle.setText("Imageloader在ViewPager中使用");

        ImageloaderViewPagerAdapter adapter=new ImageloaderViewPagerAdapter(ImageloaderViewpagerActivity.this);
        vpImageloaderViewpager.setAdapter(adapter);
        vpImageloaderViewpager.setCurrentItem(3);



    }
}
