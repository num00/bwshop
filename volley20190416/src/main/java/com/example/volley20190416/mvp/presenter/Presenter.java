package com.example.volley20190416.mvp.presenter;

import android.content.Context;

import com.android.volley.VolleyError;
import com.example.volley20190416.mvp.model.IModel;
import com.example.volley20190416.mvp.model.Model;
import com.example.volley20190416.mvp.view.IView;

import java.lang.ref.SoftReference;

public class Presenter implements IPresenter {
    IView iView;
    IModel iModel;
    SoftReference<IModel> softReference;

    @Override
    public void ipshow(Context context,String url) {
        iModel.modeshow(context, url, new IModel.CallBack() {
            @Override
            public void moche(String hgd) {
                iView.viewshow(hgd);
            }

            @Override
            public void moshi(VolleyError error) {

            }
        });
    }

    @Override
    public void ipadd(IView iView) {
        this.iView = iView;
        iModel = new Model();
        softReference = new SoftReference<>(iModel);
    }

    @Override
    public void ipshi(IView iView) {
        softReference.clear();
    }
}
