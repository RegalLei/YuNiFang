package com.gl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gl.yunifang.MainActivity;
import com.gl.yunifang.R;

/**
 * 作者：高镭
 * 时间：2017/3/15 19:25
 * 班级：1501A
 */
public class FragmentShopping extends Fragment implements View.OnClickListener {

    private View view;
    private Button gyg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentshopping, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
        initData();
    }

    private void initData() {
        gyg.setOnClickListener(this);
    }

    private void init() {
        gyg = (Button) view.findViewById(R.id.gyg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gyg:
                Intent intent =new Intent(getActivity(),MainActivity.class);
                intent.putExtra("gygs",1);
                startActivity(intent);
                getActivity().finish();
                break;
        }
    }
}
