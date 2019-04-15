package com.bawei.weihengwei.okhttputils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.weihengwei.MainActivity;
import com.bawei.weihengwei.R;
import com.bawei.weihengwei.Show_layout;
import com.bawei.weihengwei.bean.ZhuBean;
import com.bawei.weihengwei.jilei.MainJiLei;
import com.bawei.weihengwei.mvp.presenter.Presenter;
import com.bawei.weihengwei.mvp.view.IView;
import com.google.gson.Gson;

public class ZhuCeActivity extends MainJiLei implements IView {


    private EditText maa;
    private Button zhu;
    private Button deng;
    private EditText yoa;
    private String ma;
    private String yo;

    private Presenter presenter;
    private String url = "http://172.17.8.100/small/user/v1/register";

    @Override
    protected void initView() {
        setContentView(R.layout.activity_zhu_ce);
        presenter = new Presenter();
        presenter.ipbang(this);
    }

    @Override
    protected void initData() {
        deng = findViewById(R.id.zhu_deng);
        zhu = findViewById(R.id.zhu_zhu);
        maa = findViewById(R.id.zhu_mi);
        yoa = findViewById(R.id.zhu_yong);

    }

    @Override
    protected void initlistenter() {
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZhuCeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        zhu.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                yo = yoa.getText().toString();
                ma = maa.getText().toString();
                if (!yo.isEmpty() && !ma.isEmpty()) {
                    presenter.showpres(url, yo, ma);
                } else {

                    Toast.makeText(ZhuCeActivity.this, "账号或密码为空", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void showview(String ss) {
        Gson gson = new Gson();
        ZhuBean zhuBean = gson.fromJson(ss, ZhuBean.class);

        if (zhuBean.getStatus().equals("0000")) {
            Intent intent = new Intent();
            intent.putExtra("yong", yo);
            intent.putExtra("mima", ma);
            intent.setClass(ZhuCeActivity.this, MainActivity.class);
            ZhuCeActivity.this.startActivity(intent);

            finish();

        } else {
            String message = zhuBean.getMessage();
            Toast.makeText(ZhuCeActivity.this, message, Toast.LENGTH_LONG).show();
        }
    }
}
