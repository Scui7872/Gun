package com.example.activity.gun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            //使用隐式Intent实现 Activity的跳转
            case R.id.tv_btn:
                intent.setAction("com.example.activity.RecycleActivity");
                intent.putExtra("msg","recycle activity");
                break;
        }
        //判断intent 指向的action是否存在
        if(intent.resolveActivity(getPackageManager()) !=null) {
            startActivity(intent);
        }
    }
}