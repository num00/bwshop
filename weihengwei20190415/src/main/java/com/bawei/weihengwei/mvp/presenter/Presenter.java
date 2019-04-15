package com.bawei.weihengwei.mvp.presenter;

import com.bawei.weihengwei.mvp.model.IModel;
import com.bawei.weihengwei.mvp.model.Model;
import com.bawei.weihengwei.mvp.view.IView;

import java.lang.ref.SoftReference;

public class Presenter implements IPresenter {
    IModel iModel;
    IView iView;
    SoftReference<IModel> softReference;


    @Override
    public void showpres(String url, String phone, String pwd) {
        iModel.imshow(url, phone, pwd, new IModel.CallBask() {
            @Override
            public void mocheng(String jos) {
                iView.showview(jos);
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
    public void ipjie(IView iView) {
        softReference.clear();
    }
}
