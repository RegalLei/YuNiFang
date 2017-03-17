package com.gl.yunifang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * 作者：高镭
 * 时间：2017/3/16 18:53
 * 班级：1501A
 */
public class Fragment_welcome_frist extends android.support.v4.app.Fragment {

    private SharedPreferences preferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.welcome_frist,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        preferences = getActivity().getSharedPreferences("gaolei", Context.MODE_PRIVATE);
        ImageView joup= (ImageView) getView().findViewById(R.id.joup);
        joup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
                preferences.edit().putBoolean("flag",true).commit();
                getActivity().finish();
            }
        });
    }
}
