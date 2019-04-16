package com.example.volley20190416;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.volley20190416.adapter.ShowAdapter;
import com.example.volley20190416.bean.JsonBean;
import com.example.volley20190416.mvp.presenter.Presenter;
import com.example.volley20190416.mvp.view.IView;
import com.google.gson.Gson;

import static android.widget.LinearLayout.*;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView recy;
    private String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=%E7%94%B7%E9%9E%8B";
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy = findViewById(R.id.main_recy);
        presenter = new Presenter();
        presenter.ipadd(this);
        presenter.ipshow(MainActivity.this,url);
    }

    @Override
    public void viewshow(String jsd) {
        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(jsd, JsonBean.class);
        LinearLayoutManager linearLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recy.setLayoutManager(linearLayout);
        ShowAdapter showAdapter = new ShowAdapter(MainActivity.this, jsonBean);
        recy.setAdapter(showAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.ipshi(this);
    }
}
