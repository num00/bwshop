package com.example.volley20190416.bean;

import java.util.ArrayList;

public class JsonBean {
    private ArrayList<ResultBean> result;
    private String message;
    private String status;

    public ArrayList<ResultBean> getResult() {
        return result;
    }

    public void setResult(ArrayList<ResultBean> result) {
        this.result = result;
    }

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
}
