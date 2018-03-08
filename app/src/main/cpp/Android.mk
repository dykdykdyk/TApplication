LOCAL_PATH := $(call my-dir)
##-清除之前的一些系统变量
include $(CLEAR_VARS) 

 ##编译生成的目标对象即so的文件名
LOCAL_MODULE    := JNITest

##编译的源文件，C/C++文件
LOCAL_SRC_FILES := JNITest.c 

include $(BUILD_SHARED_LIBRARY)
