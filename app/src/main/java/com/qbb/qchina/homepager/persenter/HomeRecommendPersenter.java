package com.qbb.qchina.homepager.persenter;

import com.qbb.qchina.core.mvp.MVPPersenter;
import com.qbb.qchina.homepager.HomeRecommendView;
import com.qbb.qchina.homepager.bean.HomeContentListBean;
import com.qbb.qchina.homepager.bean.HomeRecommendBean;
import com.qbb.qchina.homepager.model.HomeRecommendModel;

import java.util.List;
import java.util.Map;

/**
 * 创建日期：2017/6/22 10:04
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public class HomeRecommendPersenter extends MVPPersenter<HomeRecommendView<HomeRecommendBean,List<HomeContentListBean>>,HomeRecommendModel> implements HomeRecommendModel.ShowHomeContentTypeListener {

    public void requestNet(Map<String, String> map) {
        getView().postNetRequestBefore();
        getModel().setShowHomeContentTypeListener(this);
        getModel().requestNet(map);
    }
    @Override
    public HomeRecommendModel createModel() {
        return new HomeRecommendModel() {
            @Override
            public void showSuccess(HomeRecommendBean homeRecommendBean) {
                getView().showSuccessBefore();
                getView().showSuccess(homeRecommendBean);
                getView().showSuccessAfter();
            }

            @Override
            public void showEmpy() {
                getView().showEmpty();
            }

            @Override
            public void showFaile(String message) {
                getView().showFaile(message);
            }

            @Override
            public void showError(Throwable e) {
                getView().showError(e);
            }

            @Override
            public void showComplete() {
                getView().showComplete();
            }
        };
    }

    @Override
    public void showHomeContentType(List<HomeContentListBean> homeContentTypeList) {
        getView().showHomeContentTypeReuslt(homeContentTypeList);
    }

    @Override
    public void showHomeContentTypeError(Throwable throwable) {
        getView().showHomeContentTypeFaile(throwable);
    }
}
