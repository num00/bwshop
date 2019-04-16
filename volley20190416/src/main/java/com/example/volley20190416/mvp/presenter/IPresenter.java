package com.example.volley20190416.mvp.presenter;

import android.content.Context;

import com.example.volley20190416.mvp.view.IView;

public interface IPresenter {
    void ipshow(Context context,String url);

    void ipadd(IView iView);

    void ipshi(IView iView);
}
