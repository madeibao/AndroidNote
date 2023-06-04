package com.example.handlerb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //定义切换的图片的数组id
    int imgids[] = new int[] {
            R.drawable.s_1,
            R.drawable.s_2,
            R.drawable.s_3,
            R.drawable.s_4,
            R.drawable.s_5,
            R.drawable.s_6,
            R.drawable.s_7,
            R.drawable.s_8};

    int imgstart = 0;

    final Handler myHandler = new Handler()
    {
        @Override
        //重写handleMessage方法,根据msg中what的值判断是否执行后续操作
        public void handleMessage(Message msg) {
            if(msg.what == 0x123)
            {
                imgchange.setImageResource(imgids[imgstart++ % 8]);
            }
        }
    };

    ImageView imgchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgchange = (ImageView) findViewById(R.id.imgchange);
        //使用定时器,每隔200毫秒让handler发送一个空信息
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x123);
            }
        }, 0,200);
    }
}