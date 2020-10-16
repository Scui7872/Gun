package com.example.activity.gun;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MoneyAdapter extends BaseAdapter {
    private Context context;
    private List<Money> datas;
    public MoneyAdapter(Context context, List<Money> datas) {
        this.context = context;
        this.datas = datas;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int postion) {
        return datas.get(postion);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView ==null) {
            //将item_list.xml文件找出来并转换成View对象
            convertView = View.inflate(context,R.layout.item_list,null);
            //找到item_list.xml中创建的TextView
            holder = new ViewHolder();
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvPrice = convertView.findViewById(R.id.tv_price);
            holder.tvIntro = convertView.findViewById(R.id.tv_intro);
            holder.ivIcon = convertView.findViewById(R.id.iv_icon);
            holder.ivWay = convertView.findViewById(R.id.iv_card);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Money moneys = datas.get(position);
        holder.tvTitle.setText(moneys.getTitle());
        holder.tvPrice.setText(moneys.getPrice());
        holder.tvIntro.setText(moneys.getIntro());
        holder.ivIcon.setBackgroundResource(moneys.getIcon());
        holder.ivWay.setBackgroundResource(moneys.getWay());
        return convertView;
    }

    static class ViewHolder {
        TextView tvTitle;
        TextView tvIntro;
        TextView tvPrice;
        ImageView ivIcon;
        ImageView ivWay;
    }
}
