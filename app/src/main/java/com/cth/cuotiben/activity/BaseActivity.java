package com.cth.cuotiben.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cth.cuotiben.R;

import butterknife.ButterKnife;

/**
 * BaseActivity
 * Created by yangjiajia on 2017/5/5 0005.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
            initToolBar(mToolBar);
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        initView();
        initData();
    }

    private void initToolBar(Toolbar mToolBar) {

    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
