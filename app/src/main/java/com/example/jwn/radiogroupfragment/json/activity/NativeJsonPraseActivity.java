package com.example.jwn.radiogroupfragment.json.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.json.bean.DataInfo;
import com.example.jwn.radiogroupfragment.json.bean.FilmInfo;
import com.example.jwn.radiogroupfragment.json.bean.ShopInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NativeJsonPraseActivity extends Activity implements View.OnClickListener
{

    private TextView tv_native_orignal;
    private TextView tv_native_last;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_json_prase);
        initView();

    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_native_tojavaobject:
                jsonToJavaObjectByNative();
                break;
            case R.id.bt_native_tojavalist:
                jsonToJavaListByNative();
                break;
            case R.id.bt_native_complex:
                jsonToJavaComplexNative();
                break;
            case R.id.bt_native_special:
                jsonToJavaSpecial();
                break;

        }
    }

    private void jsonToJavaSpecial()
    {
        String json = "{\n" +
                "    \"code\": 0,\n" +
                "    \"list\": {\n" +
                "        \"0\": {\n" +
                "            \"aid\": \"6008965\",\n" +
                "            \"author\": \"哔哩哔哩番剧\",\n" +
                "            \"coins\": 170,\n" +
                "            \"copyright\": \"Copy\",\n" +
                "            \"create\": \"2016-08-25 21:34\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "            \"aid\": \"6008938\",\n" +
                "            \"author\": \"哔哩哔哩番剧\",\n" +
                "            \"coins\": 404,\n" +
                "            \"copyright\": \"Copy\",\n" +
                "            \"create\": \"2016-08-25 21:33\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        FilmInfo filmInfo=new FilmInfo();
        try {
            JSONObject jsonObject=new JSONObject(json);
            //解析第一层
            filmInfo.setCode(jsonObject.optInt("code"));

            List<FilmInfo.FilmBean> filmBeanList=new ArrayList<>();
            filmInfo.setList(filmBeanList);
            //解析第二层
            JSONObject list=jsonObject.optJSONObject("list");
            for(int i=0;i<list.length();i++)
            {
                JSONObject jsonObject1=list.getJSONObject(i+"");
                //解析第三层
                FilmInfo.FilmBean filmBean=new FilmInfo.FilmBean();
                filmBean.setAid(jsonObject1.optString("aid"));
                filmBean.setAuthor(jsonObject1.optString("author"));
                filmBean.setCoins(jsonObject1.optInt("coins"));
                filmBean.setCopyright(jsonObject1.optString("copyright"));
                filmBean.setCreate(jsonObject1.optString("create"));
                filmBeanList.add(filmBean);
            }
            tv_native_orignal.setText(json);
            tv_native_last.setText(filmInfo.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void jsonToJavaComplexNative()
    {
        String json = "{\n" +
                "    \"data\": {\n" +
                "        \"count\": 5,\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"id\": 45,\n" +
                "                \"title\": \"坚果\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 132,\n" +
                "                \"title\": \"炒货\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 166,\n" +
                "                \"title\": \"蜜饯\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 195,\n" +
                "                \"title\": \"果脯\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 196,\n" +
                "                \"title\": \"礼盒\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"rs_code\": \"1000\",\n" +
                "    \"rs_msg\": \"success\"\n" +
                "}";


        try {
            DataInfo dataInfo=new DataInfo();
            //解析第一层
            JSONObject jsonObject=new JSONObject(json);
            dataInfo.setRs_code(jsonObject.optString("rs_code"));
            dataInfo.setRs_msg(jsonObject.optString("rs_msg"));
            //解析第二层
            JSONObject data=jsonObject.optJSONObject("data");

            DataInfo.DataBean dataBean=new DataInfo.DataBean();
            dataInfo.setData(dataBean);

            dataBean.setCount(data.optInt("count"));

            //解析第三层
            JSONArray items = data.optJSONArray("items");
            List<DataInfo.DataBean.ItemsBean> itemsBeanList=new ArrayList<>();
            dataBean.setItems(itemsBeanList);
            for (int i=0;i<items.length();i++)
            {
                DataInfo.DataBean.ItemsBean itemsBean=new DataInfo.DataBean.ItemsBean();

                JSONObject jsonObject1=items.optJSONObject(i);
                if(jsonObject1!=null)
                {
                    itemsBean.setId(jsonObject1.optInt("id"));
                    itemsBean.setTitle(jsonObject1.optString("title"));
                }
                itemsBeanList.add(itemsBean);

            }
            tv_native_orignal.setText(json);
            tv_native_last.setText(dataInfo.toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void jsonToJavaListByNative()
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
        try {
            JSONArray jsonArray=new JSONArray(json);
            List<ShopInfo> list=new ArrayList<>();
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject!=null) {
                    ShopInfo shopInfo = new ShopInfo();
                    shopInfo.setId(jsonObject.optInt("id"));
                    shopInfo.setImagePath(jsonObject.optString("imagePath"));
                    shopInfo.setName(jsonObject.optString("name"));
                    shopInfo.setPrice(jsonObject.optDouble("price"));
                    list.add(shopInfo);
                }
            }
            tv_native_orignal.setText(json);
            tv_native_last.setText(list.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void jsonToJavaObjectByNative()
    {
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        JSONObject jsonObject= null;
        try {
            jsonObject = new JSONObject(json);
            int id=jsonObject.optInt("id");
            String name=jsonObject.optString("name");
            double price=jsonObject.optDouble("price");
            String imagePath=jsonObject.optString("imagePath");

            ShopInfo shopInfo=new ShopInfo(id,name, price,imagePath);

            tv_native_orignal.setText(json);
            tv_native_last.setText(shopInfo.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private void initView()
    {
        TextView tv_title= (TextView) findViewById(R.id.tv_title);
        tv_title.setText("Android原生JSON解析");

        tv_native_orignal = (TextView) findViewById(R.id.tv_native_orignal);
        tv_native_last = (TextView) findViewById(R.id.tv_native_last);

        Button btn_native_tojavaobject= (Button) findViewById(R.id.bt_native_tojavaobject);
        btn_native_tojavaobject.setOnClickListener(this);

        Button btn_native_tojavalist= (Button) findViewById(R.id.bt_native_tojavalist);
        btn_native_tojavalist.setOnClickListener(this);

        Button btn_native_complex= (Button) findViewById(R.id.bt_native_complex);
        btn_native_complex.setOnClickListener(this);

        Button btn_native_special= (Button) findViewById(R.id.bt_native_special);
        btn_native_special.setOnClickListener(this);
    }


}
