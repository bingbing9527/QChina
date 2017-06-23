package com.qbb.qchina.core.mvp;

/**
 * 创建日期：2017/5/12 14:07
 *
 * @author Qian Bing Bing
 *         类说明：网络访问View基本接口
 */

public interface MVPIView<T> {
    void postNetRequestBefore();
    void showSuccessBefore();
    void showSuccess(T t);
    void showSuccessAfter();
    void showEmpty();
    void showFaile(String msg);
    void showError(Throwable t);
    void showComplete();
}
