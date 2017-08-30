package com.example.administrator.duotiaomu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


import java.util.List;

import static android.R.attr.type;

/**
 * Created by Administrator on 2017/8/7.
 */

public class Mybase extends BaseAdapter{
    private Context context;
    private List<Mybean.ApkBean> lists;
    private  final int  type_1=0;
    private  final int  type_2=1;
    //
    public Mybase(Context context, List<Mybean.ApkBean> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public int getItemViewType(int position) {
        int p = position % 2;
        if (p == 0) {
            return type_1;
        } else if (p == 1) {
            return type_2;
        }
        return 0;
    }


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    ViewHoudler1 houdler1=null;
    ViewHoudler2 houdler2=null;
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        houdler1 = new ViewHoudler1();
        houdler2 = new ViewHoudler2();
        int type = getItemViewType(position);
        if(convertView==null){
            switch (type){
                case type_1:
                    convertView = View.inflate(context,R.layout.item1,null);
                    houdler1.tv1 = (TextView) convertView.findViewById(R.id.tv1);
                    houdler1.iv = (ImageView) convertView.findViewById(R.id.iv);
                    convertView.setTag(houdler1);
                    break;

                case type_2:
                    convertView = View.inflate(context,R.layout.item2,null);
                    houdler2.tv2 = (TextView) convertView.findViewById(R.id.tv2);
                    houdler2.iv2 = (ImageView) convertView.findViewById(R.id.iv2);
                    convertView.setTag(houdler2);
                    break;
            }

        }
        switch(type) {
            case type_1:
                houdler1= (ViewHoudler1) convertView.getTag();
                houdler1.tv1.setText(lists.get(position).getName());
                break;

            case type_2:
                houdler2= (ViewHoudler2) convertView.getTag();
                houdler2.tv2.setText(lists.get(position).getCategoryName());
                break;
        }

        if (type==type_1){
            ImageLoaderConfiguration loader = ImageLoaderConfiguration.createDefault(context);
            ImageLoader instance = ImageLoader.getInstance();
            instance.init(loader);
            DisplayImageOptions os=new DisplayImageOptions.Builder().build();
            instance.displayImage(lists.get(position).getIconUrl(),houdler1.iv,os);
        }
        if (type==type_2){
            ImageLoaderConfiguration loader = ImageLoaderConfiguration.createDefault(context);
            ImageLoader instance = ImageLoader.getInstance();
            instance.init(loader);
            DisplayImageOptions os=new DisplayImageOptions.Builder().build();
            instance.displayImage(lists.get(position).getIconUrl(),houdler2.iv2,os);
        }
        return convertView;
    }
    class ViewHoudler1{
        private TextView tv1;
        private ImageView iv;
    }
    class ViewHoudler2{
        private TextView tv2;
        private ImageView iv2;
    }
}
