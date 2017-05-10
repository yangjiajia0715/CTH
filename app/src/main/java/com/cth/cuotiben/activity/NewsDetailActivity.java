package com.cth.cuotiben.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.cth.cuotiben.R;
import com.cth.cuotiben.api.ApiClient;
import com.cth.cuotiben.log.Log;
import com.cth.cuotiben.news.NewsDetailInfo;
import com.cth.cuotiben.news.NewsResultBeanInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * 新闻详情
 * Created by yangjiajia on 2017/5/10 0010.
 */

public class NewsDetailActivity extends BaseActivity {
    private static final String EXTRA_NEWS_ID = "extra_news_id";
    private static final int SHARE_RESULT_SUCCESS = 0;
    private static final int SHARE_RESULT_CANCEL = 1;
    private static final int SHARE_RESULT_FAIL = 2;

    private static final int REFRESH_WEBVIEW_HEIGHT = 3;

    @BindView(R.id.recycleview_news_content)
    RecyclerView recyclerView;
    private DelegateAdapter delegateAdapter;
    private int newsId;

    private int tempPupulId = 4294;
    private int tempNewsId = 96;
    private int tempNewsId1 = 130;

    private Handler mHandler = new Handler() {

    };

    public static void start(Context context, int newsId) {
        Intent starter = new Intent(context, NewsDetailActivity.class);
//        starter.putExtra();
        starter.putExtra(EXTRA_NEWS_ID, newsId);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void initView() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        delegateAdapter = new DelegateAdapter(layoutManager);
        recyclerView.setAdapter(delegateAdapter);
    }

    @Override
    protected void initData() {
        newsId = getIntent().getIntExtra(EXTRA_NEWS_ID, 0);
        Log.d("NewsDetailActivity---newsId=" + newsId);
        //ok
        //{"msg":"没有找到","s":404,"data":{}}
        //分享 注意downloadFlag
        ApiClient.getInstance()
                .getNewsDetail(tempPupulId, tempNewsId)
                .subscribe(new Consumer<NewsResultBeanInfo<NewsDetailInfo>>() {
                    @Override
                    public void accept(@NonNull NewsResultBeanInfo<NewsDetailInfo> newsResultBeanInfo) throws Exception {
                        NewsDetailInfo newsDetailInfo = newsResultBeanInfo.getData();

                        Log.d("getNewsDetail--newsDetailInfo=" + newsDetailInfo);
                        if (newsDetailInfo != null) {
                            Log.d("getNewsDetail--getDesc=" + newsDetailInfo.getDesc());
                        }
                        delegateAdapter.addAdapter(new NewsDetalHeaderAdapter(newsDetailInfo));

                    }
                });

    }

    /**
     * header
     */
    class NewsDetalHeaderAdapter extends DelegateAdapter.Adapter<NewsDetalHeaderAdapter.NewsDetailHeaderHolder> {

        private NewsDetailInfo info;
        WebView wvNewsContent;

        public NewsDetalHeaderAdapter(NewsDetailInfo newsDetailInfo) {
            this.info = newsDetailInfo;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return new LinearLayoutHelper();
        }

        @Override
        public NewsDetailHeaderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_view_news_content, null);
            return new NewsDetailHeaderHolder(view);
        }

        @Override
        public void onBindViewHolder(final NewsDetailHeaderHolder holder, int position) {
            wvNewsContent = holder.wvNewsContent;
            holder.tvNewsTitle.setText(info.getTitle());
            holder.tvNewsAuthor.setText(info.getDesc());
            holder.tvNewsTime.setText(info.getDate());

            holder.wvNewsContent.setBackgroundColor(Color.TRANSPARENT);
            holder.wvNewsContent.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            holder.wvNewsContent.getSettings().setJavaScriptEnabled(true); //设置支持Javascript
            holder.wvNewsContent.requestFocus(); //触摸焦点起作用.如果不设置，则在点击网页文本输入框时，不能弹出软键盘及不响应其他的一些事件。
//      luntanListview.getSettings().setBuiltInZoomControls(true); //页面添加缩放按钮
//      luntanListview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);   //取消滚动条

            //点击链接由自己处理，而不是新开Android的系统browser响应该链接。
            holder.wvNewsContent.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //设置点击网页里面的链接还是在当前的webview里跳转
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    mHandler.sendEmptyMessageDelayed(REFRESH_WEBVIEW_HEIGHT, 1000);
                    Log.d("NewsDetailActivity--onPageFinished=");
                    int height = view.getHeight();
                    holder.wvNewsContent.loadUrl("javascript:MyApp.resize(document.body.getBoundingClientRect().height)");
                }
            });

            holder.wvNewsContent.setWebChromeClient(new WebChromeClient());
            holder.wvNewsContent.addJavascriptInterface(this, "MyApp");

//            ViewGroup.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            holder.wvNewsContent.setLayoutParams(lp);
            Log.d("NewsDetailActivity--getContent=" + info.getContent());
            holder.wvNewsContent.loadDataWithBaseURL(null, info.getContent(), "text/html", "utf-8",
                    null);
//            showWebView(activity, mContent);
        }

        @JavascriptInterface
        public void resize(final float height) {

            if (wvNewsContent == null)
                return;

            new Runnable() {

                @Override
                public void run() {
                    float currentHeight = Math.max(height, wvNewsContent.getContentHeight());
                    wvNewsContent.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels, (int) (currentHeight * getResources().getDisplayMetrics().density)));
                }
            }.run();
//            wvNewsContent.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    float currentHeight = Math.max(height, mWvNewsContent.getContentHeight());
//                    mWvNewsContent.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels, (int) (currentHeight * getResources().getDisplayMetrics().density)));
//                }
//            });
        }

//        private void showWebView(final NewsContentActivity activity, String content) {
//            // 设置WevView要显示的网页
//            if(activity == null || activity.mWvNewsContent == null){
//                return;
//            }
//            Log.d("------content = "+content);
//            activity.mWvNewsContent.loadDataWithBaseURL(null, content, "text/html", "utf-8",
//                    null);
//        }

        @Override
        public int getItemCount() {
            return info == null ? 0 : 1;
        }

        class NewsDetailHeaderHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_news_title)
            TextView tvNewsTitle;
            @BindView(R.id.tv_news_author)
            TextView tvNewsAuthor;
            @BindView(R.id.tv_news_time)
            TextView tvNewsTime;
            @BindView(R.id.wv_news_content)
            WebView wvNewsContent;
            @BindView(R.id.tv_news_recommend_tips)
            TextView tvNewsRecommendTips;
            @BindView(R.id.ll_news_recommend)
            LinearLayout llNewsRecommend;

            public NewsDetailHeaderHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
