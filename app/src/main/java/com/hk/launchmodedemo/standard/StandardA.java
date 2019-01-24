package com.hk.launchmodedemo.standard;

import com.hk.launchmodedemo.BaseActivity;

/**
 * Created by hk on 2019/1/24.
 */
public class StandardA extends BaseActivity {
    @Override
    public Class<?> goToNextA() {
        return StandardA.class;
    }

    @Override
    public Class<?> goToNextB() {
        return StandardB.class;
    }

    @Override
    public Class<?> goToNextC() {
        return StandardC.class;
    }

    @Override
    public Class<?> goToNextD() {
        return StandardD.class;
    }
}
