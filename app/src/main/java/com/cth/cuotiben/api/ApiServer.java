package com.cth.cuotiben.api;

import com.cth.cuotiben.common.BeanInfo;
import com.cth.cuotiben.common.FeeClassInfo;
import com.cth.cuotiben.common.FileUploadInfo;
import com.cth.cuotiben.common.ResultBeanInfo;
import com.cth.cuotiben.common.ResultListInfo;
import com.cth.cuotiben.common.TT;
import com.cth.cuotiben.common.VerificationCodeInfo;
import com.cth.cuotiben.news.NewsDetailInfo;
import com.cth.cuotiben.news.NewsListInfo;
import com.cth.cuotiben.news.NewsResultBeanInfo;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * 接口类--配合Retrofit使用
 * <p>
 * 通过{@link ApiClient}调用
 * Created by yangjiajia on 2017/5/8 0008.
 */

public interface ApiServer {

    /**
     * 获取验证码
     */
    @POST("LoginServer/appServlet")
    Observable<ResultBeanInfo<VerificationCodeInfo>> getVerificationCode(@Query("params") String params);

    @Multipart
    @POST("LoginServer/px/file/upload.json")
    Observable<ResultBeanInfo<FileUploadInfo>> uploadFile(@Part MultipartBody.Part part);

    /**
     * @param type 新闻类型：1:兴趣部落,2:学神攻略
     */
    @GET("LoginServer/news/list.json")
    Observable<NewsResultBeanInfo<NewsListInfo>> getNewsList(@Query("uid") int pupilId, @Query("type") int type, @Query("page") int page);

    /**
     * 新闻详情
     */
    @GET("LoginServer/news/detail.json")
    Observable<NewsResultBeanInfo<NewsDetailInfo>> getNewsDetail(@Query("uid") int pupilId, @Query("news_id") int newsId);

    @GET("LoginServer/feeClass/findAllInSchoolByPupil.json")
    Observable<ResultListInfo<FeeClassInfo>> getFeeClassList(@Query("pupilId") int pupilId, @Query("_pageNum") int pageum);

    @GET("LoginServer/feeClass/findAllInSchoolByPupil.json")
    Observable<TT<BeanInfo>> getTT(@Query("pupilId") int pupilId, @Query("_pageNum") int pageum);
}
