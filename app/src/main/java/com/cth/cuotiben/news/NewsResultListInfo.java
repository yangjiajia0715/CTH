package com.cth.cuotiben.news;

import java.io.Serializable;

/**
 * 新闻相关---只用于新闻相关返回数据！
 * Created by yangjiajia on 2017/5/9 0009.
 */

public class NewsResultListInfo<T> implements Serializable {

    /**
     * msg :
     * s : 200
     * data : {"list":[{"date":"01月11日 12:46","uid":10178,"avatar":"file_pupil_10178_1467889148","content":"风风光光","cid":156,"likes":0,"username":"轩轩"},{"date":"2016年09月02日 11:01","uid":6996,"avatar":"file_pupil_6996_1480061631","content":"👌","cid":123,"likes":0,"username":"Stephon Marbury Alle"},{"date":"2016年05月24日 14:49","uid":5257,"avatar":"file_pupil_5257_1464018035","content":"有问题","cid":52,"likes":0,"username":"测试账号19"},{"date":"2016年05月23日 10:31","uid":1511,"avatar":"15112016-03-10-13-50-23","content":"yyyyyyyyyyy","cid":34,"likes":1,"username":"戴少东"},{"date":"2016年05月23日 09:59","uid":1511,"avatar":"http://101.200.163.38/LoginServer/downloadServlet/8f0dfd91f4c381615c9703f8abd15cc7","content":"hahahhahaahha","cid":33,"likes":0,"username":""}]}
     */

    private String msg;
    private int s;
    private NewsListBeanInfo<T> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public NewsListBeanInfo<T> getData() {
        return data;
    }

    public void setData(NewsListBeanInfo data) {
        this.data = data;
    }

}
