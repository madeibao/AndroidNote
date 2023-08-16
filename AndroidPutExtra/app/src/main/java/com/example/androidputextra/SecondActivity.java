package com.example.androidputextra;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    //声明TextView对象
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //获取TextView控件对象
        textView = findViewById(R.id.text_view);

        //获取启动该Activity的Intent对象
        Intent intent = getIntent();

        //获取Intent中暂存的数据
        String data1 = intent.getStringExtra("extra_data1");
        String data2 = intent.getStringExtra("extra_data2");

        //将MainActivity中两个输入框的输入的内容一同在SecondActivity的TextView控件中显示出来
        textView.setText(data1 + " " + data2);
    }
}