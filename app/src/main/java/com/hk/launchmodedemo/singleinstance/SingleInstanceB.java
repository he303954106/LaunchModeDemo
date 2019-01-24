package com.hk.launchmodedemo.singleinstance;

import com.hk.launchmodedemo.BaseActivity;

/**
 * Created by hk on 2019/1/24.
 */
public class SingleInstanceB extends BaseActivity {
    @Override
    public Class<?> goToNextA() {
        return SingleInstanceA.class;
    }

    @Override
    public Class<?> goToNextB() {
        return SingleInstanceB.class;
    }

    @Override
    public Class<?> goToNextC() {
        return SingleInstanceC.class;
    }

    @Override
    public Class<?> goToNextD() {
        return SingleInstanceD.class;
    }
}
