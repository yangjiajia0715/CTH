package com.cth.cuotiben.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cth.cuotiben.R;

/**
 * 首页--答疑
 * Created by yangjiajia on 2017/5/8 0008.
 */

public class AnswerFragment extends BaseFragment {
    public static AnswerFragment newInstance() {

        Bundle args = new Bundle();

        AnswerFragment fragment = new AnswerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mMainView = inflater.inflate(R.layout.fragment_answer, null,false);
        return mMainView;
    }
}
