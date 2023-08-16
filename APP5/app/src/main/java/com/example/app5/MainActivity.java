package com.example.app5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 构建过滤器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_WALLPAPER_CHANGED);
        // 注册广播
        registerReceiver(new MyReceiver(),intentFilter);
    }

    // 我的广播
    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_WALLPAPER_CHANGED.equals(intent.getAction())){
                Toast.makeText(context, "你更换了壁纸，被我看到了", Toast.LENGTH_LONG).show();
            }
        }
    }
}