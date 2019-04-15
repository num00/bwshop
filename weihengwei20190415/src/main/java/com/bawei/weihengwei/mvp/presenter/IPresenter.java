package com.bawei.weihengwei.mvp.presenter;

import com.bawei.weihengwei.mvp.view.IView;

public interface IPresenter {
    void showpres(String url, String phone, String pwd);

    void ipbang(IView iView);

    void ipjie(IView iView);
}
