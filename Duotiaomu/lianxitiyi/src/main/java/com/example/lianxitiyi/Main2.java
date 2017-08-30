package com.example.lianxitiyi;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import android.widget.ListView;
;

import java.util.ArrayList;
import java.util.List;




/**
 * Created by Administrator on 2017/8/10.
 */

public class Main2 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

         Bundle bundle = this.getIntent().getExtras();
         ListView lv = (ListView) findViewById(R.id.lv);
         bundle.getString("carrier_code");
         bundle.getString("carrier_phone");
        bundle.
    }
}
