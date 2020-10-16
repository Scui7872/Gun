package com.example.activity.gun;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends  RecyclerView.Adapter<RecycleAdapter.ViewHolder>{
    private List<Money> money;
    private OnItemClickListener onItemClickListener;


    public RecycleAdapter(List<Money> money){
        this.money = money;
    }

    public interface OnItemClickListener {
        void onItemClick(View view,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Money moneys = money.get(position);
        holder.tvTitle.setText(moneys.getTitle());
        holder.tvIntro.setText(moneys.getIntro());
        holder.tvPrice .setText(moneys.getPrice());
        holder.ivIcon.setBackgroundResource(moneys.getIcon());
        holder.ivWay.setBackgroundResource(moneys.getWay());
        if(onItemClickListener !=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return money.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvIntro;
        TextView tvPrice;
        ImageView ivIcon;
        ImageView ivWay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvIntro = itemView.findViewById(R.id.tv_intro);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            ivWay = itemView.findViewById(R.id.iv_card);
        }
    }
}
