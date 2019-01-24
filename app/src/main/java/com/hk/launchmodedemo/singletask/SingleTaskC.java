package com.hk.launchmodedemo.singletask;

import com.hk.launchmodedemo.BaseActivity;

/**
 * Created by hk on 2019/1/24.
 */
public class SingleTaskC extends BaseActivity {
    @Override
    public Class<?> goToNextA() {
        return SingleTaskA.class;
    }

    @Override
    public Class<?> goToNextB() {
        return SingleTaskB.class;
    }

    @Override
    public Class<?> goToNextC() {
        return SingleTaskC.class;
    }

    @Override
    public Class<?> goToNextD() {
        return SingleTaskD.class;
    }
}
