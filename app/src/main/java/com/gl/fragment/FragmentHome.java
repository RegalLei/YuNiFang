package com.gl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gl.Home.Home_ckgdsp;
import com.gl.yunifang.R;

import java.util.ArrayList;

/**
 * 作者：高镭
 * 时间：2017/3/15 19:25
 * 班级：1501A
 */
public class FragmentHome extends Fragment implements View.OnClickListener {

    private int strimage[] = {R.drawable.yd1, R.drawable.yd2,
            R.drawable.yd3, R.drawable.yd4,
            R.drawable.yd5, R.drawable.yd6, R.drawable.yd7,
            R.drawable.yd8, R.drawable.yd9};
    private ViewPager vp;
    private View view;
    private LinearLayout ll;
    private ArrayList<ImageView> listImage;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    int currentItem = vp.getCurrentItem();
                    currentItem++;
                    vp.setCurrentItem(currentItem);
                    handler.sendEmptyMessageDelayed(0, 2000);
                    break;

                default:
                    break;
            }
        }

        ;
    };
    private TextView cksysp;
    private Animation animation1;
    private Animation animation2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmenthome,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        info();
        vp.setAdapter(new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView iv = new ImageView(getActivity());
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv.setImageResource(strimage[position % strimage.length]);

                container.addView(iv);

                return iv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView((View) object);
            }
        });
        vp.setCurrentItem(strimage.length * 5000);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                for (int i = 0; i < listImage.size(); i++) {
                    if (i == arg0 % strimage.length) {
                        listImage.get(i).setImageResource(R.drawable.wxlbyd_red);
                    } else {
                        listImage.get(i).setImageResource(R.drawable.wxlb_tou);
                    }
                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    private void initData() {
        cksysp.setOnClickListener(this);
    }

    private void initView() {
        vp = (ViewPager) view.findViewById(R.id.home_viewpager);
        ll = (LinearLayout) view.findViewById(R.id.ll);
        cksysp = (TextView) view.findViewById(R.id.cksysp);

    }

    private void info() {
        listImage = new ArrayList<ImageView>();
        listImage.clear();
        for (int i = 0; i < strimage.length; i++) {
            ImageView iv = new ImageView(getActivity());

            if (i == 0) {
                iv.setImageResource(R.drawable.wxlbyd_red);
            } else {
                iv.setImageResource(R.drawable.wxlb_tou);
            }
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(10, 10);
            param.setMargins(5, 0, 5, 5);
            listImage.add(iv);
            ll.addView(iv, param);

        }
    }
    public void overridePendingTransition (Animation enterAnim, Animation exitAnim){
        animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.right_in);
        animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.left_out);

    };
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cksysp:
                Intent intent=new Intent(getActivity(), Home_ckgdsp.class);
                startActivity(intent);
                overridePendingTransition(animation1,animation2);
                break;
        }
    }
}