package com.gl.yunifang;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gl.fragment.FragmentClassify;
import com.gl.fragment.FragmentHome;
import com.gl.fragment.FragmentShopping;
import com.gl.fragment.FragmentUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView home;
    private TextView classify;
    private TextView shopping;
    private TextView user;
    private FragmentHome fragmentHome;
    private FragmentClassify fragmentClassify;
    private FragmentShopping fragmentShopping;
    private FragmentUser fragmentUser;
    private FragmentTransaction transaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        //逛一逛里接收,切换fragment
        gygjs();
    }

    private void gygjs() {
        Intent getintent =getIntent();
        int id = getintent.getIntExtra("gygs", -1);
        if(id==1){
            transaction.replace(R.id.main_fragment,fragmentHome);
        }
    }


    private void initView() {
        home = (TextView) findViewById(R.id.home);
        classify = (TextView) findViewById(R.id.classify);
        shopping = (TextView) findViewById(R.id.shopping);
        user = (TextView) findViewById(R.id.user);
    }

    private void initData() {

        home.setOnClickListener(this);
        classify.setOnClickListener(this);
        shopping.setOnClickListener(this);
        user.setOnClickListener(this);

        if (fragmentHome == null) {
            fragmentHome = new FragmentHome();
        }
        setFragment(fragmentHome);

        home.setSelected(true);
        home.setTextColor(Color.RED);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.home:
                if (fragmentHome == null) {
                    fragmentHome = new FragmentHome();
                }
                setFragment(fragmentHome);
                home.setSelected(true);
                home.setTextColor(Color.RED);
                classify.setTextColor(Color.GRAY);
                classify.setSelected(false);
                shopping.setSelected(false);
                user.setSelected(false);
                shopping.setTextColor(Color.GRAY);
                user.setTextColor(Color.GRAY);
                break;

            case R.id.classify:
                if (fragmentClassify == null) {
                    fragmentClassify = new FragmentClassify();
                }
                setFragment(fragmentClassify);
                classify.setSelected(true);
                home.setSelected(false);
                shopping.setSelected(false);
                user.setSelected(false);
                classify.setTextColor(Color.RED);
                home.setTextColor(Color.GRAY);
                shopping.setTextColor(Color.GRAY);
                user.setTextColor(Color.GRAY);
                break;

            case R.id.shopping:
                if (fragmentShopping == null) {
                    fragmentShopping = new FragmentShopping();
                }
                setFragment(fragmentShopping);
                shopping.setSelected(true);
                classify.setSelected(false);
                home.setSelected(false);
                user.setSelected(false);
                shopping.setTextColor(Color.RED);
                classify.setTextColor(Color.GRAY);
                home.setTextColor(Color.GRAY);
                user.setTextColor(Color.GRAY);
                break;

            case R.id.user:
                if (fragmentUser == null) {
                    fragmentUser = new FragmentUser();
                }
                setFragment(fragmentUser);
                user.setSelected(true);
                classify.setSelected(false);
                shopping.setSelected(false);
                home.setSelected(false);
                user.setTextColor(Color.RED);
                classify.setTextColor(Color.GRAY);
                shopping.setTextColor(Color.GRAY);
                home.setTextColor(Color.GRAY);
                break;
        }
    }

    private void setFragment(Fragment f) {
        transaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            transaction.hide(fragment);
        }
        if (!f.isAdded()) {
            transaction.add(R.id.main_fragment, f);
        }
        transaction.show(f);
        transaction.commit();
        fragment = f;
    }
}
