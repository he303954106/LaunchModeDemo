package com.hk.launchmodedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hk.launchmodedemo.singleinstance.SingleInstanceX;
import com.hk.launchmodedemo.singletask.SingleTaskX;
import com.hk.launchmodedemo.singletop.SingleTopX;
import com.hk.launchmodedemo.standard.StandardX;

/**
 * Created by hk on 2019/1/24.
 */
public class XBaseActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvInfo;
    private Button mBtStandard;
    private Button mBtSingleTop;
    private Button mBtSingleTask;
    private Button mBtSingleInstance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_base);
        initView();
        int taskId = getTaskId();
        String name = getClass().getSimpleName();
        mTvInfo.setText("activity name: " + name + "\n taskId: " + taskId);
    }

    private void initView() {
        mTvInfo = (TextView) findViewById(R.id.tv_info);
        mBtStandard = (Button) findViewById(R.id.bt_standard);
        mBtSingleTop = (Button) findViewById(R.id.bt_single_top);
        mBtSingleTask = (Button) findViewById(R.id.bt_single_task);
        mBtSingleInstance = (Button) findViewById(R.id.bt_single_instance);

        mBtStandard.setOnClickListener(this);
        mBtSingleTop.setOnClickListener(this);
        mBtSingleTask.setOnClickListener(this);
        mBtSingleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.bt_standard:
                intent.setClass(XBaseActivity.this, StandardX.class);
                startActivity(intent);
                break;
            case R.id.bt_single_top:
                intent.setClass(XBaseActivity.this, SingleTopX.class);
                startActivity(intent);
                break;
            case R.id.bt_single_task:
                intent.setClass(XBaseActivity.this, SingleTaskX.class);
                startActivity(intent);
                break;
            case R.id.bt_single_instance:
                intent.setClass(XBaseActivity.this, SingleInstanceX.class);
                startActivity(intent);
                break;
        }
    }
}
