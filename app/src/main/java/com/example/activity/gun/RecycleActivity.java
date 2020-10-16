package com.example.activity.gun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {
    //1.准备模拟数据
    //商品名称与价格数据的集合
    private String[] titles = {"餐饮","果蔬","零食","美容","日用","社交","医疗","数码","娱乐"};
    private String[] intros = {"食堂/外卖","苹果/香蕉/火龙果","好吃的","水/乳","纸巾","出去happy","身体健康","无","懒得动却花钱"};
    private String[] prices = {"￥600","￥100","￥80","￥300","￥120","￥300","￥0","￥0","￥200"};
    //图片数据的集合
    private int[] icons = {
            R.drawable.canyin,R.drawable.guoshu,R.drawable.linshi,
            R.drawable.meirong,R.drawable.riyong,R.drawable.shejiao,
            R.drawable.yiliao,R.drawable.shuma,R.drawable.yule};
    private int[] ways = {
            R.drawable.creditcard,R.drawable.depositcard,R.drawable.cash,
            R.drawable.cash,R.drawable.creditcard,R.drawable.cash,
            R.drawable.creditcard,R.drawable.depositcard,R.drawable.cash};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        initData();
        initView();
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            //使用隐式Intent实现 Activity的跳转
            case R.id.tab4:
                intent.setAction("com.example.activity.SECOND_ACTIVITY");
                intent.putExtra("msg","second activity");
                break;
            case R.id.tab3:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "10000"));
                break;
            case R.id.tab2:
                intent = new Intent(Settings.ACTION_DATE_SETTINGS);
                break;
            case R.id.tab1:
                intent = new Intent(Settings.ACTION_DATE_SETTINGS);
                break;
        }
        //判断intent 指向的action是否存在
        if(intent.resolveActivity(getPackageManager()) !=null) {
            startActivity(intent);
        }
    }

    private void initView() {
        RecyclerView lvGoods = findViewById(R.id.lv_goods);
        lvGoods.setLayoutManager(new LinearLayoutManager(this));
        lvGoods.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        RecycleAdapter adapter = new RecycleAdapter(money);
        lvGoods.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Money moneys = money.get(position);
               Toast.makeText(RecycleActivity.this,moneys.toString(),Toast.LENGTH_SHORT).show();

            }
        });


    }

    private List<Money> money;
    private void initData() {
        money = new ArrayList<>();
        for (int i = 0; i < titles.length;i++) {
            money.add(new Money(titles[i],intros[i],prices[i],icons[i],ways[i]));
        }
    }
}