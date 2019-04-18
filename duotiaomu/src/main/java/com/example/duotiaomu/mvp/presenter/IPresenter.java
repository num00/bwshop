package com.example.duotiaomu.mvp.presenter;

import com.example.duotiaomu.mvp.view.IView;

public interface IPresenter {
    void ipcheng(String url);

    void ipbanner(String jdf);

    void ipbang(IView iView);

    void ipshi(IView iView);
}
