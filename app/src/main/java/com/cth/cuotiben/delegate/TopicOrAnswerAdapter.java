package com.cth.cuotiben.delegate;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.cth.cuotiben.R;
import com.cth.cuotiben.log.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * “专属错题本”&“找老师答疑”
 * Created by yangjiajia on 2017/5/9 0009.
 */

public class TopicOrAnswerAdapter extends DelegateAdapter.Adapter<TopicOrAnswerAdapter.TopicOrAnswerHolder> implements View.OnClickListener {

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        GridLayoutHelper helper = new GridLayoutHelper(2);
        helper.setBgColor(Color.parseColor("#f7f7f7"));
//        helper.setMargin(0, 0, 0, 10 * 3);
        return helper;
    }

    @Override
    public TopicOrAnswerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic_or_answer, null);
        return new TopicOrAnswerHolder(view);
    }

    @Override
    public void onBindViewHolder(TopicOrAnswerHolder holder, int position) {
        if (position == 0) {
            holder.topicOrAnserTitle.setText(R.string.text_person_topic_title);
            holder.topicOrAnserIcon.setImageResource(R.drawable.home_topic);
            holder.topicOrAnserSubtitle.setText(R.string.text_person_topic_subtitle);
            holder.itemView.setTag(0);
        } else {
            holder.topicOrAnserTitle.setText(R.string.text_person_answer_title);
            holder.topicOrAnserIcon.setImageResource(R.drawable.home_answer);
            holder.topicOrAnserSubtitle.setText(R.string.text_person_answer_subtitle);
            holder.itemView.setTag(1);
        }

        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void onClick(View v) {
        Integer integer = v.getTag() instanceof Integer ? ((Integer) v.getTag()) : null;
        Log.d("==========vv=" + v.getTag());
        if (integer != null) {
            if (integer == 0) {
                Log.d("=======00===vv=" + v.getTag());
            } else {

            }
        }
    }

    public class TopicOrAnswerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.topic_or_anser_icon)
        ImageView topicOrAnserIcon;
        @BindView(R.id.topic_or_anser_title)
        TextView topicOrAnserTitle;
        @BindView(R.id.topic_or_anser_subtitle)
        TextView topicOrAnserSubtitle;
        @BindView(R.id.topic_or_anser_root)
        RelativeLayout topicOrAnserRoot;

        public TopicOrAnswerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
