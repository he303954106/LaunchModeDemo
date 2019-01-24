package com.hk.launchmodedemo.singletop;

import com.hk.launchmodedemo.BaseActivity;

/**
 * Created by hk on 2019/1/24.
 */
public class SingleTopD extends BaseActivity {
    @Override
    public Class<?> goToNextA() {
        return SingleTopA.class;
    }

    @Override
    public Class<?> goToNextB() {
        return SingleTopB.class;
    }

    @Override
    public Class<?> goToNextC() {
        return SingleTopC.class;
    }

    @Override
    public Class<?> goToNextD() {
        return SingleTopD.class;
    }
}
