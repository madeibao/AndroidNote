package com.example.testb;

public class JniUtils {

    static{
        System.loadLibrary("native-lib");
    }
    public static native String getStringFromJni();
    public static native int getAddResultFromJni(int a, int b);
}
