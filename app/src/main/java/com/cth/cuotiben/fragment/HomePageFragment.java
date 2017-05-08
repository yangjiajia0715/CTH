package com.cth.cuotiben.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cth.cuotiben.R;

/**
 * 首页--主页
 * Created by yangjiajia on 2017/5/8 0008.
 */

public class HomePageFragment extends BaseFragment {
    public static HomePageFragment newInstance() {

        Bundle args = new Bundle();

        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mMainView = inflater.inflate(R.layout.fragment_home_page, null,false);
        return mMainView;
    }
}
