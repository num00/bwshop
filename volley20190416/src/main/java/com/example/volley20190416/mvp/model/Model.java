package com.example.volley20190416.mvp.model;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.volley20190416.volley.VolleyOkHttp;

public class Model implements IModel {
    private Handler handler = new Handler();

    @Override
    public void modeshow(final Context context, String url, final CallBack callBack) {
        boolean networkConnected = VolleyOkHttp.getInstance().isNetworkConnected(context);
        if (networkConnected) {
            VolleyOkHttp.getInstance().GetOkhttp(url, new VolleyOkHttp.CallBack() {
                @Override
                public void callcheng(String jsd) {
                    callBack.moche(jsd);
                }

                @Override
                public void callshi(VolleyError error) {
                    callBack.moshi(error);
                }
            });
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context,"网络链接失败", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }).start();
        }

    }
}
