package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button bt = (Button) findViewById(R.id.Button_1);
        // 设置监听器
        bt.setOnClickListener (
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(FirstActivity.this,"请点击按钮",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

