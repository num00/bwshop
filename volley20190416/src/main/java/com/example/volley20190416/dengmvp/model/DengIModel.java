package com.example.volley20190416.dengmvp.model;

public interface DengIModel {
    void modelshow(String asd, String phone, String pwd,CallBack callBack);

    interface CallBack {
        void calaad(String jis );

        void calhhs();
    }
}
