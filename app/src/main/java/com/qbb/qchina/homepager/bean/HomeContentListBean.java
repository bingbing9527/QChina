package com.qbb.qchina.homepager.bean;

/**
 * 创建日期：2017/6/20 18:35
 *
 * @author Qian Bing Bing
 *         类说明：首页类型list内容bean
 */

public class HomeContentListBean {
    /**
     * double_col_mode : false
     * umeng_event : moment
     * is_default_tab : false
     * url : http://lf.snssdk.com/neihan/dongtai/dongtai_list/v1/
     * list_id : -10001
     * refresh_interval : 7200
     * type : 3
     * name : 关注
     */

    public boolean double_col_mode;
    public String umeng_event;
    public boolean is_default_tab;
    public String url;
    public int list_id;
    public int refresh_interval;
    public int type;
    public String name;

    @Override
    public String toString() {
        return "DataBean{" +
                "double_col_mode=" + double_col_mode +
                ", umeng_event='" + umeng_event + '\'' +
                ", is_default_tab=" + is_default_tab +
                ", url='" + url + '\'' +
                ", list_id=" + list_id +
                ", refresh_interval=" + refresh_interval +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
