package com.cth.cuotiben.delegate;

import android.content.Context;
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
import com.cth.cuotiben.news.NewsCommentInfo;

import java.util.List;

import butterknife.BindView;

/**
 * 新闻评论adapter
 * Created by yangjiajia on 2017/5/21 0021.
 */

public class NewsCommentsAdapter extends DelegateAdapter.Adapter<NewsCommentsAdapter.NewsCommmentHolder> {
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_comment_time)
    TextView tvCommentTime;
    @BindView(R.id.tv_comment_content)
    TextView tvCommentContent;
    @BindView(R.id.tv_like)
    TextView tvLike;
    private Context context;
    List<NewsCommentInfo> commentInfos;

    public NewsCommentsAdapter(Context context, List<NewsCommentInfo> commentInfos) {
        this.context = context;
        this.commentInfos = commentInfos;
    }

    public NewsCommentsAdapter(List<NewsCommentInfo> commentInfos) {
        this.commentInfos = commentInfos;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @Override
    public NewsCommmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_comment, null);
        return new NewsCommmentHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsCommmentHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NewsCommmentHolder extends RecyclerView.ViewHolder {
        public NewsCommmentHolder(View itemView) {
            super(itemView);
        }
    }

}
