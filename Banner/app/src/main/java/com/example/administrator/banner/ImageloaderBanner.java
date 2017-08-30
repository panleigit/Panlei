package com.example.administrator.banner;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2017/8/9.
 */

public class ImageloaderBanner extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //加载图片的简单用法
        Glide.with(context).load(path).into(imageView);
    }
}
