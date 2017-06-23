package com.qbb.qchina.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qbb.qchina.R;

import java.util.List;

/**
 * 创建日期：2017/5/15 14:16
 *
 * @author Qian Bing Bing
 *         类说明：底部tab控件
 */

public class BottomTabView extends LinearLayout {

    private int lastSelectPositon = -1;

    private List<TabItemView> tabItemViews;

    public BottomTabView(Context context) {
        super(context);
    }

    public BottomTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTabItemViews(List<TabItemView> tabItemViews) {
        setTabItemViews(tabItemViews,null);
    }

    public void setTabItemViews(List<TabItemView> tabItemViews, View centerView) {
        if (this.tabItemViews != null) {
            throw new RuntimeException("不能重复设置TabItemView");
        }
        if (tabItemViews == null || tabItemViews.size() < 2) {
            throw new RuntimeException("TabItemView 的数量必须大于2！");
        }
        this.tabItemViews = tabItemViews;
        for (int i = 0; i < tabItemViews.size(); i++) {
            if (centerView != null && i == tabItemViews.size() / 2) {
                this.addView(centerView);
            }
            TabItemView tabItemView = tabItemViews.get(i);
            this.addView(tabItemView);

            final int finalPosition = i;

            tabItemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalPosition == lastSelectPositon) {
                        //第二次点击
                        if (onSecondSelectListener != null) {
                            onSecondSelectListener.onSecondSelect(finalPosition);
                        }
                        return;
                    }
                    updatePosition(finalPosition);
                    if (onTabItemSelectListener != null) {
                        onTabItemSelectListener.onTabItemSelect(finalPosition);
                    }
                }
            });
        }

        //所有控件初始化状态
        for (TabItemView tabItemView : tabItemViews) {
            tabItemView.setStatus(TabItemView.NORMAL);
        }
        //默认选中第一个
        updatePosition(0);
    }

    /**
     * 更新被选中 Tab Item 的状态
     * 恢复上一个 Tab Item 的状态
     */
    public void updatePosition(int positon) {
        if (lastSelectPositon != positon) {
            tabItemViews.get(positon).setStatus(TabItemView.SELECT);
            if (lastSelectPositon != -1) {
                tabItemViews.get(lastSelectPositon).setStatus(TabItemView.NORMAL);
            }
            lastSelectPositon = positon;
        }
    }

    OnTabItemSelectListener onTabItemSelectListener;
    OnSecondSelectListener onSecondSelectListener;

    public void setOnTabItemSelectListener(OnTabItemSelectListener onTabItemSelectListener) {
        this.onTabItemSelectListener = onTabItemSelectListener;
    }

    public void setOnSecondSelectListener(OnSecondSelectListener onSecondSelectListener) {
        this.onSecondSelectListener = onSecondSelectListener;
    }

    /**
     * 第二次被选择的监听器
     */
    public interface OnSecondSelectListener {
        void onSecondSelect(int position);
    }

    /**
     * 第一次被选择的监听器
     */
    public interface OnTabItemSelectListener {
        void onTabItemSelect(int position);
    }

    public static class TabItemView extends LinearLayout {
        //tab item 两种状态
        public final static int NORMAL = 1;//未选中
        public final static int SELECT = 2;//选中
        private final Context context;

        //两种图片资源
        public int normalImageResid;//未选中
        public int selectImageResid;//选中

        //文字两种颜色
        public int normalTextColor;//未选中
        public int selectTextColor;//选中

        //item 标题
        public String title;
        private TextView tvTitle;
        private ImageView ivIcon;


        public TabItemView(Context context, String title, int normalImageResid, int selectImageResid, int normalTextColor, int selectTextColor) {
            super(context);
            this.context = context;
            this.title = title;
            this.normalImageResid = normalImageResid;
            this.selectImageResid = selectImageResid;
            this.normalTextColor = normalTextColor;
            this.selectTextColor = selectTextColor;
            init();
        }

        /**
         * 初始化
         */
        private void init() {
            View view = LayoutInflater.from(super.getContext()).inflate(R.layout.view_tab_item, this);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            ivIcon = (ImageView) view.findViewById(R.id.ivIcon);

            LayoutParams params = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1;
            view.setLayoutParams(params);

            tvTitle.setText(title);
        }


        public void setStatus(int status) {
            tvTitle.setTextColor(ContextCompat.getColor(super.getContext(), status == NORMAL ? normalTextColor : selectTextColor));
            ivIcon.setImageResource(status == NORMAL ? normalImageResid : selectImageResid);
        }

    }
}
