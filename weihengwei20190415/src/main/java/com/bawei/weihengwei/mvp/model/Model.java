package com.bawei.weihengwei.mvp.model;

import com.bawei.weihengwei.okhttputils.HttpUrlConnection;

public class Model implements IModel {
    @Override
    public void imshow(String url, String phone, String pwd, final CallBask callBask) {
        HttpUrlConnection.getInstance().GetPost(url, phone, pwd, new HttpUrlConnection.CallBack() {
            @Override
            public void callcheng(String che) {
                callBask.mocheng(che);
            }

            @Override
            public void callshi() {

            }
        });
    }
}
