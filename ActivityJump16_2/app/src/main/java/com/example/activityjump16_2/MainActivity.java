package com.example.activityjump16_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toCustom(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.activityjump16_2.CustomActivity");
        // 开启一个意图
        startActivity(intent);

    }

    public void toBaidu(View view) {
        Intent intent = new Intent();
//        intent.setAction("android.intent.action.VIEW");
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    public void toCamera(View view) {
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void toPhoto(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType("image/*");
        startActivity(intent);
    }

    public void call(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:12312341234"));
        startActivity(intent);
    }

    public void sendSms(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:124"));
        intent.putExtra("sms_body", "你好啊，这是给你的短信");
        startActivity(intent);
    }

    public void toSetting(View view) {
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        startActivity(intent);

//        Intent intent = new Intent();
//        intent.setClass(this, SettingActivity.class);
//        startActivity(intent);

//        Intent intent = new Intent();
//        intent.setClassName("com.example.activityjump16_1","com.example.activityjump16_1.SettingActivity");
//        startActivity(intent);

//        Intent intent = new Intent();
//        intent.setClassName(MainActivity.this,"com.example.activityjump16_1.SettingActivity");
//        startActivity(intent);
    }
}