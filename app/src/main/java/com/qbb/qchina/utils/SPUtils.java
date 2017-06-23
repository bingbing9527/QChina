package com.qbb.qchina.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.qbb.qchina.App;

/**
 * 创建日期：2017/6/23 11:18
 *
 * @author Qian Bing Bing
 *         类说明： SharedPreferences工具类
 */

public class SPUtils {

    public static void puString(String key, String value) {
        App.getSharedPreferences().edit().putString(key, value).apply();
    }

    public static String getString(String key, @Nullable String defValue) {
        return App.getSharedPreferences().getString(key, defValue);
    }

    public static String getString(String key) {
        return App.getSharedPreferences().getString(key, "");
    }

}
