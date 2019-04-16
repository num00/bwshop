package com.example.volley20190416.mvp.model;

import android.content.Context;

import com.android.volley.VolleyError;

public interface IModel {
    void modeshow(Context context,String url, CallBack callBack);

    interface CallBack {
        void moche(String hgd);

        void moshi(VolleyError error);
    }
}
