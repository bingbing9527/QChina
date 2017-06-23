package com.qbb.qchina.core.mvp;

import io.reactivex.disposables.Disposable;

/**
 * 创建日期：2017/6/20 11:48
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public interface IStutas<T> {

    void  showSubscribe(Disposable d);

    void showSuccess(T t);

    void showEmpy();

    void showFaile(String message);

    void showError(Throwable e);

    void showComplete();
}
