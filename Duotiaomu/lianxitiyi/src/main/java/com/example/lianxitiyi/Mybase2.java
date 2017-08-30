package com.example.lianxitiyi;

import android.content.ContentValues;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class Mybase2 extends BaseAdapter {
    private Context context;
    private List<Mybean.ResultBean> lists;

    public Mybase2(Context context, List<Mybean.ResultBean> lists) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHoudler houdler;
        if(convertView==null) {
            convertView = View.inflate(context,R.layout.item2,null);
            houdler = new ViewHoudler();
            houdler.carrier_phone = (TextView) convertView.findViewById(R.id.tv1);
            houdler.carrier_code = (TextView) convertView.findViewById(R.id.tv2);
            convertView.setTag(houdler);
        } else {
            houdler= (ViewHoudler) convertView.getTag();
        }
        houdler.carrier_phone.setText(lists.get(position).getCarrier_phone());
        houdler.carrier_code.setText(lists.get(position).getCarrier_code());
        return convertView;
    }
    //
    class ViewHoudler {
        private TextView carrier_code,carrier_phone;
    }
}
