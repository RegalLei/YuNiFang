package com.gl.yunifang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class YinDaoActivity extends AppCompatActivity {

    private ViewPager yindao_vp;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao);
        preferences = getSharedPreferences("gaolei", MODE_PRIVATE);
        if(preferences.getBoolean("flag",false)){
            Intent intent =new Intent(YinDaoActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        yindao_vp = (ViewPager) findViewById(R.id.yindao_vp);
        yindao_vp.setAdapter(new MyAdapterYinDao(getSupportFragmentManager()));
    }
    class MyAdapterYinDao extends FragmentPagerAdapter{

        private Fragment fragment;
        public MyAdapterYinDao(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            fragment = new Fragment();
            switch (position){
                case 0:
                    fragment=new Fragment_welcome_one();
                    break;
                case 1:
                    fragment=new Fragment_welcome_two();
                    break;
                case 2:
                    fragment=new Fragment_welcome_three();
                    break;
                case 3:
                    fragment=new Fragment_welcome_fore();
                    break;
                case 4:
                    fragment=new Fragment_welcome_frist();
                    break;
            }

            return fragment;
        }


        @Override
        public int getCount() {
            return 5;
        }
    }
}
