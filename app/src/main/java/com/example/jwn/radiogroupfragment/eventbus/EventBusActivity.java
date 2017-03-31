package com.example.jwn.radiogroupfragment.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jwn.radiogroupfragment.R;
import com.example.jwn.radiogroupfragment.eventbus.evnet.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusActivity extends Activity
{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_eventbus_send)
    Button btEventbusSend;
    @BindView(R.id.bt_eventbus_sticky)
    Button btEventbusSticky;
    @BindView(R.id.tv_eventbus_result)
    TextView tvEventbusResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        ButterKnife.bind(this);
        initData();
    }

    private void initData()
    {
        tvTitle.setText("EventBus 解析");
        //1.注册广播
        EventBus.getDefault().register(EventBusActivity.this);


    }

    @OnClick({R.id.bt_eventbus_send,R.id.bt_eventbus_sticky})
     void onClick(View view)
     {
         switch (view.getId())
         {
             case R.id.bt_eventbus_send:
                 Intent intent=new Intent(EventBusActivity.this,EventBusSecondActivity.class);
                 startActivity(intent);
                 break;
             case R.id.bt_eventbus_sticky:
                 //2.发送粘性
                 EventBus.getDefault().postSticky(new MessageEvent("上海","我是发送的粘性事件!"));
                 intent=new Intent(EventBusActivity.this,EventBusSecondActivity.class);
                 startActivity(intent);
                 break;
         }
     }


    //5.接收消息   在主线程 上接收消息
    @Subscribe(threadMode=ThreadMode.MAIN)
    public void MesssageEventBus(MessageEvent message)
    {
        tvEventbusResult.setText(message.toString());

    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        //2.解除注册
        EventBus.getDefault().unregister(EventBusActivity.this);
    }
}
