package com.example.testa;

import android.util.Log;

public class NativeUtils {

    static String TAG="NativeUtils";

    static {
        System.loadLibrary("jni-utils");
    }

    public native String JavaCallJNI();

    public native int JavaCallJNISum(int num1, int num2);

    public native int[] JavaCallJNIArr(int[] arr);

    public native void JNICallJavaBack();

    public void JNICallJava(String msg) {
        Log.e("TAG", "JNICallJava---> " + msg);
    }

    public native void JNICallJavaSumBack();


    public void JNICallJavaSum(int num1, int num2) {
        Log.e("TAG", String.format("JNICallJavaSum---> %d+%d=%d", num1, num2, num1 + num2));
    }

    public native void JNICallJavaStaticMethodBack();

    public static void JNICallJavaStaticMethod() {
        Log.e("TAG", "JNICallJavaStaticMethod--->");
    }
}