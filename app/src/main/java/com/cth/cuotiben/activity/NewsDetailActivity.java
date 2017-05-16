package com.cth.cuotiben.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
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
import com.cth.cuotiben.news.NewsComment;
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
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case REFRESH_WEBVIEW_HEIGHT:

                    Log.d("NewsDetailActivity----newsDetalHeaderAdapter=" + newsDetalHeaderAdapter);
                    if (newsDetalHeaderAdapter != null && newsDetalHeaderAdapter.webView != null) {
                        newsDetalHeaderAdapter.webView.loadUrl("javascript:MyApp.resize(document.body.getBoundingClientRect().height)");
                        Log.d("NewsDetailActivity----newsDetalHeaderAdapter 99999=");
                    }

//                    if(activity.mWvNewsContent == null){
//                        return;
//                    }
//                    activity.mWvNewsContent.loadUrl("javascript:MyApp.resize(document.body.getBoundingClientRect().height)");
                    break;

                default:
                    break;
            }
        }
    };
    private NewsDetalHeaderAdapter newsDetalHeaderAdapter;

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
                .getNewsDetail(tempPupulId, newsId)
                .subscribe(new Consumer<NewsResultBeanInfo<NewsDetailInfo>>() {

                    @Override
                    public void accept(@NonNull NewsResultBeanInfo<NewsDetailInfo> newsResultBeanInfo) throws Exception {
                        NewsDetailInfo newsDetailInfo = newsResultBeanInfo.getData();

                        Log.d("getNewsDetail--newsDetailInfo=" + newsDetailInfo);
                        if (newsDetailInfo != null) {
                            Log.d("getNewsDetail--getDesc=" + newsDetailInfo.getDesc());
                        }
                        newsDetalHeaderAdapter = new NewsDetalHeaderAdapter(newsDetailInfo);
                        delegateAdapter.addAdapter(newsDetalHeaderAdapter);

                    }
                });

        ApiClient.getInstance()
                .getNewsComment(tempPupulId,newsId,1)
                .subscribe(new Consumer<NewsResultBeanInfo<NewsComment>>() {
                    @Override
                    public void accept(@NonNull NewsResultBeanInfo<NewsComment> newsResultBeanInfo) throws Exception {
                        NewsComment newsComment = newsResultBeanInfo.getData();
                        Log.d("NewsDetailActivity----newsComment=" + newsComment);
                        if (newsComment != null && newsComment.getList() != null) {
                            Log.d("NewsDetailActivity----size=" + newsComment.getList().size());
                        }
                    }
                });

    }

    /**
     * header
     */
    class NewsDetalHeaderAdapter extends DelegateAdapter.Adapter<NewsDetalHeaderAdapter.NewsDetailHeaderHolder> {

        private NewsDetailInfo info;
        public WebView webView;

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
            webView = holder.webView;
            holder.tvNewsTitle.setText(info.getTitle());
            holder.tvNewsAuthor.setText(info.getDesc());
            holder.tvNewsTime.setText(info.getDate());

            holder.webView.setBackgroundColor(Color.TRANSPARENT);
            holder.webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            holder.webView.getSettings().setJavaScriptEnabled(true); //设置支持Javascript
            holder.webView.requestFocus(); //触摸焦点起作用.如果不设置，则在点击网页文本输入框时，不能弹出软键盘及不响应其他的一些事件。
//      luntanListview.getSettings().setBuiltInZoomControls(true); //页面添加缩放按钮
//      luntanListview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);   //取消滚动条

            //点击链接由自己处理，而不是新开Android的系统browser响应该链接。
            holder.webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //设置点击网页里面的链接还是在当前的webview里跳转
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    int height = view.getHeight();//50dp 150
                    //原代码 延时1s
                    holder.webView.loadUrl("javascript:MyApp.resize(document.body.getBoundingClientRect().height)");
                }
            });

            holder.webView.setWebChromeClient(new WebChromeClient());
            holder.webView.addJavascriptInterface(this, "MyApp");

            Log.d("NewsDetailActivity--getContent=" + info.getContent());
            holder.webView.loadDataWithBaseURL(null, info.getContent(), "text/html", "utf-8",
                    null);
//            showWebView(activity, mContent);
        }

        @JavascriptInterface
        public void resize(final float height) {

            Log.d("NewsDetailActivity--resize--height=" + height);
            if (webView == null) {
                return;
            }
//            Log.d("NewsDetailActivity--resize--getContentHeight=" + webView.getContentHeight());

            runOnUiThread(
                    new Runnable() {

                        @Override
                        public void run() {
                            float currentHeight = Math.max(height, webView.getContentHeight());
                            webView.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels, (int) (currentHeight * getResources().getDisplayMetrics().density)));
                        }
                    }
            );

        }

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
            WebView webView;
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
        if (newsDetalHeaderAdapter != null) {
            WebView webView = newsDetalHeaderAdapter.webView;
            if (webView != null) {
                webView.clearHistory();
                webView.clearCache(true);
                webView.loadUrl("about:blank");
                webView.freeMemory();
//            webView.pauseTimers();
                webView = null;
            }
        }
    }
}
