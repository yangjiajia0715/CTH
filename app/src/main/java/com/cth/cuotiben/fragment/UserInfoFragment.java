package com.cth.cuotiben.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cth.cuotiben.R;

/**
 * 首页--我的
 * Created by yangjiajia on 2017/5/8 0008.
 */

public class UserInfoFragment extends BaseFragment {
    public static UserInfoFragment newInstance() {

        Bundle args = new Bundle();

        UserInfoFragment fragment = new UserInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mMainView = inflater.inflate(R.layout.fragment_userinfo, null,false);
        return mMainView;
    }
}
