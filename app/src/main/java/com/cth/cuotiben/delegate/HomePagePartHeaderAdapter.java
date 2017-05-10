package com.cth.cuotiben.delegate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.cth.cuotiben.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页 每个区域的头部 ：  (eg. 今日微课-------------全部 > )
 * Created by yangjiajia on 2017/5/10 0010.
 */

public class HomePagePartHeaderAdapter extends DelegateAdapter.Adapter<HomePagePartHeaderAdapter.PartHeaderHolder> {

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        LinearLayoutHelper layoutHelper = new LinearLayoutHelper();
        layoutHelper.setDividerHeight(1);
        return layoutHelper;
    }

    @Override
    public PartHeaderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_home_page_part_header, null);
        return new PartHeaderHolder(view);
    }

    @Override
    public void onBindViewHolder(PartHeaderHolder holder, int position) {
        holder.homePagePartLeft.setText("学神归来");
        holder.homePagePartRight.setText("全部");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class PartHeaderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_page_part_left)
        TextView homePagePartLeft;
        @BindView(R.id.home_page_part_right)
        TextView homePagePartRight;

        public PartHeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
