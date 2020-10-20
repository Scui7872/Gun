package com.example.activity.gun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private CheckBox cbAutoLogin;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.tv_username);
        etPassword = findViewById(R.id.tv_passwd);
        cbAutoLogin = findViewById(R.id.tv_auto);
        btnLogin = findViewById(R.id.tv_btn);
        Map<String,String> data = SPUtil.getAll(this);
        if(data.size() > 0) {
            etUsername.setText(data.get("account"));
            etPassword.setText(data.get("password"));
        }

        btnLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                login();
            }
        });
    }

    private void login() {
        //3.1 获取用户名和密码的值
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString();
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this,"用户名或密码都不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        //3.2 比较用户名和密码是否正确，并给出提示
        if("android".equals(username) && "123456".equals(password)) {
            Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,TodayActivity.class);
            intent.putExtra("username",username);
            startActivity(intent);

            if(cbAutoLogin.isChecked()) {
                if (SPUtil.saveAccount(this,username,password));
                Toast.makeText(MainActivity.this,"存储且登陆成功",Toast.LENGTH_LONG).show();
            } else {
                SPUtil.clear(this);
            }
        } else {
            Toast.makeText(this,"用户名或密码不正确",Toast.LENGTH_LONG).show();
        }
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