package com.example.duotiaomu.bean;

import java.util.ArrayList;

public class RxxpBean {
    private String id;
    private String name;
    private ArrayList<CommidBean> commodityList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CommidBean> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(ArrayList<CommidBean> commodityList) {
        this.commodityList = commodityList;
    }
}
