package com.qbb.qchina.utils;

/**
 * 创建日期：2017/5/12 16:21
 *
 * @author Qian Bing Bing
 *         类说明：常量类
 */

public class Constants {
    //应用级别
    public static class APP {
        public static final String APPID = "HUMUOC2yF4nEOsUjRJjX";
        public static final String APPKEY = "FkwCXrkJLau5xCWJGESWElznJRFwVPsC";
    }

    //网络常量
    public static class HTTP{
        public static final String HOST_OS_HOME= "https://www.oschina.net/action/oauth2/";//开源中国

        public static final String HOST_HOME= "http://lf.snssdk.com/neihan/";//内涵段子HOST
        public static final String HOST_CONTENT_TYPE= "http://iu.snssdk.com/neihan/stream/mix/v1/";//内涵段子分类HOST
        public static final String HOST_CONTENT_LIVE= "http://hotsoon.snssdk.com/hotsoon/feed/";//内涵段子直播HOST
        public static final String HOST_N_EG = "http://lf.snssdk.com/neihan/service/tabs/?" +//内涵段子首页示例请求
                "essence=1&" +      //固定值 1
                "iid=3216590132&" + //一个长度为10的纯数字字符串，用于标识用户唯一性
                "device_id=32613520945&" +//设备 id，一个长度为11的纯数字字符串
                "ac=wifi&" +               //网络环境，可取值 wifi
                "channel=360&" +           //下载渠道，可360、tencent等
                "aid=7&" +                  //固定值7
                "app_name=joke_essay&" +    //固定值joke_essay
                "version_code=612&" +       //版本号去除小数点，例如612
                "version_name=6.1.2&" +     //版本号，例如6.1.2
                "device_platform=android&" +//设备平台，android 或 ios
                "ssmix=a&" +                //固定值 a
                "device_type=sansung&" +    //设备型号，例如 hongmi
                "device_brand=xiaomi&" +    //设备品牌，例如 xiaomi
                "os_api=28&" +              //操作系统版本，例如20
                "os_version=6.10.1&" +      //操作系统版本号，例如7.1.0
                "uuid=326135942187625&" +   //用户 id，一个长度为15的纯数字字符串
                "openudid=3dg6s95rhg2a3dg5&" +//一个长度为16的数字和小写字母混合字符串
                "manifest_version_code=612&" +//版本号去除小数点，例如612
                "resolution=1450*2800&" +     //屏幕宽高，例如 1920*1080
                "dpi=620&" +                  //手机 dpi
                "update_version_code=6120";   //版本号去除小数点后乘10，例如6120
        public static final String URL =  "essence=1&" +      //固定值 1
                "iid=3216590132&" + //一个长度为10的纯数字字符串，用于标识用户唯一性
                "device_id=32613520945&" +//设备 id，一个长度为11的纯数字字符串
                "ac=wifi&" +               //网络环境，可取值 wifi
                "channel=360&" +           //下载渠道，可360、tencent等
                "aid=7&" +                  //固定值7
                "app_name=joke_essay&" +    //固定值joke_essay
                "version_code=612&" +       //版本号去除小数点，例如612
                "version_name=6.1.2&" +     //版本号，例如6.1.2
                "device_platform=android&" +//设备平台，android 或 ios
                "ssmix=a&" +                //固定值 a
                "device_type=sansung&" +    //设备型号，例如 hongmi
                "device_brand=xiaomi&" +    //设备品牌，例如 xiaomi
                "os_api=28&" +              //操作系统版本，例如20
                "os_version=6.10.1&" +      //操作系统版本号，例如7.1.0
                "uuid=326135942187625&" +   //用户 id，一个长度为15的纯数字字符串
                "openudid=3dg6s95rhg2a3dg5&" +//一个长度为16的数字和小写字母混合字符串
                "manifest_version_code=612&" +//版本号去除小数点，例如612
                "resolution=1450*2800&" +     //屏幕宽高，例如 1920*1080
                "dpi=620&" +                  //手机 dpi
                "update_version_code=6120";   //版本号去除小数点后乘10，例如6120
    }

    public static class Stutas{
        public static final String SUCCESS = "success";
    }
}
