package com.qbb.qchina.homepager.bean;

import com.qbb.qchina.core.mvp.MVPBean;

import java.io.Serializable;
import java.util.List;

/**
 * 创建日期：2017/6/19 16:37
 *
 * @author Qian Bing Bing
 *         类说明：首页内容类别
 */

public class HomeContentTypeBean  {

    /**
     * message : success
     * data : [{"double_col_mode":false,"umeng_event":"moment","is_default_tab":false,"url":"http://lf.snssdk.com/neihan/dongtai/dongtai_list/v1/","list_id":-10001,"refresh_interval":7200,"type":3,"name":"关注"},{"double_col_mode":false,"umeng_event":"recommend","is_default_tab":true,"url":"http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-101","list_id":-101,"refresh_interval":7200,"type":1,"name":"推荐"},{"double_col_mode":false,"umeng_event":"video","is_default_tab":false,"url":"http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-104","list_id":-104,"refresh_interval":7200,"type":1,"name":"视频"},{"double_col_mode":true,"umeng_event":"personal_show","is_default_tab":false,"url":"http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-301","list_id":-301,"refresh_interval":7200,"type":1,"name":"段友秀"},{"double_col_mode":false,"umeng_event":"live","is_default_tab":false,"url":"https://hotsoon.snssdk.com/hotsoon/feed/","list_id":-10002,"refresh_interval":7200,"type":6,"name":"直播"},{"double_col_mode":false,"umeng_event":"pic","is_default_tab":false,"url":"http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-103","list_id":-103,"refresh_interval":7200,"type":1,"name":"图片"},{"double_col_mode":false,"umeng_event":"essay","is_default_tab":false,"url":"http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-102","list_id":-102,"refresh_interval":7200,"type":1,"name":"段子"},{"double_col_mode":false,"umeng_event":"essence","is_default_tab":false,"url":"http://ic.snssdk.com/neihan/in_app/essence_list/","list_id":-20002,"refresh_interval":7200,"type":4,"name":"精华"},{"double_col_mode":false,"umeng_event":"local","is_default_tab":false,"url":"http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-201","list_id":-201,"refresh_interval":7200,"type":5,"name":"同城"},{"double_col_mode":false,"umeng_event":"game","is_default_tab":false,"url":"http://ic.snssdk.com/game/game_hall?app_source=essay_android","list_id":-20003,"refresh_interval":7200,"type":4,"name":"游戏"}]
     */
    public List<HomeContentListBean> data;


    @Override
    public String toString() {
        return "HomeContentTypeBean{" +
                "data=" + data +
                '}';
    }
}
