package com.gl.yunifang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;


public class WelcomeActivity extends AppCompatActivity {



    private Handler ghandler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent=new Intent();
            intent.setClass(WelcomeActivity.this,YinDaoActivity.class);
            startActivity(intent);
            finish();
        }
    };
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ghandler.sendEmptyMessageDelayed(0,2000);

    }
}
