package com.example.volley20190416.dengmvp.presenter;

import com.example.volley20190416.dengmvp.model.DengIModel;
import com.example.volley20190416.dengmvp.model.DengModel;
import com.example.volley20190416.dengmvp.view.DengIView;
import com.example.volley20190416.mvp.view.IView;

import java.lang.ref.SoftReference;

public class DengPresenter implements DengIPresenter {
    DengIModel iModel;
    DengIView iView;
    SoftReference<DengIModel> softReference;

    @Override
    public void ipshow(String url, String phone, String pwd) {
        iModel.modelshow(url, phone, pwd, new DengIModel.CallBack() {
            @Override
            public void calaad(String jis) {
                iView.viewshow(jis);
            }

            @Override
            public void calhhs() {

            }
        });

    }

    @Override
    public void ipbang(DengIView iView) {
        this.iView = iView;
        iModel = new DengModel();
        softReference = new SoftReference<>(iModel);
    }

    @Override
    public void ipshi(DengIView iView) {

    }
}
