package com.cth.cuotiben.news;

import java.io.Serializable;

/**
 * 新闻相关---只用于新闻相关返回数据！
 * Created by yangjiajia on 2017/5/9 0009.
 */

public class NewsResultBeanInfo<T> implements Serializable {
    private T data;
    private int s;
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
