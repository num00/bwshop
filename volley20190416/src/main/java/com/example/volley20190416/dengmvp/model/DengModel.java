package com.example.volley20190416.dengmvp.model;

import com.android.volley.VolleyError;
import com.example.volley20190416.volley.VolleyOkHttp;

import java.util.HashMap;

public class DengModel implements DengIModel {

    private HashMap<String, String> objectHashMap;

    @Override
    public void modelshow(String asd, String phone, String pwd, final CallBack callBack) {
        objectHashMap = new HashMap<>();
        objectHashMap.put("phone", phone);
        objectHashMap.put("pwd", pwd);
        VolleyOkHttp.getInstance().PostOk(asd, objectHashMap, new VolleyOkHttp.CallBack() {
            @Override
            public void callcheng(String jsd) {
                callBack.calaad(jsd);

            }

            @Override
            public void callshi(VolleyError error) {

            }
        });
    }
}
