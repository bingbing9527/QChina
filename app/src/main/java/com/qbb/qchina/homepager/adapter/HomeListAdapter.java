package com.qbb.qchina.homepager.adapter;

import android.content.Context;
import android.view.View;

import com.qbb.qchina.R;
import com.qbb.qchina.weights.recyclerview.BaseRecyclerViewAdapter;
import com.qbb.qchina.weights.recyclerview.BaseViewHodler;


/**
 * 创建日期：2017/5/12 14:18
 *
 * @author Qian Bing Bing
 *         类说明：
 */

//public class HomeListAdapter extends BaseRecyclerViewAdapter<UserBean> {
//
//    private String text;
//
//    public HomeListAdapter(Context context) {
//        super(context);
//    }
//
//    public void updateItem(int position){
//        text = "我是刷新的结果";
//        notifyItemChanged(position);
//    }
//
//    @Override
//    public void bindData(BaseViewHodler holder, UserBean userBean, final int position) {
//
//        holder.setText(R.id.tv_name,userBean.getName());
//        holder.setText(R.id.tv_age,userBean.getAge());
//        holder.setOnItemClickListner(R.id.ll_all, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onItemClickListner != null) {
//                    onItemClickListner.onItemClickListner(v,position);
//                }
//            }
//        });
//        if (position == 0) {
//            holder.setText(R.id.tv_age,text);
//        }
//    }
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.item_user;
//    }
//}
