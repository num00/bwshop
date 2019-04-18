package com.example.duotiaomu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.duotiaomu.adapter.MlssAdapter;
import com.example.duotiaomu.adapter.PzshAdapter;
import com.example.duotiaomu.adapter.RxxpAdapter;
import com.example.duotiaomu.bannerbean.JsonbannerBean;
import com.example.duotiaomu.bean.CommidBean;
import com.example.duotiaomu.bean.ResultBean;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter {
    Context context;
    ResultBean resultBean;
    JsonbannerBean jsonbannerBean;
    private int bannertype = 0;
    private int Mlsstype = 1;
    private int PzshType = 2;
    private int RxxpType = 3;

    public HomeAdapter(Context context, ResultBean resultBean, JsonbannerBean jsonbannerBean) {
        this.context = context;
        this.resultBean = resultBean;
        this.jsonbannerBean = jsonbannerBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == bannertype) {
            View view = LayoutInflater.from(context).inflate(R.layout.banner_layout, viewGroup, false);
            return new BannerHolder(view);
        } else if (i == Mlsstype) {
            View view = LayoutInflater.from(context).inflate(R.layout.mlss_layout, viewGroup, false);
            return new MlssViewHolder(view);
        } else if (i == PzshType) {

            View view = LayoutInflater.from(context).inflate(R.layout.pzsh_layout, viewGroup, false);
            return new PzshHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.rxxp_layout, viewGroup, false);
            return new RxxpHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (i == bannertype) {
            BannerHolder bannerHolder = (BannerHolder) viewHolder;
            bannerHolder.banner.setData(jsonbannerBean.getResult(),null);
            bannerHolder.banner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, View view, int position) {
                    Glide.with(context).load(jsonbannerBean.getResult().get(position).getImageUrl()).into((ImageView) view);
                }
            });
        } else if (i == Mlsstype) {
            MlssViewHolder mlssViewHolder = (MlssViewHolder) viewHolder;
            mlssViewHolder.text.setText(resultBean.getMlss().getName());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            mlssViewHolder.recy.setLayoutManager(linearLayoutManager);
            ArrayList<CommidBean> commodityList = resultBean.getMlss().getCommodityList();
            MlssAdapter mlssAdapter = new MlssAdapter(context, commodityList);
            mlssViewHolder.recy.setAdapter(mlssAdapter);

        } else if (i == PzshType) {
            PzshHolder pzshHolder = (PzshHolder) viewHolder;
            pzshHolder.text.setText(resultBean.getPzsh().getName());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            pzshHolder.recy.setLayoutManager(linearLayoutManager);
            ArrayList<CommidBean> commodityList = resultBean.getPzsh().getCommodityList();
            PzshAdapter pzshAdapter = new PzshAdapter(context, commodityList);
            pzshHolder.recy.setAdapter(pzshAdapter);

        } else {
            RxxpHolder rxxpHolder = (RxxpHolder) viewHolder;
            rxxpHolder.text.setText(resultBean.getRxxp().getName());
            GridLayoutManager linearLayoutManager = new GridLayoutManager(context, 2);
            rxxpHolder.recy.setLayoutManager(linearLayoutManager);
            ArrayList<CommidBean> commodityList = resultBean.getRxxp().getCommodityList();
            RxxpAdapter rxxpAdapter = new RxxpAdapter(context, commodityList);
            rxxpHolder.recy.setAdapter(rxxpAdapter);
        }
    }


    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return bannertype;
        } else if (position == 1) {
            return Mlsstype;
        } else if (position == 2) {
            return PzshType;
        } else {
            return RxxpType;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    private class BannerHolder extends ViewHolder {


        private final XBanner banner;

        public BannerHolder(View view) {
            super(view);
            banner = view.findViewById(R.id.banner_banner);


        }
    }

    private class MlssViewHolder extends ViewHolder {

        private final TextView text;
        private final RecyclerView recy;

        public MlssViewHolder(View view) {
            super(view);
            recy = view.findViewById(R.id.mlss_recy);
            text = view.findViewById(R.id.mlss_text);

        }
    }

    private class PzshHolder extends ViewHolder {
        private final TextView text;
        private final RecyclerView recy;

        public PzshHolder(View view) {
            super(view);
            recy = view.findViewById(R.id.pzsh_recy);
            text = view.findViewById(R.id.pzsh_text);
        }
    }

    private class RxxpHolder extends ViewHolder {
        private final TextView text;
        private final RecyclerView recy;

        public RxxpHolder(View view) {
            super(view);
            recy = view.findViewById(R.id.rxxp_recy);
            text = view.findViewById(R.id.rxxp_text);
        }
    }
}
