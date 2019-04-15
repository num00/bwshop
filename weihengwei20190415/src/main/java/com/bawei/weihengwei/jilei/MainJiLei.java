package com.bawei.weihengwei.jilei;

import android.app.Activity;
import android.os.Bundle;

public abstract class MainJiLei extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initlistenter();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initlistenter();


}
