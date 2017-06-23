package com.qbb.qchina.http.net;

import java.io.Serializable;

/**
 * 创建日期：2017/6/19 16:39
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public class BaseResponse<T>  {
    public String message;
    public T data;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "message='" + message + '\'' +
                ", responseBody=" + data +
                '}';
    }
}
