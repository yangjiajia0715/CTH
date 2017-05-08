package com.cth.cuotiben.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cth.cuotiben.R;

/**
 * 主页--聊天
 * Created by yangjiajia on 2017/5/8 0008.
 */

public class ChatFragment extends BaseFragment {
    public static ChatFragment newInstance() {

        Bundle args = new Bundle();

        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mMainView = inflater.inflate(R.layout.fragment_chat, null,false);
        return mMainView;
    }
}
