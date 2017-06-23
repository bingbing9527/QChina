package com.qbb.qchina.http.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.qbb.qchina.App;
import com.qbb.qchina.utils.Constants;
import com.qbb.qchina.utils.SPUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建日期：2017/6/19 16:41
 *
 * @author Qian Bing Bing
 *         类说明：
 */

public class RetrofitServiceManager {
    private static final int DEFAULT_TIME_OUT = 15;//超时时间 15s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private final Retrofit mRetrofit;
    private static RetrofitServiceManager retrofitServiceManager;

    private RetrofitServiceManager() {
        //创建okhttp
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)//链接超时时间
                .writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)//写操作 超时时间
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作
        //添加公共参数拦截器
//        builder.addInterceptor(new HttpCommonInterceptor.Builder()
//                .addHeaderParams("essence", "1")
//                .addHeaderParams("iid", "3216590132")
//                .addHeaderParams("device_id", "132613520945")
//                .addHeaderParams("ac", "wifi")
//                .addHeaderParams("channel", "360")
//                .addHeaderParams("aid", "7")
//                .addHeaderParams("app_name", "joke_essay")
//                .addHeaderParams("version_code", "612")
//                .addHeaderParams("version_name", "6.1.2")
//                .addHeaderParams("device_platform", "android")
//                .addHeaderParams("ssmix", "a")
//                .addHeaderParams("device_type", "sansung")
//                .addHeaderParams("device_brand", "xiaomi")
//                .addHeaderParams("os_api", "28")
//                .addHeaderParams("os_version", "6.10.1")
//                .addHeaderParams("uuid", "326135942187625")
////                .addHeaderParams("openudid", "3dg6s95rhg2a3dg5")
//                .addHeaderParams("manifest_version_code", "612")
//                .addHeaderParams("resolution", "1450*2800")
//                .addHeaderParams("dpi", "620")
//                .addHeaderParams("update_version_code", "6120")
//                .build());
        //添加公共参数拦截器,开源中国
        builder.addInterceptor(new HttpCommonInterceptor.Builder()
                .addHeaderParams("access_token", SPUtils.getString("access_token"))
                .build());

        if (!App.isOnlie) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        //创建Retrofit
        mRetrofit = new Retrofit.Builder()
//                .baseUrl(Constants.HTTP.HOST_CONTENT_TYPE)
                .baseUrl(Constants.HTTP.HOST_HOME)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    //获取实例

    public static RetrofitServiceManager getInstance() {
        if (retrofitServiceManager == null) {

            retrofitServiceManager = new RetrofitServiceManager();
        }
        return retrofitServiceManager;
    }

    /**
     * 获取对应的Service
     */
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }
}
