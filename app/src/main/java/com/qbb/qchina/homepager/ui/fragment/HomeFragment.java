package com.qbb.qchina.homepager.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qbb.qchina.R;
import com.qbb.qchina.core.ui.BaseFragment;
import com.qbb.qchina.core.ui.StatedFragment;
import com.qbb.qchina.homepager.HomeRecommendView;
import com.qbb.qchina.homepager.bean.HomeContentListBean;
import com.qbb.qchina.homepager.bean.HomeRecommendBean;
import com.qbb.qchina.homepager.persenter.HomeRecommendPersenter;
import com.qbb.qchina.http.net.BaseRequest;
import com.qbb.qchina.http.net.Fault;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建日期：2017/5/15 15:31
 *
 * @author Qian Bing Bing
 *         类说明：首页Fragment
 */

public class HomeFragment extends BaseFragment implements HomeRecommendView<HomeRecommendBean,List<HomeContentListBean>>{

    private static final String FRAGMENT_INDEX = "fragment_index";
    public static HomeFragment newInstance(int index){
        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_INDEX, index);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private HomeRecommendPersenter homeRecommendPersenter;
    private TextView textView;
    private View parentView;

    public HomeFragment(){
        if (getArguments() == null)
            setArguments(new Bundle());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (parentView == null) {
            parentView = inflater.inflate(R.layout.fragment_home, container, false);
            //在这里做一些初始化处理
            initChoiceLayout();
        }
        return parentView;
    }

    private void initChoiceLayout() {
        textView = (TextView) parentView.findViewById(R.id.tv_content);
        textView.setText("Fragment---1");
        Log.e("tag","Fragment---1");

        final Map<String,String> map = new HashMap<>();
        map.put("openudid","3dg6s95rhg2a3dg5");
        homeRecommendPersenter = new HomeRecommendPersenter();
        homeRecommendPersenter.attach(this);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeRecommendPersenter.requestNet(map);
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void showSuccessBefore() {
        Log.e("tag","showSuccessBefore");
    }

    @Override
    public void showSuccess(HomeRecommendBean homeRecommendBean) {

    }


    @Override
    public void showSuccessAfter() {
        Log.e("tag","showSuccessAfter");
    }

    @Override
    public void showEmpty() {
        Log.e("tag","showEmpty");
    }

    @Override
    public void showFaile(String msg) {
        Log.e("tag","showFaile:" + msg);

    }

    @Override
    public void showError(Throwable t) {
        Log.e("tag","showError:" + t.getMessage());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("tag","onDestroy:" );
        if (homeRecommendPersenter != null) {
            homeRecommendPersenter.dettch();
        }
    }

    @Override
    public void postNetRequestBefore() {
        Log.e("tag","postNetRequestBefore:");
    }

    @Override
    public void showComplete() {
        Log.e("tag","showComplete");
    }

    @Override
    public void showHomeContentTypeReuslt(List<HomeContentListBean> homeContentListBeanList) {
        textView.setText(homeContentListBeanList.get(0).name);
    }

    @Override
    public void showHomeContentTypeFaile(Throwable th) {
        if (th instanceof Fault) {
            Fault fault = (Fault) th;
            Log.e("tag","showHomeContentTypeFaile:" + fault.getMessage());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ViewGroup viewGroup = (ViewGroup) parentView.getParent();
        if (viewGroup != null)
            viewGroup.removeView(parentView);
    }
}
