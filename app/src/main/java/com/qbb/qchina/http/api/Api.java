package com.qbb.qchina.http.api;

import com.qbb.qchina.homepager.bean.HomeContentListBean;
import com.qbb.qchina.homepager.bean.HomeContentTypeBean;
import com.qbb.qchina.homepager.bean.HomeRecommendBean;
import com.qbb.qchina.http.net.BaseResponse;
import com.qbb.qchina.login.bean.AccessTokenBean;

import java.util.List;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 创建日期：2017/6/19 16:29
 *
 * @author Qian Bing Bing
 *         类说明：接口
 */

public interface Api {


    @GET("service/tabs/")
    Observable<BaseResponse<List<HomeContentListBean>>> getHomeContentType(@QueryMap Map<String,String> map);
    @GET
    Observable<BaseResponse<HomeRecommendBean>> getHomeRecommend1(@Url String url);
    @GET
    Observable<BaseResponse<HomeRecommendBean>> getHomeRecommend(@Url String url);



    @GET("action/openapi/token")
    Observable<BaseResponse<AccessTokenBean>> getAccessToken(@QueryMap Map<String,String> map);




//    @GET
//    Observable<BaseResponse<HomeContentTypeBean>> getHomeContentType(@Body BaseRequest baseRequest);

//    @FormUrlEncoded
//    @POST("/collection/request.action")
//    Observable<BaseResponse<HomeContentTypeBean>> getHomeContentType(@Field("data") String request );
}
