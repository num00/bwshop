package com.example.duotiaomu.mvp.presenter;

import com.example.duotiaomu.mvp.model.IModel;
import com.example.duotiaomu.mvp.model.Model;
import com.example.duotiaomu.mvp.view.IView;

import java.lang.ref.SoftReference;

public class Presenter implements IPresenter {
    IView iView;
    IModel iModel;
    SoftReference<IModel> softReference;

    @Override
    public void ipcheng(String url) {
        iModel.modshow(url, new IModel.CallBack() {
            @Override
            public void mocheng(String ksf) {
                iView.viewshow(ksf);
            }

            @Override
            public void moshi() {

            }
        });
    }

    @Override
    public void ipbanner(String jdf) {
        iModel.modbanner(jdf, new IModel.CallBack() {
            @Override
            public void mocheng(String ksf) {
                iView.viewbanner(ksf);
            }

            @Override
            public void moshi() {

            }
        });
    }

    @Override
    public void ipbang(IView iView) {
        this.iView = iView;
        iModel = new Model();
        softReference = new SoftReference<>(iModel);
    }

    @Override
    public void ipshi(IView iView) {

    }
}
