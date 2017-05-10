package com.cth.cuotiben.delegate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.cth.cuotiben.R;

/**
 * 首页轮播图
 * Created by yangjiajia on 2017/5/9 0009.
 */

public class BannerAdapter extends DelegateAdapter.Adapter<BannerAdapter.BannerHolder> {

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        LinearLayoutHelper layoutHelper = new LinearLayoutHelper();
        return layoutHelper;
    }

    @Override
    public BannerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, null);
        return  new BannerHolder(view);
    }

    @Override
    public void onBindViewHolder(BannerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class BannerHolder extends RecyclerView.ViewHolder {

        public BannerHolder(View itemView) {
            super(itemView);
        }
    }
}
