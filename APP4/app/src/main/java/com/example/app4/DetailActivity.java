package com.example.app4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    String sPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView name = findViewById(R.id.name);
        TextView phone = findViewById(R.id.phone);

        Intent intent = getIntent();
        String sName = intent.getStringExtra("name");
        sPhone = intent.getStringExtra("phone");
        name.setText(sName);
        phone.setText(sPhone);
    }

    public void call(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+sPhone));
        startActivity(intent);
    }
}