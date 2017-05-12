package com.cth.cuotiben.activity;

import android.content.Context;
import android.content.Intent;

import com.cth.cuotiben.R;
import com.cth.cuotiben.api.ApiClient;
import com.cth.cuotiben.common.FeeClassInfo;
import com.cth.cuotiben.common.ResultListInfo;
import com.cth.cuotiben.log.Log;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * TestActivity
 * Created by yangjiajia on 2017/5/12 0012.
 */

public class TestActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, TestActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
//        getFeeClass();
        getTT();
    }

    private void getTT() {
    }

    private void getFeeClass() {
        ApiClient.getInstance()
                .getFeeClassList(3428, 1)
                .subscribe(new Observer<ResultListInfo<FeeClassInfo>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResultListInfo<FeeClassInfo> resultListInfo) {

                        Log.d("TestActivity-----getFlag=" + resultListInfo.getFlag());
                        List<FeeClassInfo> infos = resultListInfo.getDatas();
                        Log.d("TestActivity-----getDatas=" + infos);
                        if (infos != null && !infos.isEmpty()) {
                            Log.d("TestActivity-----infos=" + infos.size());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        Log.d("TestActivity-----onError=" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
