package com.example.duotiaomu.mvp.model;

import com.android.volley.VolleyError;
import com.example.duotiaomu.movelly.MovellyOkHttp;

public class Model implements IModel {
    @Override
    public void modshow(String url, final CallBack callBack) {
        MovellyOkHttp.getInstance().GetMovelly(url, new MovellyOkHttp.CallBack() {
            @Override
            public void callcheng(String che) {
                callBack.mocheng(che);
            }

            @Override
            public void callshi(VolleyError error) {

            }
        });
    }

    @Override
    public void modbanner(String jis, final CallBack callBack) {
        MovellyOkHttp.getInstance().GetMovelly(jis, new MovellyOkHttp.CallBack() {
            @Override
            public void callcheng(String che) {
                callBack.mocheng(che);
            }

            @Override
            public void callshi(VolleyError error) {

            }
        });
    }
}
