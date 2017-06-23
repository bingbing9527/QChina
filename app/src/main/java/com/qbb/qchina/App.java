package com.qbb.qchina;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 创建日期：2017/5/10 14:44
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public class App extends Application {

    public static Context context;
    public static boolean isOnlie = false;
    private static SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();
        context = App.this;

    }

    public static SharedPreferences getSharedPreferences(){
        if (null == sp) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sp;
    }
}
