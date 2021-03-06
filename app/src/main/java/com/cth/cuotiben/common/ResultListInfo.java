package com.cth.cuotiben.common;

import java.io.Serializable;
import java.util.List;

/**
 * 返回结果是列表, 若返回数据不是列表用{@link ResultBeanInfo}
 * Created by yangjiajia on 2017/4/28 0028.
 */

public class ResultListInfo<T> implements Serializable {
    private List<T> data;
    private int flag;
    private String msg;

    public List<T> getDatas() {
        return data;
    }

    public void setDatas(List<T> data) {
        this.data = data;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
