package com.qbb.qchina.core.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.qbb.qchina.R;
import com.qbb.qchina.core.ui.BaseFragment;
import com.qbb.qchina.view.BottomTabView;

import java.util.List;

/**
 * 创建日期：2017/5/15 14:11
 *
 * @author Qian Bing Bing
 *         类说明：带底部tab和顶部toolbar的Activity基类
 */

public abstract class BaseBottomTabActivity extends BaseTopBarActivity {


    private ViewPager viewPager;
    private BottomTabView bottomTabView;

    @Override
    public int getContentView() {
        return R.layout.activity_base_bottom_tab;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        initToolbar();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        bottomTabView = (BottomTabView) findViewById(R.id.bottomtabview);

        //设置底部tab item
        if (getCenterView() == null) {
            bottomTabView.setTabItemViews(getTabViews());
        } else {
            bottomTabView.setTabItemViews(getTabViews(), getCenterView());
        }
        //初始化Fragment
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (getFragments() == null) {
                    return null;
                }
                return getFragments().get(position);
            }

            @Override
            public int getCount() {
                return getFragments() != null ? getFragments().size() : 0;
            }
        };
        viewPager.setAdapter(adapter);

        //利用 setOnTabItemSelectListener 方法设置 BottomTabView 的监听器，来切换 ViewPager
        bottomTabView.setOnTabItemSelectListener(new BottomTabView.OnTabItemSelectListener() {
            @Override
            public void onTabItemSelect(int position) {
                viewPager.setCurrentItem(position, true);
            }
        });

        //用 ViewPager 的 addOnPageChangeListener 方法，使 ViewPager 切换的时候，也同步切换 BottomTabView 的选中位置。
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomTabView.updatePosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 获取底部tab item
     */
    public abstract List<BottomTabView.TabItemView> getTabViews();

    /**
     * 获取Fragment
     *
     * @return
     */
    public abstract List<BaseFragment> getFragments();

    /**
     * 初始化标题栏
     */
    public abstract void initToolbar();

    public View getCenterView() {
        return null;
    }
}
