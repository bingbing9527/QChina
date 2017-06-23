package com.qbb.qchina.main.ui.activity;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qbb.qchina.R;
import com.qbb.qchina.core.ui.BaseFragment;
import com.qbb.qchina.core.ui.activity.BaseBottomTabActivity;
import com.qbb.qchina.homepager.ui.fragment.HomeFragment;
import com.qbb.qchina.main.ui.fragment.TrendsFragment;
import com.qbb.qchina.main.ui.fragment.FindFragment;
import com.qbb.qchina.main.ui.fragment.MineFragment;
import com.qbb.qchina.utils.ToastUtils;
import com.qbb.qchina.view.BottomTabView;

import java.util.ArrayList;
import java.util.List;
/**
 * 创建日期：2017/5/12 13:31
 *
 * @author Qian Bing Bing
 *         类说明：主类
 */
public class MainActivity extends BaseBottomTabActivity {

    @Override
    public List<BottomTabView.TabItemView> getTabViews() {
        List<BottomTabView.TabItemView> tabItemViews = new ArrayList<>();
        tabItemViews.add(new BottomTabView.TabItemView(this, getString(R.string.tab_home),
               R.mipmap.ic_launcher_round, R.mipmap.ic_launcher,  R.color.colorPrimary, R.color.color_2da568));
        tabItemViews.add(new BottomTabView.TabItemView(this, getString(R.string.tab_tweet),
                R.mipmap.ic_launcher_round, R.mipmap.ic_launcher, R.color.colorPrimary, R.color.color_2da568));
        tabItemViews.add(new BottomTabView.TabItemView(this, getString(R.string.tab_find),
                R.mipmap.ic_launcher_round,  R.mipmap.ic_launcher,R.color.colorPrimary, R.color.color_2da568));
        tabItemViews.add(new BottomTabView.TabItemView(this, getString(R.string.tab_mine),
                 R.mipmap.ic_launcher_round,R.mipmap.ic_launcher, R.color.colorPrimary, R.color.color_2da568));
        return tabItemViews;
    }

    @Override
    public List<BaseFragment> getFragments() {
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance(0));
        fragments.add(TrendsFragment.newInstance(1));
        fragments.add(FindFragment.newInstance(2));
        fragments.add(MineFragment.newInstance(3));
        return fragments;
    }

    @Override
    public void initToolbar() {
        setToolbarTitle("首页");
//        setTopLeftButton(R.mipmap.back, new OnClickNavigationListener() {
//            @Override
//            public void onClickNavigation() {
//                ToastUtils.showShort("点击了左边的按钮");
//            }
//        });
        setTopRightButton("", R.mipmap.user_icon, new OnClickNavigationListener() {
            @Override
            public void onClickNavigation() {
                ToastUtils.showShort("点击了右边的按钮");
            }
        });
    }

    @Override
    public View getCenterView() {
        ImageView centerView = new ImageView(this);
        centerView.setImageResource(R.mipmap.ic_launcher_round);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200,200);
        params.leftMargin = 60;
        params.rightMargin = 60;
        params.bottomMargin = 0;
        centerView.setLayoutParams(params);
        centerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("点击了bottom中间的按钮");
            }
        });
        return centerView;
    }
}
