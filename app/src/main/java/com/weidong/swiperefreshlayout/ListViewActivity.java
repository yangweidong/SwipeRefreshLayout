package com.weidong.swiperefreshlayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by weidong on 2015/3/4.
 */
public class ListViewActivity extends Activity {


    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> data;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        init();
    }
    private void init() {
        listView = (ListView) findViewById(R.id.listView);
        data = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            data.add("测试测试：" + i);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        //findview
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        //圈圈颜色
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        //下拉刷新监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        data.add(0, "添加新的item" + new Random().nextInt());
                        adapter.notifyDataSetChanged();
                        //停止刷新动画
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });

    }
}
