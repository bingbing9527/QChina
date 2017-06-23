package com.qbb.qchina.weights.recyclerview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 创建日期：2017/5/12 11:40
 *
 * @author Qian Bing Bing
 *         类说明：ViewHolder基类
 */

public class BaseViewHodler extends RecyclerView.ViewHolder {

    private SparseArray<View> views;
    private boolean clickFlag = true;//单击事件和长单击事件的屏蔽标识

    public BaseViewHodler(View itemView) {
        super(itemView);
        views = new SparseArray<>();
    }


    public <T extends View> T getView(int resId) {
        View view = views.get(resId);
        if (view == null) {
            view = itemView.findViewById(resId);
            views.put(resId, view);
        }
        return (T) view;
    }

    public View getRootView() {
        return itemView;
    }

    /****以下为辅助方法*****/

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public BaseViewHodler setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public BaseViewHodler setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

//    public BaseViewHodler setImageUrl(int viewId, String url) {
//        ImageView view = getView(viewId);
//        ImageLoader.Builder builder = new ImageLoader.Builder();
//        ImageLoader img = builder.url(url)
//                .imgView(view).strategy(ImageLoaderUtil.LOAD_STRATEGY_ONLY_WIFI).build();
//        imageLoaderUtil.loadImage(mContext, img);
//        return this;
//    }

    public BaseViewHodler setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHodler setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public BaseViewHodler setImageRes(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }


    public BaseViewHodler setOnItemClickListner(int resId, View.OnClickListener listener) {
        View view = getView(resId);
        view.setOnClickListener(listener);
        return this;
    }

    public BaseViewHodler setOnItemLongClickListner(int resId, View.OnLongClickListener listener) {
        View view = getView(resId);
        view.setOnLongClickListener(listener);
        return this;
    }


}
