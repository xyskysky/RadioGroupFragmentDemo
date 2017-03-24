package com.example.jwn.radiogroupfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LauncherActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        //停留2秒钟进入主界面

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run()
           {
                   startMainActivity();
           }
       },2000);
    }

    private void startMainActivity()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        //关闭当前界面
        finish();
    }
}
