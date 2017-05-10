package com.cth.cuotiben.news;

import com.cth.cuotiben.common.BaseInfo;

import java.util.List;

/**
 * 新闻列表
 * Created by yangjiajia on 2017/5/9 0009.
 */

public class NewsListInfo extends BaseInfo {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * date : 2016年05月26日 15:43
         * image : http://101.200.163.38/LoginServer/file/download?file=20160526\8cc5b93a878b46daaac3c03535e75675.jpg
         * title : 一本二本三本的区别，99%的人不知道！
         * is_like : false
         * news_id : 123
         * likes : 3
         */

        private String date;
        private String image;
        private String title;
        private boolean is_like;
        private int news_id;
        private int likes;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isIs_like() {
            return is_like;
        }

        public void setIs_like(boolean is_like) {
            this.is_like = is_like;
        }

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "date='" + date + '\'' +
                    ", image='" + image + '\'' +
                    ", title='" + title + '\'' +
                    ", is_like=" + is_like +
                    ", news_id=" + news_id +
                    ", likes=" + likes +
                    '}';
        }
    }
}
