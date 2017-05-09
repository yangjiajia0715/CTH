package com.cth.cuotiben.api;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cth.cuotiben.BuildConfig;
import com.cth.cuotiben.R;
import com.cth.cuotiben.common.FileUploadInfo;
import com.cth.cuotiben.common.ResultBeanInfo;
import com.cth.cuotiben.common.VerificationCodeInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 通过该类调用接口ApiServer
 * <p>
 * 直接调用 或者 通过{@link ApiHelper}封装请求
 * Created by yangjiajia on 2017/5/8 0008.
 */

public class ApiClient {
    private static final String TAG = "ApiClient";
    private static final int CONNECT_TIME_OUT = 20;//连接超时 20s
    private static final int READER_TIME_OUT = 20;//读取超时 20s
    private OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    private static ApiClient INSTANCE;
    private final ApiServer apiServer;
    private ApiServer apiServerWithGson;

    public static ApiClient getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ApiClient();
        return INSTANCE;
    }

    private ApiClient() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READER_TIME_OUT, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .callFactory(okHttpClient)//注意：全局共用
                .baseUrl(BuildConfig.IP_ADDRESS)//注意：以"/"结束
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiServer = retrofit.create(ApiServer.class);
    }

    /**
     * 需要Gson处理时调用，否者直接用{@link ApiClient#apiServer}
     */
    private ApiServer getApiServerWithGson() {
        if (apiServerWithGson == null) {
            Retrofit retrofitFileUpload = retrofit.newBuilder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiServerWithGson = retrofitFileUpload.create(ApiServer.class);
        }

        return apiServerWithGson;
    }

    /**
     * 获取验证码
     */
    public Observable<ResultBeanInfo<VerificationCodeInfo>> getVerificationCode(@NonNull Context context,
                                                                                String phoneNumber,
                                                                                String verifyCodeMode) {
        JSONObject params = new JSONObject();
        try {
            params.put("dataType", "getVerifyCode");
            params.put("phoneNumber", phoneNumber);
            params.put("verifyCodeMode", verifyCodeMode);
            params.put("appName", context.getString(R.string.app_name));//2017-3-8,用户验证码
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getApiServerWithGson().getVerificationCode(params.toString());
    }

    /**
     * 上传文件
     */
    public Observable<ResultBeanInfo<FileUploadInfo>> uploadFile(@android.support.annotation.NonNull File file) {

        RequestBody body = MultipartBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), body);

        return getApiServerWithGson().uploadFile(part)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }

}
