package com.example.duotiaomu.bannerbean;

import java.util.ArrayList;

public class JsonbannerBean {
    private String message;
    private String status;
    private ArrayList<ReturnBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ReturnBean> getResult() {
        return result;
    }

    public void setResult(ArrayList<ReturnBean> result) {
        this.result = result;
    }
}
