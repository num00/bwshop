package com.bawei.weihengwei;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.weihengwei.bean.DengBean;
import com.bawei.weihengwei.jilei.MainJiLei;
import com.bawei.weihengwei.mvp.presenter.Presenter;
import com.bawei.weihengwei.mvp.view.IView;
import com.bawei.weihengwei.okhttputils.ZhuCeActivity;
import com.google.gson.Gson;

public class MainActivity extends MainJiLei implements IView {

    private EditText mi;
    private EditText yong;
    private Button zhu;
    private Button deng;
    private Presenter presenter;
    private String url = "http://172.17.8.100/small/user/v1/login";
    private String cyong;
    private String cmima;
    private SharedPreferences.Editor edit;
    private SharedPreferences preferences;
    private String yo;
    private String ma;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        presenter = new Presenter();
        presenter.ipbang(this);
        Intent intent = getIntent();
        cyong = intent.getStringExtra("yong");
        cmima = intent.getStringExtra("mima");
        Log.d("yong", cyong + "" + cmima);
        preferences = getSharedPreferences("shard", 0);
        edit = preferences.edit();

    }

    @Override
    protected void initData() {
        deng = findViewById(R.id.main_deng);
        zhu = findViewById(R.id.main_zhu);
        yong = findViewById(R.id.main_yong);
        mi = findViewById(R.id.main_mi);
        yong.setText(cyong);
        mi.setText(cmima);

    }

    @Override
    protected void initlistenter() {
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yo = yong.getText().toString();
                ma = mi.getText().toString();
                if (!yo.isEmpty() && !ma.isEmpty()) {
                    presenter.showpres(url, yo, ma);
                } else {

                    Toast.makeText(MainActivity.this, "账号或密码为空", Toast.LENGTH_LONG).show();
                }


            }
        });
        zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ZhuCeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void showview(String ss) {
        Gson gson = new Gson();
        DengBean bean = gson.fromJson(ss, DengBean.class);
        if (bean.getStatus().equals("0000")) {
            edit.putString("yo", yo);
            edit.putString("ma", ma);
            edit.commit();
            Intent intent = new Intent(MainActivity.this, Show_layout.class);
            startActivity(intent);
            finish();

        } else {
            String message = bean.getMessage();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.ipjie(this);
    }
}
