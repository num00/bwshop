package com.example.duotiaomu.movelly;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MappVolley extends Application {
    private static RequestQueue queue;


    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());

    }

    public static RequestQueue VolleyMapp() {
        return queue;
    }
}
