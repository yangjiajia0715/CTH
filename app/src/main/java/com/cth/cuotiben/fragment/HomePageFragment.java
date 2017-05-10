package com.cth.cuotiben.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.cth.cuotiben.R;
import com.cth.cuotiben.api.ApiClient;
import com.cth.cuotiben.delegate.BannerAdapter;
import com.cth.cuotiben.delegate.HomePagePartHeaderAdapter;
import com.cth.cuotiben.delegate.NewsAdapter;
import com.cth.cuotiben.delegate.TopicOrAnswerAdapter;
import com.cth.cuotiben.news.NewsListInfo;
import com.cth.cuotiben.news.NewsResultBeanInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * 首页--主页
 * Created by yangjiajia on 2017/5/8 0008.
 */

public class HomePageFragment extends BaseFragment {
    private static final int NEWS_MAX_COUNT = 5;//学神攻略，兴趣部落 只显示5个

    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    Unbinder unbinder;
    DelegateAdapter delegateAdapter;

    public static HomePageFragment newInstance() {

        Bundle args = new Bundle();

        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mMainView = inflater.inflate(R.layout.fragment_home_page, null, false);
        unbinder = ButterKnife.bind(this, mMainView);
        initView();
        initData();
        return mMainView;
    }

    private void initView() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());
        recycleview.setLayoutManager(layoutManager);
        delegateAdapter = new DelegateAdapter(layoutManager);

        recycleview.setAdapter(delegateAdapter);

        delegateAdapter.addAdapter(new BannerAdapter());
        delegateAdapter.addAdapter(new TopicOrAnswerAdapter());

        delegateAdapter.notifyDataSetChanged();
    }

    private void initData() {
        //ok
//        ApiClient.getInstance()
//                .getBanner(10097, false)
//                .subscribe(new Consumer<ResultBeanInfo<BannerInfo>>() {
//                    @Override
//                    public void accept(@NonNull ResultBeanInfo<BannerInfo> resultBeanInfo) throws Exception {
//                        Log.d("resultBeanInfo--" + resultBeanInfo.getData());
//                    }
//                });

        //ok
        ApiClient.getInstance()
                .getNewsList(1, 1, 1)
                .subscribe(new Consumer<NewsResultBeanInfo<NewsListInfo>>() {
                    @Override
                    public void accept(@NonNull NewsResultBeanInfo<NewsListInfo> resultBeanInfo) throws Exception {
                        NewsListInfo data = resultBeanInfo.getData();

                        if (data != null && data.getList() != null) {
                            List<NewsListInfo.ListBean> list = data.getList();
                            if (!list.isEmpty()) {
                                List<NewsListInfo.ListBean> subList = list.subList(0, Math.min(list.size(), NEWS_MAX_COUNT));
                                delegateAdapter.addAdapter(new HomePagePartHeaderAdapter());
                                delegateAdapter.addAdapter(new NewsAdapter(subList));
                            }
//                            if (list != null) {
//                                for (int i = 0; i < list.size(); i++) {
//                                    NewsListInfo.ListBean listBean = list.get(i);
//                                    Log.d("=========news====listBean=" + listBean);
//                                }
//                            }
                        }


                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
