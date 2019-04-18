package com.example.duotiaomu.mvp.model;

public interface IModel {
    void modshow(String url, CallBack callBack);
    void modbanner(String jis,CallBack callBack);

    interface CallBack {
        void mocheng(String ksf);

        void moshi();
    }
}
