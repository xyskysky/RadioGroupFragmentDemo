package com.example.jwn.radiogroupfragment.json.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.json.bean.ShopInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class GsonActivity extends Activity
{


    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.bt_gson_tojavaobject)
    Button mBtGsonTojavaobject;
    @BindView(R.id.bt_gjson_tojavalist)
    Button mBtGjsonTojavalist;
    @BindView(R.id.bt_gjson_tojsonObject)
    Button mBtGjsonTojsonObject;
    @BindView(R.id.bt_gjson_tojsonArray)
    Button mBtGjsonTojsonArray;
    @BindView(R.id.tv_native_orignal)
    TextView mTvNativeOrignal;
    @BindView(R.id.tv_native_last)
    TextView mTvNativeLast;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.bt_gjson_tojavalist,R.id.bt_gjson_tojsonArray,R.id.bt_gjson_tojsonObject,R.id.bt_gson_tojavaobject})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_gjson_tojavalist:
                gsonToJavaList();
                break;
            case R.id.bt_gjson_tojsonArray:
                javaListToJsonArray();
                break;
            case R.id.bt_gjson_tojsonObject:
                javaObjectToJsonObject();

                break;
            case R.id.bt_gson_tojavaobject:
                gsonToJavaObject();

                break;
        }
    }
    private void javaListToJsonArray()
    {
        List<ShopInfo> list=new ArrayList<>();
        list.add(new ShopInfo(1001,"龙虾",450,"http://192.168.10.165:8080/L05_Server/images/f1.jpg"));
        list.add(new ShopInfo(1002,"老鳖",900,"http://192.168.10.165:8080/L05_Server/images/f1.jpg"));

        Gson gson=new Gson();

        String json =gson.toJson(list);
        mTvNativeOrignal.setText(list.toString());
        mTvNativeLast.setText(json);
    }

    private void gsonToJavaObject()
    {
        // 1 获取或创建json数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        Gson gson=new Gson();
        ShopInfo shopInfo =gson.fromJson(json,ShopInfo.class);
        mTvNativeOrignal.setText(json);
        mTvNativeLast.setText(shopInfo.toString());
    }

    private void javaObjectToJsonObject()
    {
        ShopInfo shopInfo=new ShopInfo(1001,"龙虾",450,"http://192.168.10.165:8080/L05_Server/images/f1.jpg");
        Gson gson=new Gson();
        String json = gson.toJson(shopInfo);
        mTvNativeOrignal.setText(shopInfo.toString());
        mTvNativeLast.setText(json);

    }

    private void gsonToJavaList()
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
        Gson gson=new Gson();
        List<ShopInfo> shopInfos = gson.fromJson(json,new TypeToken<List<ShopInfo>>(){}.getType());
        mTvNativeOrignal.setText(json);
        mTvNativeLast.setText(shopInfos.toString());
    }
}
