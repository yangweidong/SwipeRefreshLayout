package com.weidong.swiperefreshlayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * Created by weidong on 2015/3/4.
 */
public class ScrollViewActivity extends Activity {
    private SwipeRefreshLayout		swipeRefreshLayout;
    private ArrayAdapter<String> adapter;
    private LinearLayout					linearlayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.scrollview_activity);
        init();
    }

    private void init() {
        linearlayout = (LinearLayout) findViewById(R.id.linearlayout);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Button child = new Button(ScrollViewActivity.this);
                        child.setText("测试测试："+ new Random().nextInt());
                        linearlayout.addView(child,0);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });

    }
}
