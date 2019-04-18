package com.example.duotiaomu.movelly;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import javax.security.auth.callback.Callback;

public class MovellyOkHttp {

    private static MovellyOkHttp movellyOkHttp;

    public static MovellyOkHttp getInstance() {
        if (movellyOkHttp == null) {
            synchronized (MovellyOkHttp.class) {
                if (movellyOkHttp == null) {
                    movellyOkHttp = new MovellyOkHttp();
                }
            }
        }
        return movellyOkHttp;
    }

    public void GetMovelly(String url, final CallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.callcheng(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.callshi(error);
            }
        });
        stringRequest.setTag("GtetOk");
        MappVolley.VolleyMapp().add(stringRequest);


    }

    public interface CallBack {
        void callcheng(String che);

        void callshi(VolleyError error);
    }
}
