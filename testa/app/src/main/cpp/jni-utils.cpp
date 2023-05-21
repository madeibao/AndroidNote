//1.引入Jni头文件
#include <jni.h>
#include <stdlib.h>
#include <stdio.h>
#include <android/log.h>
#include <jni.h>

//处理日志打印
//------------------------------------日志处理-----------------------------------
#define LOG_TAG "JNILogTag"
//不带格式log
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,"%s",__VA_ARGS__)
//带格式
#define LOG_I(format, ...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,format,__VA_ARGS__)


//2.编写NativeUtils对应的JNI的C/C++函数
//------------------------------C/C++函数解释--------------------------------------
//JNIEXPORT JNI导出   jstring 函数返回值  JNICALL  JNI进行调用
//Java_全类名_NativeUtils方法名(JNIEnv *env,jobject jobject)
// JNIEnv *env  C/C++中的函数指针    jobject jobject 调用Native方法的类对象

//------------------------------------sig签名处理-----------------------------------
//方式一：命令
//生成方法签名的方式：进行生成.class文件的目录下 执行： javap -s  xxx.class
//方式二：规律  public String JNICallJava(String msg) java层的方法
//首先是参数（String msg） ---> (Ljava/lang/String;)
//其次返回值 String       ----> Ljava/lang/String;
//最终签名   (Ljava/lang/String;)Ljava/lang/String;
//------------------------常见的转换表------------------------
//     String              Ljava/lang/String;
//      int                 I
//      int[]               [I
//      void                V
//------------------------------------C/C++调用Java-----------------------------------

extern "C"
JNIEXPORT void JNICALL
Java_com_example_testa_NativeUtils_JNICallJavaBack(JNIEnv *env, jobject thiz) {
    // TODO: implement JNICallJavaBack()

    //1.得到类的字节码 (调用java方法所在的类  包名+类名)
    jclass cls = env->FindClass("com/example/testa/NativeUtils");
    //2.获取方法id
    //clazz 类的字节码  name java方法名称  sig java方法签名
    jmethodID mid = env->GetMethodID(cls, "JNICallJava", "(Ljava/lang/String;)V");
    //3.实例化该类
    jobject jobject = env->AllocObject(cls);
    //5.设置java层参数的值
    jstring str = env->NewStringUTF("C/C++ input  value");
    //4.调用java层方法
    env->CallVoidMethod(jobject, mid, str);
}


extern "C"
JNIEXPORT void JNICALL
Java_com_example_testa_NativeUtils_JNICallJavaSumBack(JNIEnv *env, jobject thiz) {
    // TODO: implement JNICallJavaSumBack()

    //1.得到类的字节码 (调用java方法所在的类  包名+类名)
    jclass cls = env->FindClass("com/example/testa/NativeUtils");
    //2.获取方法id
    //参数解析 jmethodID GetMethodID(jclass clazz, const char* name, const char* sig)
    //clazz 类的字节码  name java方法名称  sig java方法签名
    jmethodID mid = env->GetMethodID(cls, "JNICallJavaSum", "(II)V");
    //3.实例化该类
    jobject jobject = env->AllocObject(cls);
    //5.设置java层参数的值
    jint num1 = 10;
    jint num2 = 5;
    //4.调用java层方法
    env->CallVoidMethod(jobject, mid, num1, num2);

}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_testa_NativeUtils_JNICallJavaStaticMethodBack(JNIEnv *env, jobject thiz) {
    // TODO: implement JNICallJavaStaticMethodBack()

    //1.得到类的字节码 (调用java方法所在的类  包名+类名)
    jclass cls = env->FindClass("com/example/testa/NativeUtils");
    //2.获取方法id
    //参数解析 jmethodID GetMethodID(jclass clazz, const char* name, const char* sig)
    //clazz 类的字节码  name java方法名称  sig java方法签名
    jmethodID mid = env->GetStaticMethodID(cls, "JNICallJavaStaticMethod", "()V");
    //3.实例化该类 该方法为static静态方法 故不需要实例化
    //jobject jobject = env->AllocObject(cls);
    //4.调用java层方法
    env->CallStaticVoidMethod(cls, mid);
}



//------------------------------------Java调用C/C++-----------------------------------

extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_testa_NativeUtils_JavaCallJNIArr(JNIEnv *env, jobject thiz, jintArray arr_) {
    // TODO: implement JavaCallJNIArr()

    //1.获取arr数组的元素
    jint *arr = env->GetIntArrayElements(arr_, NULL);
    //2.获取arr数组的长度
    jsize arrSize = env->GetArrayLength(arr_);
    //3.遍历数组
    for (int i = 0; i < arrSize; ++i) {
        *(arr + i) += 10;
    }
    //4.释放内存
    env->ReleaseIntArrayElements(arr_, arr, 0);
    //5.返回数组
    return arr_;
}


extern "C"
JNIEXPORT jint JNICALL
Java_com_example_testa_NativeUtils_JavaCallJNISum(JNIEnv *env, jobject thiz, jint num1, jint num2) {
    // TODO: implement JavaCallJNISum()

    return num1 + num2;
}


extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testa_NativeUtils_JavaCallJNI(JNIEnv *env, jobject thiz) {
    // TODO: implement JavaCallJNI()

    return env->NewStringUTF("C/C++ Say");
}