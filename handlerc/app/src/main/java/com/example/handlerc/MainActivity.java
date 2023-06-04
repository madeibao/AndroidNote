package com.example.handlerc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView tv_hello = null;
    Button btn_update = null;
    int updateTimes = 1;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btn_update) {
                Toast.makeText(MainActivity.this, "to update after 3 second", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            //错误做法——线程中不能操作UI
                            //tv_hello.setText("Hello, World!");

                            //正取做法——通过Handler操作UI
                            showMessage("");
                        }
                    }
                }).start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_hello = findViewById(R.id.tv_hello);
        btn_update = findViewById(R.id.btn_update);
        btn_update.setOnClickListener(onClickListener);
    }

    // （1）声明Handler对象，并初始化
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    // TODO 更新UI
                    tv_hello.setText(String.format("Hello, World %d times!", updateTimes++)); //textView是一个TextView的对象，通过 TextView textView= (TextView) findViewById(R.id.text);获取。 text是该TextView的id
                    break;
            }
        }
    };

    //（2）在工作线程中调用handler来更新UI；
    // handler的调用方法——该方法是在工作线程中被调用的
    public void showMessage(String message) {
        handler.sendEmptyMessage(0); // handler根据传递的参数来对应更新UI
    }

}