#**************************************************************************************************
# cMake的公共配置
#**************************************************************************************************
cmake_minimum_required(VERSION 2.8)

project(sample1)

#**************************************************************************************************
# Preprocessor definitions 一些预定义设置
#**************************************************************************************************
if (CMAKE_CL_64)
 add_definitions(-DWIN64)
 set(PLATFORM x64)
else (CMAKE_CL_64)
 set(PLATFORM x86)
endif (CMAKE_CL_64)

if(WIN32)
  ADD_DEFINITIONS(-DIGTB_EXPORTS)
  ADD_DEFINITIONS(-D_WIN32_WINNT=0x0501)
endif(WIN32)

enable_testing()



#根目录设置
SET(BASE_DIR ${CMAKE_CURRENT_SOURCE_DIR})

#源文件设置
AUX_SOURCE_DIRECTORY(${BASE_DIR} OBJ_DIR)

#头文件包含目录
include_directories(${BASE_DIR})


#用$ENV{JAVA_HOME}获取 用于加载jni头文件 前提配置好JAVA_HOME
INCLUDE_DIRECTORIES($ENV{JAVA_HOME}/include)
if(WIN32)
	INCLUDE_DIRECTORIES($ENV{JAVA_HOME}/include/win32)
ELSEIF(APPLE)
    INCLUDE_DIRECTORIES($ENV{JAVA_HOME}/include/darwin)
ELSE() 
	INCLUDE_DIRECTORIES($ENV{JAVA_HOME}/include/linux)
endif()

#生成sample1动态库
add_library(sample1 SHARED ${OBJ_DIR})