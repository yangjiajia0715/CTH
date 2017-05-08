package com.cth.cuotiben.common;

/**
 * 返回结果是单个数据, 若返回数据是列表用{@link ResultListInfo}
 * Created by yangjiajia on 2017/5/8 0028.
 */

public class ResultBeanInfo<R> extends BaseInfo {
    private R data;
    private int flag;
    private String msg;

    public R getData() {
        return data;
    }

    public void setData(R data) {
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
