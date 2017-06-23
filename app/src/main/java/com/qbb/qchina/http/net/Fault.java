package com.qbb.qchina.http.net;

/**
 * 创建日期：2017/6/19 17:13
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public class Fault extends Exception {
    private String message;

    public Fault(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
