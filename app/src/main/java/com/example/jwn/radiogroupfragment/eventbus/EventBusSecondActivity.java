package com.example.jwn.radiogroupfragment.eventbus;

import android.app.Activity;
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
import org.xutils.view.annotation.Event;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusSecondActivity extends Activity
{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_eventbus_send_main)
    Button btEventbusSendMain;
    @BindView(R.id.bt_eventbus_send_sticky)
    Button btEventbusSendSticky;
    @BindView(R.id.tv_eventbus_send_result)
    TextView tvEventbusSendResult;
    private boolean isFirstFlag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_second);
        ButterKnife.bind(this);
        tvTitle.setText("EventBus发送数据页面");
    }

    @OnClick({R.id.bt_eventbus_send_main, R.id.bt_eventbus_send_sticky})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_eventbus_send_main:
                //4.发送消息
                EventBus.getDefault().post(new MessageEvent("谢勇","EventBus发送的消息"));
                finish();
                break;
            case R.id.bt_eventbus_send_sticky:
                //注册事件  只能注册一次 多次注册 报异常

                if(isFirstFlag)
                {
                    isFirstFlag=false;
                    EventBus.getDefault().register(EventBusSecondActivity.this);

                }
                break;
        }
    }
    //4.接收粘性事件    sticky=true  表示为粘性事件
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public  void  StickyEventBus(MessageEvent message)
    {
        tvEventbusSendResult.setText(message.toString());
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        //5.解除注册
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(EventBusSecondActivity.this);
    }
}
