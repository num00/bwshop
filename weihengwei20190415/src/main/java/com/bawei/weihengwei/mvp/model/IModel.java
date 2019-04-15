package com.bawei.weihengwei.mvp.model;

public interface IModel {
    void imshow(String url, String phone, String pwd, CallBask callBask);

    interface CallBask {
        void mocheng(String jos);

        void moshi();
    }
}
