package com.qbb.qchina.weights.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 创建日期：2017/5/12 11:56
 *
 * @author Qian Bing Bing
 *         类说明：RecyclerView的Adapter的基类
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHodler> {

    private Context context;
    private List<T> datas;
    private LayoutInflater inflater;
    private int layoutId;
    public OnItemClickListner onItemClickListner;//单击事件
    public OnItemLongClickListner onItemLongClickListner;//长按单击事件
    private boolean clickFlag = true;//单击事件和长单击事件的屏蔽标识


    public BaseRecyclerViewAdapter(Context context){
        this(context,new ArrayList<T>());
    }

    public BaseRecyclerViewAdapter(Context context,List<T> datas){

        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutId = getLayoutId();
        return new BaseViewHodler(inflater.inflate(layoutId,parent,false));
    }

    @Override
    public void onBindViewHolder(BaseViewHodler holder, int position) {
        bindData(holder,datas.get(position),position);
    }

    /**
     * 绑定数据
     * @param holder
     * @param t
     * @param position
     */
    public abstract void bindData(BaseViewHodler holder, T t, int position);

    /**
     * 获取item布局
     * @return
     */
    public abstract int getLayoutId();


    /**
     * 指定添加条目
     * @param t
     * @param position
     */
    public void insertItem(T t, int position){
        datas.add(position,t);
        notifyItemInserted(position);

    }

    /**
     * 移除条目
     * @param position
     */
    public void removeItem(int position){
        datas.remove(position);
        notifyItemRemoved(position);
    }


    public void addListAll(Collection<T> collection){
        datas.addAll(collection);
        notifyDataSetChanged();
    }

    public void removeListAll(){
        datas.clear();
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public void setOnItemLongClickListner(OnItemLongClickListner onItemLongClickListner) {
        this.onItemLongClickListner = onItemLongClickListner;
    }

    public interface OnItemClickListner {
        void onItemClickListner(View v, int position);
    }

    public interface OnItemLongClickListner {
        void onItemLongClickListner(View v, int position);
    }
}
