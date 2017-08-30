package com.example.administrator.duotiaomu;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.google.gson.Gson;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private String s;
    private ListView lv;
    private List<Mybean.ApkBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lv);

        Mytask task = new Mytask();
        task.execute();
    }

    class Mytask extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {
            gets();
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Gson gson = new Gson();
            Mybean mybean = gson.fromJson(s, Mybean.class);
            List<Mybean.ApkBean> apk = mybean.getApk();
            Mybase base = new Mybase(MainActivity.this, apk);
            lv.setAdapter(base);
        }
    }

    public String gets(){
        String path = "http://huixinguiyu.cn/Assets/js/data.js";
        try {
            URL  url = new URL(path);
            HttpURLConnection conn =(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            int code = conn.getResponseCode();
            if(code==200){
                InputStream is = conn.getInputStream();
                s = Tools.streamToString(is);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
