package com.cth.cuotiben.delegate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.cth.cuotiben.R;
import com.cth.cuotiben.log.Log;
import com.cth.cuotiben.news.NewsListInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 新闻适配器（兴趣部落，学神攻略）
 * Created by yangjiajia on 2017/5/9 0009.
 */

public class NewsAdapter extends DelegateAdapter.Adapter<NewsAdapter.NewsHolder> {
    private List<NewsListInfo.ListBean> datas;
    private SimpleDateFormat sdf;
    private SimpleDateFormat sdfNew;
    private boolean needHeader = true;

    public NewsAdapter(List<NewsListInfo.ListBean> datas) {
        this.datas = datas;
        sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.getDefault());
        sdfNew = new SimpleDateFormat("MM.dd HH:mm", Locale.getDefault());
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        LinearLayoutHelper layoutHelper = new LinearLayoutHelper();
        layoutHelper.setDividerHeight(1);//1px
        return layoutHelper;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return needHeader ? 100 : 90;/////temp
        } else {
            return 90;
        }
//        return super.getItemViewType(position);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, null);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        NewsListInfo.ListBean bean = datas.get(position);
        holder.tvNewsLikeNum.setText(String.valueOf(bean.getLikes()));
        holder.tvNewsTitle.setText(bean.getTitle());
        try {
            Date date = sdf.parse(bean.getDate());
            String newDate = sdfNew.format(date);
            holder.tvNewsTime.setText(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
            holder.tvNewsTime.setText(bean.getDate());
        }

        String image = bean.getImage();
        Log.d("-----NewsAdapter-----image=" + image);
    }

    @Override
    public int getItemCount() {
        return datas == null ? (needHeader ? 1 : 0) : (needHeader ? datas.size() + 1 : datas.size());
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_new_icon)
        ImageView ivNewIcon;
        @BindView(R.id.tv_news_title)
        TextView tvNewsTitle;
        @BindView(R.id.iv_news_like)
        ImageView ivNewsLike;
        @BindView(R.id.tv_news_like_num)
        TextView tvNewsLikeNum;
        @BindView(R.id.tv_news_time)
        TextView tvNewsTime;

        public NewsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
