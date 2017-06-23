package com.qbb.qchina.core.mvp;

import android.util.Log;

import com.qbb.qchina.homepager.bean.HomeContentListBean;
import com.qbb.qchina.homepager.bean.HomeContentTypeBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * 创建日期：2017/5/12 14:07
 *
 * @author Qian Bing Bing
 *         类说明：网络访问model基类
 */

public abstract class  MVPModel<T>  implements IStutas<T>{
    private Disposable d;

    @Override
    public void showSubscribe(Disposable d) {
        this.d = d;
    }

    public void crealDisposable(){
        if (d != null) {
            Log.e("tag","crealDisposable");
            d.dispose();
        }
    }

}
