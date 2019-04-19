package com.example.duotiaomu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.duotiaomu.bannerbean.JsonbannerBean;
import com.example.duotiaomu.bean.JsonBean;
import com.example.duotiaomu.bean.ResultBean;
import com.example.duotiaomu.mvp.presenter.Presenter;
import com.example.duotiaomu.mvp.view.IView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView recy;
    private String url = "http://172.17.8.100/small/commodity/v1/commodityList";
    private String bann = "http://172.17.8.100/small/commodity/v1/bannerShow";
    private JsonbannerBean jsonsBean;
    private ResultBean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy = findViewById(R.id.main_recy);
        Presenter presenter = new Presenter();
        presenter.ipbang(this);
        presenter.ipcheng(url);
        presenter.ipbanner(bann);


    }

    @Override
    public void viewshow(String kjs) {
        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(kjs, JsonBean.class);
        result = jsonBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recy.setLayoutManager(linearLayoutManager);
        HomeAdapter homeAdapter = new HomeAdapter(MainActivity.this, result, jsonsBean);
        recy.setAdapter(homeAdapter);
    }

    @Override
    public void viewbanner(String sdf) {
        Log.d("sss", sdf);
        Gson gson = new Gson();
        jsonsBean = gson.fromJson(sdf, JsonbannerBean.class);
        HomeAdapter homeAdapter = new HomeAdapter(MainActivity.this, result, jsonsBean);
        recy.setAdapter(homeAdapter);


    }
}
