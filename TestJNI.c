#include<stdio.h>
#include"jni.h"
#include"TestJNI.h"

JNIEXPORT JNICALL jint Java_TestJNI_add(JNIEnv * env,jobject thisOBJ,jint n1,jint n2)
{

   jint res;
  res=n1+n2;
  return res;

}
