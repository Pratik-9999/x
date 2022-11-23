#include<stdio.h>
#include"StringJNI.h"
#include"jni.h"
#include<string.h>

JNIEXPORT jstring JNICALL Java_StringJNI_concate(JNIEnv *env, jobject thisObj, jstring inJNIStr,jstring si) {
   // Step 1: Convert the JNI String (jstring) into C-String (char*)
   const char *inCStr = (*env)->GetStringUTFChars(env, inJNIStr, NULL);
   const char *CStr = (*env)->GetStringUTFChars(env, si, NULL);
   (*env)->GetStringLength(env, jstring );
      strcat(inCStr,CStr);
 
   // Step 2: Perform its intended operations
  // printf("In C, the received string is: %s\n", inCStr);
  // (*env)->ReleaseStringUTFChars(env, inJNIStr, inCStr);  // release resources
 
   
   // Step 3: Convert the C-string (char*) into JNI String (jstring) and return
   return (*env)->NewStringUTF(env, inCStr);
}

