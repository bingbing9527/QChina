package com.qbb.qchina.homepager.bean;

import com.qbb.qchina.main.ui.bean.ActivityBean;
import com.qbb.qchina.main.ui.bean.CommentsBean;
import com.qbb.qchina.main.ui.bean.DislikeReasonBean;
import com.qbb.qchina.main.ui.bean.LargeImageBean;
import com.qbb.qchina.main.ui.bean.MiddleImageBean;
import com.qbb.qchina.main.ui.bean.UserBean;

import java.util.List;

/**
 * 创建日期：2017/6/21 10:45
 *
 * @author Qian Bing Bing
 *         类说明：首页推荐
 */

public class HomeRecommendBean {

    public boolean has_more;
    public String tip;
    public boolean has_new_message;
    public double max_time;
    public int min_time;
    public List<DataBean> data;

    public static class DataBean {

        public GroupBean group;
        public int type;
        public String display_time;
        public String online_time;
        public List<CommentsBean> comments;

        public static class GroupBean {

            public UserBean user;
            public String text;
            public int create_time;
            public long id;
            public int favorite_count;
            public int go_detail_count;
            public int user_favorite;
            public int share_type;
            public double max_screen_width_percent;
            public int is_can_share;
            public int category_type;
            public String share_url;
            public int label;
            public String content;
            public int comment_count;
            public String id_str;
            public int media_type;
            public int share_count;
            public int type;
            public int status;
            public int has_comments;
            public LargeImageBean large_image;
            public int user_bury;
            public String status_desc;
            public int display_type;
            public int user_digg;
            public int online_time;
            public String category_name;
            public boolean category_visible;
            public int bury_count;
            public boolean is_anonymous;
            public int repin_count;
            public double min_screen_width_percent;
            public int digg_count;
            public int is_gif;
            public int has_hot_comments;
            public boolean allow_dislike;
            public int image_status;
            public int user_repin;
            public ActivityBean activity;
            public long group_id;
            public MiddleImageBean middle_image;
            public int category_id;
            public List<DislikeReasonBean> dislike_reason;

        }


    }
}
