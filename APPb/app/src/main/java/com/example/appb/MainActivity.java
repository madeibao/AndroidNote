package com.example.appb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击按钮", Toast.LENGTH_LONG).show();
            }
        });
    }

//    public void onClick2(View view) {
//        Toast.makeText(MainActivity.this,"you clicked Button 1", Toast.LENGTH_LONG).show();
//    }
}