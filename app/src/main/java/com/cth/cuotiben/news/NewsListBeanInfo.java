package com.cth.cuotiben.news;

import java.io.Serializable;
import java.util.List;

/**
 * 新闻列表Bean类,泛型为评论等
 * Created by yangjiajia on 2017/5/21 0021.
 */

public class NewsListBeanInfo<T> implements Serializable {

    //{"list":[{"date":"01月11日 12:46","uid":10178,"avatar":"file_pupil_10178_1467889148","content":"风风光光","cid":156,"likes":0,"username":"轩轩"}
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
