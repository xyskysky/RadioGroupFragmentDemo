package com.example.jwn.radiogroupfragment.json.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.json.bean.ShopInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FastJsonActivity extends Activity
{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_fastjson_tojavaobject)
    Button btFastjsonTojavaobject;
    @BindView(R.id.bt_fastjson_tojavalist)
    Button btFastjsonTojavalist;
    @BindView(R.id.bt_fastjson_tojsonObject)
    Button btFastjsonTojsonObject;
    @BindView(R.id.bt_fastjson_tojsonArray)
    Button btFastjsonTojsonArray;
    @BindView(R.id.tv_native_orignal)
    TextView tvNativeOrignal;
    @BindView(R.id.tv_native_last)
    TextView tvNativeLast;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_json);
        ButterKnife.bind(this);
        initData();

    }

    private void initData()
    {
       tvTitle.setText("FastJson解析");
    }
    @OnClick({R.id.bt_fastjson_tojavalist,R.id.bt_fastjson_tojavaobject,R.id.bt_fastjson_tojsonArray,R.id.bt_fastjson_tojsonObject})
    public  void OnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_fastjson_tojavalist:
                fastJsonToJavaList();
                break;
            case R.id.bt_fastjson_tojavaobject:
                fastJsonToJavaObject();
                break;
            case R.id.bt_fastjson_tojsonArray:
                javaListToJsonArray();
                break;
            case R.id.bt_fastjson_tojsonObject:
                javaObjectToJsonObject();
                break;
        }
    }

    private void javaListToJsonArray()
    {
        List<ShopInfo> list=new ArrayList<>();
        list.add(new ShopInfo(1001,"龙虾",450,"http://192.168.10.165:8080/L05_Server/images/f1.jpg"));
        list.add(new ShopInfo(1002,"老鳖",900,"http://192.168.10.165:8080/L05_Server/images/f1.jpg"));

        String json = JSON.toJSONString(list);
        tvNativeOrignal.setText(list.toString());
        tvNativeLast.setText(json);
    }

    private void fastJsonToJavaObject()
    {
        // 1 获取或创建json数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        ShopInfo shopInfo = JSON.parseObject(json, ShopInfo.class);
        tvNativeOrignal.setText(json);
        tvNativeLast.setText(shopInfo.toString());
    }

    private void javaObjectToJsonObject()
    {
        ShopInfo shopInfo=new ShopInfo(1001,"龙虾",450,"http://192.168.10.165:8080/L05_Server/images/f1.jpg");
        String json = JSON.toJSONString(shopInfo);
        tvNativeOrignal.setText(shopInfo.toString());
        tvNativeLast.setText(json);

    }

    private void fastJsonToJavaList()
    {
        String json = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f1.jpg\",\n" +
                "        \"name\": \"大虾1\",\n" +
                "        \"price\": 12.3\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f2.jpg\",\n" +
                "        \"name\": \"大虾2\",\n" +
                "        \"price\": 12.5\n" +
                "    }\n" +
                "]";
        List<ShopInfo> shopInfos = JSON.parseArray(json, ShopInfo.class);
        tvNativeOrignal.setText(json);
        tvNativeLast.setText(shopInfos.toString());
    }
}
