package com.cth.cuotiben.news;

import java.io.Serializable;

/**
 * 新闻评论
 * Created by yangjiajia on 2017/5/16 0016.
 */

public class NewsCommentInfo implements Serializable {

    /**
     * date : 2016年09月02日 11:01
     * uid : 6996
     * avatar : file_pupil_6996_1480061631
     * content : 👌
     * cid : 123
     * likes : 0
     * username : Stephon Marbury Alle
     */

    private String date;
    private int uid;
    private String avatar;
    private String content;
    private int cid;
    private int likes;
    private String username;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
