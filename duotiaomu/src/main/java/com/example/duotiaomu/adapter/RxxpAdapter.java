package com.example.duotiaomu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.duotiaomu.R;
import com.example.duotiaomu.bean.CommidBean;

import java.util.ArrayList;

public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {
    Context context;
    ArrayList<CommidBean> commodityList;

    public RxxpAdapter(Context context, ArrayList<CommidBean> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rlsshow, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.text.setText(commodityList.get(i).getCommodityName());
        Glide.with(context).load(commodityList.get(i).getMasterPic()).into(viewHolder.image);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnclick.getonclick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.rshow_image);
            text = itemView.findViewById(R.id.rshow_text);
        }
    }
    MlssAdapter.SetOnclick setOnclick;

    public void getlicker(MlssAdapter.SetOnclick setOnclick) {
        this.setOnclick = setOnclick;
    }

    public interface SetOnclick {
        void getonclick();
    }
}
