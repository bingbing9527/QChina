package com.qbb.qchina.homepager.model;

import com.qbb.qchina.core.mvp.MVPModel;
import com.qbb.qchina.homepager.bean.HomeContentListBean;
import com.qbb.qchina.http.api.Api;
import com.qbb.qchina.http.net.rx.BaseObserver;
import com.qbb.qchina.http.net.RetrofitServiceManager;

import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建日期：2017/6/20 11:32
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public abstract class HomeContentTypeModel extends MVPModel<List<HomeContentListBean>> {


    public void requestNet(Map<String, String> map) {

        RetrofitServiceManager.getInstance().create(Api.class).getHomeContentType(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<HomeContentListBean>>() {
                    @Override
                    public void doSubscribe(Disposable d) {
                        showSubscribe(d);
                    }

                    @Override
                    public void doSuccess(List<HomeContentListBean> homeContentListBeen) {
                        showSuccess(homeContentListBeen);
                    }

                    @Override
                    public void doFaile(String message) {
                        showFaile(message);
                    }

                    @Override
                    public void doError(Throwable e) {
                        showError(e);
                    }

                    @Override
                    public void doComplete() {
                        showComplete();
                    }
                });

    }
}
