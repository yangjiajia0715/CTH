package com.cth.cuotiben.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cth.cuotiben.R;
import com.cth.cuotiben.fragment.AnswerFragment;
import com.cth.cuotiben.fragment.ChatFragment;
import com.cth.cuotiben.fragment.HomePageFragment;
import com.cth.cuotiben.fragment.UserInfoFragment;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxRadioGroup;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.bottom_navi_home_page)
    RadioButton bottomNaviHomePage;
    @BindView(R.id.bottom_navi_answer)
    RadioButton bottomNaviAnswer;
    @BindView(R.id.bottom_navi_create_wrong_topic)
    RadioButton bottomNaviCreateWrongTopic;
    @BindView(R.id.bottom_navi_chat)
    RadioButton bottomNaviChat;
    @BindView(R.id.bottom_navi_my)
    RadioButton bottomNaviMy;
    @BindView(R.id.bottom_navi_layout)
    RadioGroup bottomNaviLayout;
    @BindView(R.id.title)
    TextView title;
    private InitialValueObservable<Integer> bottomNaviObservable;
    private MenuItem menuSearch;
    private MenuItem menuAddFriend;
    private Fragment mHomePageFragment;
    private Fragment mAnswerFragmnt;
    private Fragment mChatFragment;
    private Fragment mUserInfoFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolBar() {
    }

    @Override
    protected void initView() {
        bottomNaviObservable = RxRadioGroup.checkedChanges(bottomNaviLayout);
        bottomNaviObservable.throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer checkedId) throws Exception {
                        initSubview(checkedId);
                    }
                });

    }

    @Override
    protected void initData() {
//        ApiClient.getInstance()
//                .getVerificationCode(this, "13552590716", "cth")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(@NonNull Disposable disposable) throws Exception {
//
//                    }
//                })
//                .subscribe(new Observer<ResultBeanInfo<VerificationCodeInfo>>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull ResultBeanInfo<VerificationCodeInfo> verificationCodeInfoResultBeanInfo) {
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    private void initSubview(Integer checkedId) {
        mToolBar.setNavigationIcon(null);
        if (menuSearch != null) {
            menuSearch.setVisible(false);
            menuAddFriend.setVisible(false);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);

        switch (checkedId) {
            case R.id.bottom_navi_home_page:
                title.setText(R.string.bottom_navi_home_page);
                mToolBar.setNavigationIcon(R.drawable.top_bar_scan);
                if (menuSearch != null) {
                    menuSearch.setVisible(true);
                }
                if (mHomePageFragment == null) {
                    mHomePageFragment = HomePageFragment.newInstance();
                    transaction.add(R.id.content, mHomePageFragment);
                } else {
                    transaction.show(mHomePageFragment);
                }
                break;
            case R.id.bottom_navi_answer:
                title.setText(R.string.bottom_navi_answer);
                if (mAnswerFragmnt == null) {
                    mAnswerFragmnt = AnswerFragment.newInstance();
                    transaction.add(R.id.content, mAnswerFragmnt);
                } else {
                    transaction.show(mAnswerFragmnt);
                }
                break;
            case R.id.bottom_navi_create_wrong_topic:
                break;
            case R.id.bottom_navi_chat:
                title.setText(R.string.bottom_navi_chat);
                mToolBar.setNavigationIcon(R.drawable.message_contacts);
                if (menuAddFriend != null) {
                    menuAddFriend.setVisible(true);
                }
                if (mChatFragment == null) {
                    mChatFragment = ChatFragment.newInstance();
                    transaction.add(R.id.content, mChatFragment);
                } else {
                    transaction.show(mChatFragment);
                }
                break;
            case R.id.bottom_navi_my:
                title.setText(R.string.bottom_navi_my);
                if (mUserInfoFragment == null) {
                    mUserInfoFragment = UserInfoFragment.newInstance();
                    transaction.add(R.id.content, mUserInfoFragment);
                } else {
                    transaction.show(mUserInfoFragment);
                }
                break;
        }

        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mHomePageFragment != null) {
            transaction.hide(mHomePageFragment);
        }

        if (mAnswerFragmnt != null) {
            transaction.hide(mAnswerFragmnt);
        }

        if (mChatFragment != null) {
            transaction.hide(mChatFragment);
        }

        if (mUserInfoFragment != null) {
            transaction.hide(mUserInfoFragment);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menuSearch = menu.findItem(R.id.action_search);
        menuAddFriend = menu.findItem(R.id.action_add_friend);

        menuSearch.setVisible(true);
        if (menu instanceof MenuBuilder) {//true
            MenuBuilder menuBuilder = (MenuBuilder) menu;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                int radioButtonId = bottomNaviLayout.getCheckedRadioButtonId();
                if (radioButtonId == R.id.bottom_navi_home_page) {
                    toastMessage("扫描");
                } else if (radioButtonId == R.id.bottom_navi_chat) {
                    toastMessage("联系人");
                }
                return true;
            case R.id.action_search:
                toastMessage("搜索");
                return true;
            case R.id.action_add_friend:
                toastMessage("添加好友");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bottomNaviObservable != null)
            bottomNaviObservable.unsubscribeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case android.R.id.home:

                break;

        }
    }
}
