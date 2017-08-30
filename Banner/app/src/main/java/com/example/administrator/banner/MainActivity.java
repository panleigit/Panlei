package com.example.administrator.banner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.os.Build.VERSION_CODES.O;

public class MainActivity extends AppCompatActivity {

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Banner banner = (Banner)findViewById(R.id.banner);
        //设置图片加载器
        ImageloaderBanner llb = new ImageloaderBanner();
        banner.setImageLoader(llb);
        //建立集合
        list = new ArrayList<>();
        list.add("http://www.microvirt.com/new_market/img/zhuxian_logo.png");
        list.add("http://www.microvirt.com/new_market/img/mhxy/mhxy.png");
        list.add("http://www.microvirt.com/new_market/img/yys_icon2.png");
        banner.setImages(list);
        List<String> lists  = new ArrayList<String>();
        lists.add("第一");
        lists.add("第二");
        lists.add("第三");
        banner.setBannerTitles(lists);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1000);
        //启动banner
        banner.start();
    }
}
