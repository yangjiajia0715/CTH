package com.cth.cuotiben.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.Toast;


@SuppressLint("NewApi")
public class BaseFragment extends Fragment {
    // fragment是否显示了
    protected boolean mIsVisible = false;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void toastMessage(String text) {
        if (!TextUtils.isEmpty(text) && mContext != null && isAdded()) {
            Toast.makeText(mContext.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            mIsVisible = true;

            onVisible();
        } else {
            mIsVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
    }

    protected void onInvisible() {
    }

}
