package com.cth.cuotiben.activity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cth.cuotiben.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {
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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        List<String> strings = new ArrayList<>();
        strings.add("hhh");
        strings.add("hhh2");
        strings.add("hhh3");

        String[] strs = new String[strings.size()];
        strings.toArray(strs);

        Observable.fromIterable(strings)
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Log.d(TAG, "doOnNext---accept: " + s);
                        if ("hhh".equals(s)) {
                            s = "hhh1";
                        }
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Log.d(TAG, "accept: sssssssss=" + s);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Toast.makeText(this, "HHHHH", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void initData() {
    }

}
