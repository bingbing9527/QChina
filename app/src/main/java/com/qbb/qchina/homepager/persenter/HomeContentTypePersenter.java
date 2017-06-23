package com.qbb.qchina.homepager.persenter;

import com.qbb.qchina.core.mvp.IStutas;
import com.qbb.qchina.core.mvp.MVPPersenter;
import com.qbb.qchina.homepager.HomeContentTypeView;
import com.qbb.qchina.homepager.bean.HomeContentListBean;
import com.qbb.qchina.homepager.bean.HomeContentTypeBean;
import com.qbb.qchina.homepager.model.HomeContentTypeModel;

import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * 创建日期：2017/6/20 11:55
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public class HomeContentTypePersenter extends MVPPersenter<HomeContentTypeView<List<HomeContentListBean>>,HomeContentTypeModel>{


    public void requestNet(Map<String,String> map){
        getView().postNetRequestBefore();
        getModel().requestNet(map);
    }

    @Override
    public HomeContentTypeModel createModel() {
        return new HomeContentTypeModel() {

            @Override
            public void showSuccess(List<HomeContentListBean> homeContentListBeen) {
                getView().showSuccessBefore();
                getView().showSuccess(homeContentListBeen);
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



}
