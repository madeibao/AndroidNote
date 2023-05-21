package com.example.testa;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static String TAG = "MainActivity";
    private TextView mMsgTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMsgTxt = (TextView) findViewById(R.id.textView);

        NativeUtils nativeUtils = new NativeUtils();
        //Java调用JNI
        String msg = nativeUtils.JavaCallJNI();
        Log.e(TAG,"the out is  "+ msg);
        //mMsgTxt.setText(msg);

        //Java调用JNI实现两个数之和
        int sum = nativeUtils.JavaCallJNISum(10, 5);
        //mMsgTxt.setText(String.format("10+5=%d", sum));
        Log.e(TAG,"the out is  "+ sum);


        //Java调用JNI实现数组中的每个元素加10
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] jniArr = nativeUtils.JavaCallJNIArr(arr);
        StringBuilder buffer = new StringBuilder();
        for (int aJniArr : jniArr) {
            buffer.append(aJniArr).append(",");
        }
        //mMsgTxt.setText(buffer.toString());
        Log.e(TAG,"the out is  "+ buffer);


        //JNICallJavaBack执行
        nativeUtils.JNICallJavaBack();
        //JNICallJavaSumBack执行
        nativeUtils.JNICallJavaSumBack();
        //JNICallJavaStaticMethodBack执行
        nativeUtils.JNICallJavaStaticMethodBack();
    }
}