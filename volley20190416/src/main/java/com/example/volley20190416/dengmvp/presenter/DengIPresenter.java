package com.example.volley20190416.dengmvp.presenter;

import com.example.volley20190416.dengmvp.view.DengIView;
import com.example.volley20190416.mvp.view.IView;

public interface DengIPresenter {
    void ipshow(String url, String phone, String pwd);

    void ipbang(DengIView iView);

    void ipshi(DengIView iView);
}
