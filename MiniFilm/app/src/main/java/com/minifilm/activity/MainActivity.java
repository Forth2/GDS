package com.minifilm.activity;

import android.graphics.Color;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;
import com.minifilm.R;
import com.minifilm.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.bottom)
    BottomTabBar bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottom.init(getSupportFragmentManager())
                .setImgSize(40, 40)
                .setFontSize(15)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.parseColor("#FD6C6C"), Color.GRAY)
                .addTabItem("精选", R.mipmap.found_select, R.mipmap.found, FragmentChoice.class)
                .addTabItem("专题", R.mipmap.special_select, R.mipmap.special, FragmentSpecial.class)
                .addTabItem("发现", R.mipmap.fancy_select, R.mipmap.fancy, FragmentFind.class)
                .addTabItem("我的", R.mipmap.my_select, R.mipmap.my, FragmentMine.class);
    }
}
