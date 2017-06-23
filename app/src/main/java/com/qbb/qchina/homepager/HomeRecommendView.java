package com.qbb.qchina.homepager;

import com.qbb.qchina.core.mvp.MVPIView;

/**
 * 创建日期：2017/6/22 10:04
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public interface HomeRecommendView<T,R> extends MVPIView<T>{
    void showHomeContentTypeReuslt(R r);
    void showHomeContentTypeFaile(Throwable th);
}
