package com.example.activity.gun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            //使用隐式Intent实现 Activity的跳转
            case R.id.lv_set1:
                intent.setAction("com.example.activity.ActivitySet1");
                intent.putExtra("msg","activity set1");
                break;
            case R.id.lv_set2:
                intent.setAction("com.example.activity.ActivitySet2");
                intent.putExtra("msg","activity set2");
                break;
            case R.id.lv_set3:
                intent.setAction("com.example.activity.ActivitySet3");
                intent.putExtra("msg","activity set3");
                break;
            case R.id.lv_set4:
                intent.setAction("com.example.activity.ActivitySet4");
                intent.putExtra("msg","activity set4");
                break;
            case R.id.lv_set5:
                intent.setAction("com.example.activity.ActivitySet5");
                intent.putExtra("msg","activity set5");
                break;
            case R.id.lv_set6:
                intent.setAction("com.example.activity.ActivitySet6");
                intent.putExtra("msg","activity set6");
                break;
            case R.id.lv_set7:
                intent.setAction("com.example.activity.ActivitySet7");
                intent.putExtra("msg","activity set7");
                break;
            case R.id.lv_set8:
                intent.setAction("com.example.activity.ActivitySet8");
                intent.putExtra("msg","activity set8");
                break;
            case R.id.lv_set9:
                intent.setAction("com.example.activity.ActivitySet9");
                intent.putExtra("msg","activity set9");
                break;
            case R.id.lv_set10:
                intent.setAction("com.example.activity.ActivitySet10");
                intent.putExtra("msg","activity set10");
                break;
            case R.id.lv_set11:
                intent.setAction("com.example.activity.ActivitySet11");
                intent.putExtra("msg","activity set11");
                break;
        }
        //判断intent 指向的action是否存在
        if(intent.resolveActivity(getPackageManager()) !=null) {
            startActivity(intent);
        }
    }

    public void onClicka(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            //使用隐式Intent实现 Activity的跳转
            case R.id.arrow:
                intent.setAction("com.example.activity.MainActivity");
                intent.putExtra("msg","main activity");
                break;
        }
        //判断intent 指向的action是否存在
        if(intent.resolveActivity(getPackageManager()) !=null) {
            startActivity(intent);
        }
    }
}