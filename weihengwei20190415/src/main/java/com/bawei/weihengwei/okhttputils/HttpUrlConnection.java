package com.bawei.weihengwei.okhttputils;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.google.common.io.ByteStreams;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUrlConnection {
    private static HttpUrlConnection connection = new HttpUrlConnection();

    public static HttpUrlConnection getInstance() {
        return connection;
    }

    public void GetPost(String url, String phone, String pwd, final CallBack callBack) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                return Postok(strings[0], strings[1], strings[2]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (!TextUtils.isEmpty(s)) {
                    callBack.callcheng(s);
                } else {
                    Log.d("HttpUrlConnection", "数据为请求到");
                }
            }
        }.execute(url, phone, pwd);

    }

    private String Postok(String url, String phone, String pwd) {
        HttpURLConnection connection = null;
        try {
            URL urs = new URL(url);
            connection = (HttpURLConnection) urs.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            String pho = "phone=" + URLEncoder.encode(phone) + "&pwd=" + URLEncoder.encode(pwd);
            connection.getOutputStream().write(pho.getBytes());
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                String s = new String(ByteStreams.toByteArray(inputStream));
                Log.d("sss", s);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface CallBack {
        void callcheng(String che);

        void callshi();
    }
}
