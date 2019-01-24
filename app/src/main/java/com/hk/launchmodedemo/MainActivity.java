package com.hk.launchmodedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hk.launchmodedemo.singleinstance.SingleInstanceA;
import com.hk.launchmodedemo.singletask.SingleTaskA;
import com.hk.launchmodedemo.singletop.SingleTopA;
import com.hk.launchmodedemo.standard.StandardA;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtStandard;
    private Button mBtSingleTop;
    private Button mBtSingleTask;
    private Button mBtSingleInstance;
    private Button mBtOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtStandard = (Button) findViewById(R.id.bt_standard);
        mBtSingleTop = (Button) findViewById(R.id.bt_single_top);
        mBtSingleTask = (Button) findViewById(R.id.bt_single_task);
        mBtSingleInstance = (Button) findViewById(R.id.bt_single_instance);

        mBtStandard.setOnClickListener(this);
        mBtSingleTop.setOnClickListener(this);
        mBtSingleTask.setOnClickListener(this);
        mBtSingleInstance.setOnClickListener(this);
        mBtOther = (Button) findViewById(R.id.bt_other);
        mBtOther.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.bt_standard:
                intent.setClass(MainActivity.this, StandardA.class);
                break;
            case R.id.bt_single_top:
                intent.setClass(MainActivity.this, SingleTopA.class);
                break;
            case R.id.bt_single_task:
                intent.setClass(MainActivity.this, SingleTaskA.class);
                break;
            case R.id.bt_single_instance:
                intent.setClass(MainActivity.this, SingleInstanceA.class);
                break;
            case R.id.bt_other:
                intent.setClass(MainActivity.this, OtherActivity.class);
                break;
        }
        startActivity(intent);
    }
}
