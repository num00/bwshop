package com.example.volley20190416;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.volley20190416.bean.DengBean;
import com.example.volley20190416.dengmvp.presenter.DengPresenter;
import com.example.volley20190416.dengmvp.view.DengIView;
import com.google.gson.Gson;

public class DengActivity extends AppCompatActivity implements DengIView {

    private Button deng;
    private EditText mima;
    private String url = "http://172.17.8.100/small/user/v1/login";
    private EditText zhang;
    private DengPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng);
        deng = findViewById(R.id.deng_deng);
        mima = findViewById(R.id.deng_mima);
        zhang = findViewById(R.id.deng_zhang);
        presenter = new DengPresenter();
        presenter.ipbang(this);
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mi = mima.getText().toString();
                String hao = zhang.getText().toString();
                presenter.ipshow(url, hao, mi);
            }
        });
    }

    @Override
    public void viewshow(String jsd) {
        Gson gson = new Gson();
        DengBean dengBean = gson.fromJson(jsd, DengBean.class);
        String message = dengBean.getMessage();
        Toast.makeText(DengActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
