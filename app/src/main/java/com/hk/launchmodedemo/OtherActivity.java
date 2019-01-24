package com.hk.launchmodedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hk.launchmodedemo.standard.StandardX;

/**
 * Created by hk on 2019/1/24.
 */
public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        startActivity(new Intent(this, StandardX.class));
        finish();
    }
}
