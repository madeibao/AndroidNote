package com.example.androidputextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //声明控件对象
    private EditText editText1;
    private EditText editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件的对象
        editText1 = findViewById(R.id.edit_1);
        editText2 = findViewById(R.id.edit_2);
        button = findViewById(R.id.button);

        //为Button绑定监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取文本输入框中的内容
                String editTextStr1 = editText1.getText().toString();
                String editTextStr2 = editText2.getText().toString();
                //创建intent对象，参数分别为上下文、要跳转的Activity类
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //将要传递的值附加到Intent对象中暂时保存
                intent.putExtra("extra_data1", editTextStr1);
                intent.putExtra("extra_data2", editTextStr2);
                //启动该intent对象，实现Activity跳转
                startActivity(intent);
            }
        });
    }
}