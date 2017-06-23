package com.qbb.qchina.http.net;

/**
 * 创建日期;//2017/6/19 17:23
 *
 * @author Qian Bing Bing
 *         类说明;//
 */

public class BaseRequest {
    public String essence = "1";      //固定值 1
    public String iid = "3216590132"; //一个长度为10的纯数字字符串，用于标识用户唯一性
    public String device_id = "32613520945";//设备 id，一个长度为11的纯数字字符串
    public String ac = "wifi";               //网络环境，可取值 wifi
    public String channel = "360";           //下载渠道，可360、tencent等
    public String aid = "7";                  //固定值7
    public String app_name = "joke_essay";    //固定值joke_essay
    public String version_code = "612";       //版本号去除小数点，例如612
    public String version_name = "6.1.2";     //版本号，例如6.1.2
    public String device_platform = "android";//设备平台，android 或 ios
    public String ssmix = "a";                //固定值 a
    public String device_type = "sansung";    //设备型号，例如 hongmi
    public String device_brand = "xiaomi";    //设备品牌，例如 xiaomi
    public String os_api = "28";              //操作系统版本，例如20
    public String os_version = "6.10.1";      //操作系统版本号，例如7.1.0
    public String uuid = "326135942187625";   //用户 id，一个长度为15的纯数字字符串
    public String openudid = "3dg6s95rhg2a3dg5";//一个长度为16的数字和小写字母混合字符串
    public String manifest_version_code = "612";//版本号去除小数点，例如612
    public String resolution = "1450*2800";     //屏幕宽高，例如 1920*1080
    public String dpi = "620";                  //手机 dpi
    public String update_version_code = "6120";   //版本号去除小数点后乘10，例如6120
}
