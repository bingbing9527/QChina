package com.qbb.qchina.core.mvp;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.Disposable;

/**
 * 创建日期：2017/5/12 14:08
 *
 * @author Qian Bing Bing
 *         类说明：网络访问Persenter基类
 */

public abstract class MVPPersenter<V extends MVPIView,M extends MVPModel> {
    private M model;
    private WeakReference<V> weakReference;
    public void attach(V v){
        weakReference = new WeakReference<V>(v);
    }
    public void dettch(){
        if (weakReference != null) {
            getModel().crealDisposable();
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView(){
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
    public MVPPersenter(){
        model = createModel();
    }
    public M getModel(){
        return model;
    }

    public abstract M createModel();



}
