package com.cth.cuotiben.news;

import com.cth.cuotiben.common.BaseInfo;

import java.util.List;

/**
 * 新闻详情
 * Created by yangjiajia on 2017/5/10 0010.
 */

public class NewsDetailInfo extends BaseInfo {

    /**
     * date : 2016-07-27
     * image : http://101.200.163.38/LoginServer/file/download?file=20160526\deaf187cc77b44d0aacac047a3595bf2.jpg
     * is_like : true
     * share_url : http://101.200.163.38/LoginServer/news/detail/96
     * source : 网络
     * recommends : [{"title":"成都新科文理科状元谈学习方法","news_id":158}]
     * title : 【图解】20省高考改革新政大汇总
     * news_id : 96
     * content : <!DOCTYPE html><html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"><meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/><meta name="apple-mobile-web-app-capable" content="yes"><meta name="apple-mobile-web-app-status-bar-style" content="black"><meta name="format-detection" content="telephone=no"><style type="text/css">body{    max-width:640px;    margin: 0;    padding: 0;    border: 0;}img {    max-width: 100%;}embed,video,audio{    max-width: 100%;}</style><script type="text/javascript">function insertAfter( newElement, targetElement){	var parent = targetElement.parentNode;	if(parent.lastChild == targetElement ){		parent.appendChild( newElement, targetElement );	}else{		parent.insertBefore( newElement, targetElement.nextSibling );	}	parent.removeChild(targetElement);};var getVQQUrl=function(src,iframeWidth){	if(src.indexOf(".qq.com/") > 0 && (src.toLowerCase().indexOf("?vid=") > 0 || src.toLowerCase().indexOf("&vid=") > 0)){		var vid = "";		var url = src.split("?")[0];		var params = src.split("?")[1];		var paramArr = params.split("&");		for(var j=0;j<paramArr.length;j++){			if(paramArr[j].split("=")[0].toLowerCase() == "vid"){				vid = paramArr[j].split("=")[1];			break;			}        }		var qqSrc = "http://v.qq.com/iframe/player.html?vid="+vid+"&width="+iframeWidth+"&height="+(iframeWidth*9/16)+"&auto=0";		return qqSrc;	}	return url;};window.onload=function(){	var embedArr = document.getElementsByTagName("embed");	for ( var i = 0; i < embedArr.length; i++) {		var embed = embedArr[i];		var src = embed.getAttribute("src");		var iframe = document.createElement("iframe");		iframe.setAttribute("src",src);		insertAfter(iframe,embed);	}	var iframeArr = document.getElementsByTagName("iframe");	var h = document.body.clientHeight;	var w = document.body.clientWidth;	var iframeWidth = w-20;	for ( var i = 0; i < iframeArr.length; i++) {		iframeArr[i].width = iframeWidth;		iframeArr[i].height = iframeWidth*9/16;		iframeArr[i].setAttribute("style","border: 0px;");		iframeArr[i].setAttribute("class","");		var src = iframeArr[i].getAttribute("src");		iframeArr[i].setAttribute("src",getVQQUrl(src,iframeWidth));	}};</script></head><body><div style="padding-left:10px;padding-right:10px;-webkit-box-sizing:border-box!important;word-wrap: break-word!important;"><p>
     近期，多省份密集出台高考改革方案，新方案引起家长、学生和社会各界人士热议。你的家乡如何改革？“图啥”栏目告诉你。&nbsp;
     </p>
     <p style="text-align:center;">
     <img src="http://101.200.163.38/LoginS</div></body></html>
     * desc : 错题会
     */

    private String date;
    private String image;
    private boolean is_like;
    private String share_url;
    private String source;
    private String title;
    private int news_id;
    private String content;
    private String desc;
    private List<RecommendsBean> recommends;

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

    public boolean isIs_like() {
        return is_like;
    }

    public void setIs_like(boolean is_like) {
        this.is_like = is_like;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<RecommendsBean> getRecommends() {
        return recommends;
    }

    public void setRecommends(List<RecommendsBean> recommends) {
        this.recommends = recommends;
    }

    public static class RecommendsBean {
        /**
         * title : 成都新科文理科状元谈学习方法
         * news_id : 158
         */

        private String title;
        private int news_id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }
    }
}
