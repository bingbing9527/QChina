package com.qbb.qchina.core.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.qbb.qchina.R;
import com.qbb.qchina.core.ui.BaseActivity;

/**
 * 创建日期：2017/5/15 10:31
 *
 * @author Qian Bing Bing
 *         类说明：带topbar的activity
 */

public abstract class BaseTopBarActivity extends BaseActivity {

    private Toolbar toolbar;
    private FrameLayout rootViewContent;
    private int contentView;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_top_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rootViewContent = (FrameLayout) findViewById(R.id.root_view_content);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        //初始化toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //填充内容布局
        LayoutInflater.from(this).inflate(getContentView(), rootViewContent);
        init(savedInstanceState);
    }

    public abstract int getContentView();

    protected abstract void init(Bundle savedInstanceState);

    /**
     * 设置Toolbar标题
     * @param title
     */
    public void setToolbarTitle(CharSequence title){
        if (!TextUtils.isEmpty(title)) {
            toolbarTitle.setText(title);
        }
    }

    //左边点击事件
    OnClickNavigationListener onClickNavigationListenerToLeft;

    public interface OnClickNavigationListener{
        void onClickNavigation();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            if (onClickNavigationListenerToLeft != null) {
                onClickNavigationListenerToLeft.onClickNavigation();
            }
        }else if(item.getItemId() == R.id.menu_1){
            onClickNavigationListenerToRight.onClickNavigation();
        }
        return true;//true 告诉系统自己处理了点击事件
    }

    /**
     * 设置左边按钮样式和点击事件
     * @param iconResId
     * @param onClickNavigationListenerToLeft
     */
    public void setTopLeftButton(int iconResId,OnClickNavigationListener onClickNavigationListenerToLeft){
        toolbar.setNavigationIcon(iconResId);
        this.onClickNavigationListenerToLeft = onClickNavigationListenerToLeft;
    }

    //左边点击事件
    OnClickNavigationListener onClickNavigationListenerToRight;
    //icon图标
    int menuIconResid;
    String menuStr;
    public void setTopRightButton(String menuStr,OnClickNavigationListener onClickNavigationListenerToRight){
        this.menuStr = menuStr;
        this.onClickNavigationListenerToRight = onClickNavigationListenerToRight;
    }
    public void setTopRightButton(String menuStr,int menuIconResid,OnClickNavigationListener onClickNavigationListenerToRight){
        this.menuIconResid = menuIconResid;
        this.menuStr = menuStr;
        this.onClickNavigationListenerToRight = onClickNavigationListenerToRight;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuIconResid != 0 || !TextUtils.isEmpty(menuStr)) {
            getMenuInflater().inflate(R.menu.menu_activity_base_top_bar,menu);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menuIconResid != 0) {
            menu.findItem(R.id.menu_1).setIcon(menuIconResid);
        }
        if (!TextUtils.isEmpty(menuStr)){
            menu.findItem(R.id.menu_1).setTitle(menuStr);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * 设置Toobar显示状态
     * @param visiable
     */
    public void setToolbarVisiable(int visiable){
        toolbar.setVisibility(visiable);
    }
}
