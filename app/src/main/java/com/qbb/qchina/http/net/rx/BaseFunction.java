package com.qbb.qchina.http.net.rx;

import com.qbb.qchina.http.net.BaseResponse;
import com.qbb.qchina.http.net.Fault;
import com.qbb.qchina.utils.Constants;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * 创建日期：2017/6/21 11:15
 *
 * @author Qian Bing Bing
 *         类说明：嵌套网络访问
 */

public abstract class BaseFunction<T,R> implements Function<BaseResponse<T>,ObservableSource<BaseResponse<R>>> {


    @Override
    public ObservableSource<BaseResponse<R>> apply(BaseResponse<T> tBaseResponse) throws Exception {
        if (!Constants.Stutas.SUCCESS.equals(tBaseResponse.message)) {
            throw new Fault(tBaseResponse.message);
        }else{
            return doNextRequest(tBaseResponse.data);
        }
    }

    public abstract ObservableSource<BaseResponse<R>> doNextRequest(T tBaseResponse);
}
