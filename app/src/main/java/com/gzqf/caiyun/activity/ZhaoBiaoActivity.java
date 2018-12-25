package com.gzqf.caiyun.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.gzqf.caiyun.R;
import com.gzqf.caiyun.base.BaseActivity;

/**
 * 招标任务
 */
public class ZhaoBiaoActivity extends BaseActivity {
    ListView zhaoBiaoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhao_biao);
        initview();
    }

    @Override
    public void findviewWithId() {
        zhaoBiaoListView=findViewById(R.id.zhaoBiaoListView);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {

    }
}
