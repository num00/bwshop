package com.bawei.weihengwei.mvp;

import com.bawei.weihengwei.mvp.model.IModel;
import com.bawei.weihengwei.mvp.view.IView;

public interface Qiclass {
    //view接口
    public interface IView {
        void showview(String ss);
    }

    //presenter接口
    public interface IPresenter {
        void showpres(String url, String phone, String pwd);

        void ipbang(com.bawei.weihengwei.mvp.view.IView iView);

        void ipjie(com.bawei.weihengwei.mvp.view.IView iView);
    }

    //model接口
    public interface IModel {
        void imshow(String url, String phone, String pwd, com.bawei.weihengwei.mvp.model.IModel.CallBask callBask);

        interface CallBask {
            void mocheng(String jos);

            void moshi();
        }
    }
}
