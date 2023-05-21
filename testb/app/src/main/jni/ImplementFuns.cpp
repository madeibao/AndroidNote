//
// Created by ASUS on 2023/5/20/0020.
//
#include <jni.h>
#include <stdio.h>
#include<android/log.h>
#include <stdlib.h>

using namespace std;
#ifdef __cplusplus
extern "C" {
#endif

static const char *className = "com/example/testb/JniUtils";

JNIEXPORT jstring JNICALL JniSay(JNIEnv *env, jobject obj) {
    return env->NewStringUTF("Hello From JNI!!!");
}

JNIEXPORT jint JNICALL addInJni(JNIEnv *env, jobject obj, jint a, jint b) {
    return a + b;
}

static JNINativeMethod gJni_Methods_table[] = {
        {"getStringFromJni", "()Ljava/lang/String;", (void*)JniSay},
        {"getAddResultFromJni", "(II)I", (void*)addInJni},
};

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env = NULL;
    jint result = -1;
    if (vm->GetEnv((void**) &env, JNI_VERSION_1_4) != JNI_OK) {
        return result;
    }

    jclass clazz = (env)->FindClass(className);
    if (clazz == NULL) {
        return -1;
    }

    if ((env)->RegisterNatives(clazz, gJni_Methods_table, sizeof(gJni_Methods_table) / sizeof(gJni_Methods_table[0])) < 0) {
        return -1;
    }

    return JNI_VERSION_1_4;
}

#ifdef __cplusplus
}
#endif