package com.cth.cuotiben.api;

import com.cth.cuotiben.common.FileUploadInfo;
import com.cth.cuotiben.common.ResultBeanInfo;
import com.cth.cuotiben.common.VerificationCodeInfo;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
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

}
