package com.qbb.qchina.http.net.rx;

import android.util.Log;

import com.qbb.qchina.http.net.BaseResponse;
import com.qbb.qchina.utils.Constants;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 创建日期：2017/6/19 17:57
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {

    @Override
    public void onSubscribe(Disposable d) {
        doSubscribe(d);
    }

    @Override
    public void onNext(BaseResponse<T> value) {
        Log.e("tag", "onNext==!!message!!!!!" + value.toString());
        if (!Constants.Stutas.SUCCESS.equals(value.message)) {//失败
            Log.e("tag", "onNext==!!message!!!!!" + value.message);
            doFaile(value.message);
        }else{  //成功
            Log.e("tag", "onNext==!!!!responseBody!!!" + value.data);
            doSuccess(value.data);
        }
    }

    @Override
    public void onError(Throwable e) {
        doError(e);

    }



    @Override
    public void onComplete() {
        doComplete();
    }

    public abstract void doSubscribe(Disposable d);
    public abstract void doSuccess(T t);
    public abstract void doFaile(String message);
    public abstract void doError(Throwable e);
    public abstract void doComplete();
}
