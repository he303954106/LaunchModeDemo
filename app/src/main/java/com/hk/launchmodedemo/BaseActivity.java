package com.hk.launchmodedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hk on 2019/1/24.
 */
public abstract class BaseActivity extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private TextView mTvInfo;
    private Button mBtStandard;
    private Button mBtSingleTask;
    private Button mBtSingleTop;
    private Button mBtClearTopAndSingleTask;
    private RadioButton mRbtA;
    private RadioButton mRbtB;
    private RadioButton mRbtC;
    private RadioButton mRbtD;
    private RadioGroup mRgNext;

    private Class<?> mNextClass = goToNextA();
    private RadioButton mRbtStartActivity;
    private RadioButton mRbtStartActivityForResult;
    private RadioGroup mRgStartActivity;

    public abstract Class<?> goToNextA();

    public abstract Class<?> goToNextB();

    public abstract Class<?> goToNextC();

    public abstract Class<?> goToNextD();

    public static final int REQUEST_CODE = 1;

    private boolean mIsStartActivity = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
        int taskId = getTaskId();
        String name = getClass().getSimpleName();
        mTvInfo.setText("activity name: " + name + "\n taskId: " + taskId);
    }

    public Context getContext() {
        return this;
    }

    private void initView() {
        mTvInfo = (TextView) findViewById(R.id.tv_info);
        mBtStandard = (Button) findViewById(R.id.bt_standard);
        mBtSingleTask = (Button) findViewById(R.id.bt_single_task);
        mBtSingleTop = (Button) findViewById(R.id.bt_single_top);
        mBtClearTopAndSingleTask = (Button) findViewById(R.id.bt_clear_top_and_single_task);

        mBtStandard.setOnClickListener(this);
        mBtSingleTask.setOnClickListener(this);
        mBtSingleTop.setOnClickListener(this);
        mBtClearTopAndSingleTask.setOnClickListener(this);
        mRbtA = (RadioButton) findViewById(R.id.rbt_a);
        mRbtB = (RadioButton) findViewById(R.id.rbt_b);
        mRbtC = (RadioButton) findViewById(R.id.rbt_c);
        mRbtD = (RadioButton) findViewById(R.id.rbt_d);
        mRgNext = (RadioGroup) findViewById(R.id.rg_next);
        mRgNext.setOnCheckedChangeListener(this);
        mRbtStartActivity = (RadioButton) findViewById(R.id.rbt_startActivity);
        mRbtStartActivityForResult = (RadioButton) findViewById(R.id.rbt_startActivityForResult);
        mRgStartActivity = (RadioGroup) findViewById(R.id.rg_startActivity);
        mRgStartActivity.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), mNextClass);
        switch (v.getId()) {
            case R.id.bt_standard:
                break;
            case R.id.bt_single_task:
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                break;
            case R.id.bt_single_top:
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                break;
            case R.id.bt_clear_top_and_single_task:
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                break;
        }
        if (mIsStartActivity) {
            startActivity(intent);
        } else {
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbt_a:
                mNextClass = goToNextA();
                break;
            case R.id.rbt_b:
                mNextClass = goToNextB();
                break;
            case R.id.rbt_c:
                mNextClass = goToNextC();
                break;
            case R.id.rbt_d:
                mNextClass = goToNextD();
                break;
            case R.id.rbt_startActivity:
                mIsStartActivity = true;
                break;
            case R.id.rbt_startActivityForResult:
                mIsStartActivity = false;
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("name", mNextClass.getSimpleName());
        setResult(Activity.RESULT_OK, intent);
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            if (requestCode == REQUEST_CODE) {
                String name = data.getStringExtra("name");
                Toast.makeText(getContext(), "onActivityResult: " + name, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(getContext(), "onNewIntent" + mNextClass.getSimpleName(), Toast.LENGTH_SHORT).show();
    }
}
