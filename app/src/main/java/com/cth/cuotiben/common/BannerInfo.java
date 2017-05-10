package com.cth.cuotiben.common;

import java.util.List;

/**
 * 轮播图
 * Created by yangjiajia on 2017/5/9 0009.
 */

public class BannerInfo extends BaseInfo {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * image : http://www.51cth.com/LoginServer/file/download?file=20160624\6490c0cd48da4945ac9fa22e91ec44d0.jpg
         * news_id : 332
         */

        private String image;
        private int news_id;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }
    }
}
