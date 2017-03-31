package com.example.jwn.radiogroupfragment.imageloader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageloaderActivity extends Activity
{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_imageloader_listview)
    Button btImageloaderListview;
    @BindView(R.id.bt_imageloader_gridview)
    Button btImageloaderGridview;
    @BindView(R.id.bt_imageloader_viewpager)
    Button btImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageloader);
        ButterKnife.bind(this);
        tvTitle.setText("Imageloader解析");
    }

    @OnClick({R.id.bt_imageloader_listview, R.id.bt_imageloader_gridview, R.id.bt_imageloader_viewpager})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_imageloader_listview:
                Intent intent=new Intent(ImageloaderActivity.this,ImageloaderListviewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_imageloader_gridview:
                intent=new Intent(ImageloaderActivity.this,ImageloaderGridviewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_imageloader_viewpager:
                intent=new Intent(ImageloaderActivity.this,ImageloaderViewpagerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
