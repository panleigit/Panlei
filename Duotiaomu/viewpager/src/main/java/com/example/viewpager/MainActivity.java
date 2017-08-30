package com.example.viewpager;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;
import static com.example.viewpager.R.id.vp;

public class MainActivity extends AppCompatActivity {
    private List<View> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ViewPager vp = (ViewPager) findViewById(R.id.vp);
        getview();
        CustomTransformer customTransformer = new CustomTransformer();
        vp.setPageTransformer(true,new ZoomInTransform());
        vp.setAdapter(new Mypager());
    }

    public void getview(){
        list = new ArrayList<View>();
        View v1 = View.inflate(MainActivity.this,R.layout.viewpager1,null);
        list.add(v1);

        View v2 = View.inflate(MainActivity.this,R.layout.viewpager2,null);
        list.add(v2);

        View v3 = View.inflate(MainActivity.this,R.layout.viewpager3,null);
        list.add(v3);
    }

    class Mypager extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
    }

    public class CustomTransformer implements ViewPager.PageTransformer {
            private static final float MIN_SCALE = 0.9F;
            @Override
            public void transformPage(View page, float position) {

                if(position < -1){
                    page.setScaleY(MIN_SCALE);
                }else if(position<= 1){
                    //
                    float scale = Math.max(MIN_SCALE,1 - Math.abs(position));
                    page.setScaleY(scale);
                }else{
                    page.setScaleY(MIN_SCALE);
                }
            }

    }

    public class ZoomInTransform implements ViewPager.PageTransformer {

        public static final String TAG = "simple_PagerTransform";

        @Override
        public void transformPage(View page, float position) {

            int width = page.getWidth();
            int height = page.getHeight();
            //這裏只對右邊的view做了操作
            if (position > 0 && position <= 1) {//right scorlling
                //position是1.0->0,但是沒有等於0
                Log.e(TAG, "right----position====" + position);
                //設置該view的X軸不動
                page.setTranslationX(-width * position);
                //設置縮放中心點在該view的正中心
                page.setPivotX(width / 2);
                page.setPivotY(height / 2);
                //設置縮放比例（0.0，1.0]
                page.setScaleX(1 - position);
                page.setScaleY(1 - position);

            } else if (position >= -1 && position < 0) {//left scrolling

            } else {//center

            }
        }
    }

}
