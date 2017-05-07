package com.cth.cuotiben.activity;

import com.cth.cuotiben.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        List<String> strings = new ArrayList<>();
        strings.add("hhh");
        strings.add("hhh2");
        strings.add("hhh3");

        String[] strs = new String[strings.size()];
        strings.toArray(strs);

        Observable.fromIterable(strings)
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {

                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {

                    }
                });
    }

    @Override
    protected void initData() {
    }
}
