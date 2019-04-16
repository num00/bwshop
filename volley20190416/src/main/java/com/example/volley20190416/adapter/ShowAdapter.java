package com.example.volley20190416.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.volley20190416.R;
import com.example.volley20190416.bean.JsonBean;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    Context context;
    JsonBean jsonBean;

    public ShowAdapter(Context context, JsonBean jsonBean) {
        this.context = context;
        this.jsonBean = jsonBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(jsonBean.getResult().get(i).getMasterPic()).into(viewHolder.imag);
        viewHolder.text.setText(jsonBean.getResult().get(i).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return jsonBean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imag;
        private final TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imag = itemView.findViewById(R.id.show_image);
            text = itemView.findViewById(R.id.show_text);
        }
    }
}
