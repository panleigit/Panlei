package com.example.lianxitiyi;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    private String result;
    private ListView lv;
    private EditText et;
    private String cate;
    private Button but;
    private Mytask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        et = (EditText) findViewById(R.id.et);
        but = (Button) findViewById(R.id.but);
        cate =  et.getText().toString();
        task = new Mytask();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.execute();
            }
        });
    }

    class Mytask extends AsyncTask<Void,Void,String>{
        
        protected String doInBackground(Void... voids) {
            posts("198fb3027181eef8eae2adc6b7e22a33",cate);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("p",result);
            Gson gson = new Gson();
            Mybean mybean = gson.fromJson(s, Mybean.class);
             final List<Mybean.ResultBean> result = mybean.getResult();

            Mybase base = new Mybase(MainActivity.this,result);
            lv.setAdapter(base);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(MainActivity.this,Main2.class);
                    Mybean bean = (Mybean) result;
                    Bundle bundle = new Bundle();
                    bundle.putString("carrier_code",bean.get(i).);
                    bundle.putString("carrier_phone",result.get(i).getCarrier_phone());
                    //intent.putExtras(bundle);
                    bundle.putSerializable("list", );
                    startActivity(intent);
                }
            });
        }
    }

    private void posts(String key,String ex_category) {
        try {
            //1.打开浏览器
            HttpClient httpClient = new DefaultHttpClient();
            //2.填一下地址
            HttpPost httpPost = new HttpPost("http://v.juhe.cn/expressonline/getCarriers.php");
            //设置请求参数
            List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
            //往集合添加请求参数
            params.add(new BasicNameValuePair("key", key));
            params.add(new BasicNameValuePair("ex_category", ex_category));
            //params.add(new BasicNameValuePair())

            httpPost.setEntity(new UrlEncodedFormEntity(params));
            //3.敲回车，等待服务器响应
            HttpResponse httpResponse = httpClient.execute(httpPost);
            //4.得到服务器响应状态码
            int code = httpResponse.getStatusLine().getStatusCode();
            if (code == 200) {//判断服务器是否成功响应
                //得到服务器的响应内容
                InputStream is = httpResponse.getEntity().getContent();
                result = Tools.streamToString(is);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
