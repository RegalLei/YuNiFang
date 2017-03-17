package com.gl.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.gl.yunifang.R;

public class Home_ckgdsp extends AppCompatActivity implements View.OnClickListener {

    private ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ckgdsp);

        initView();
        initData();
    }

    private void initData() {
        fanhui.setOnClickListener(this);
    }

    private void initView() {
        fanhui = (ImageView) findViewById(R.id.fanhui);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fanhui:
                finish();
                break;
        }
    }
}
