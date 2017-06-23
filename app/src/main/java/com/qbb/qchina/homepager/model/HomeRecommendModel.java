package com.qbb.qchina.homepager.model;

import com.qbb.qchina.core.mvp.MVPModel;
import com.qbb.qchina.homepager.bean.HomeContentListBean;
import com.qbb.qchina.homepager.bean.HomeRecommendBean;
import com.qbb.qchina.http.api.Api;
import com.qbb.qchina.http.net.rx.BaseFunction;
import com.qbb.qchina.http.net.rx.BaseObserver;
import com.qbb.qchina.http.net.BaseResponse;
import com.qbb.qchina.http.net.RetrofitServiceManager;

import java.util.List;
import java.util.Map;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建日期：2017/6/21 14:51
 *
 * @author Qian Bing Bing
 *         类说明：请求类别后请求第一条分类下的内容
 */

public abstract class HomeRecommendModel extends MVPModel<HomeRecommendBean> {

    private ShowHomeContentTypeListener mshowHomeContentTypeListener;

    public void requestNet(Map<String, String> map) {

        RetrofitServiceManager.getInstance().create(Api.class).getHomeContentType(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<BaseResponse<List<HomeContentListBean>>>() {
                    @Override
                    public void accept(BaseResponse<List<HomeContentListBean>> listBaseResponse) throws Exception {
                        if (mshowHomeContentTypeListener != null) {
                            mshowHomeContentTypeListener.showHomeContentType(listBaseResponse.data);
                        }
                    }
                })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (mshowHomeContentTypeListener != null) {
                            mshowHomeContentTypeListener.showHomeContentTypeError(throwable);
                        }
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new BaseFunction<List<HomeContentListBean>,HomeRecommendBean>() {
                    @Override
                    public ObservableSource<BaseResponse<HomeRecommendBean>> doNextRequest(List<HomeContentListBean>listBaseResponse) {
                        if (listBaseResponse.size() < 0) {
                            return null;
                        }
                        return  RetrofitServiceManager.getInstance().create(Api.class).getHomeRecommend(listBaseResponse.get(1).url);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<HomeRecommendBean>() {
                    @Override
                    public void doSubscribe(Disposable d) {
                        showSubscribe(d);
                    }

                    @Override
                    public void doSuccess(HomeRecommendBean homeRecommendBean) {
                        if (homeRecommendBean == null) {
                            showEmpy();
                        }else{
                            showSuccess(homeRecommendBean);
                        }
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

    public void setShowHomeContentTypeListener(ShowHomeContentTypeListener mshowHomeContentTypeListener) {

        this.mshowHomeContentTypeListener = mshowHomeContentTypeListener;
    }

    public interface ShowHomeContentTypeListener {
        void showHomeContentType(List<HomeContentListBean> homeContentTypeList);

        void showHomeContentTypeError(Throwable Throwable);
    }
}
