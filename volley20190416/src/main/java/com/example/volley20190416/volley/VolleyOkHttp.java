package com.example.volley20190416.volley;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class VolleyOkHttp {
    private static VolleyOkHttp volleyOkHttp  = new VolleyOkHttp();

    public static VolleyOkHttp getInstance() {
        if (volleyOkHttp == null) {

            synchronized (VolleyOkHttp.class) {
                if (volleyOkHttp == null) {
                    volleyOkHttp = new VolleyOkHttp();
                }
            }
        }
        return volleyOkHttp;
    }

    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    public void GetOkhttp(String url, final CallBack callBack) {
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
        stringRequest.setTag("TextGet");
        MappVolley.requestQueue().add(stringRequest);
    }

    public void PostOk(String url, final HashMap<String, String> map, final CallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.callcheng(response);
                Log.d("zzz", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.callshi(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        stringRequest.setTag("TextPost");
        MappVolley.requestQueue().add(stringRequest);

    }

    public interface CallBack {
        void callcheng(String jsd);

        void callshi(VolleyError error);
    }

}
