package com.bawei.weihengwei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.weihengwei.bean.DengBean;
import com.bumptech.glide.Glide;

public class Show_layout extends AppCompatActivity {

    private ImageView image;
    private DengBean dengBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_layout);
        image = findViewById(R.id.show_image);
//        Glide.with(this).load(dengBean.getResult().getHeadPic()).into(image);
    }
}
