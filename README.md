作者[@李杰][1]
### jni本地方法测试
这个演示程序是测试scala和java调用动态库，请用eclipse打开，配置好scala环境，example包下面为scala程序，jexample为java程序，两者调用动态库一样，java测试时请移动至example目录下，scala移动到jexample下
目录结构如下
+ [src/main/scala](src/main/scala) java和scala类目录

### 生成.h
#### linux命令如下
```
 SCALA_LIB=/usr/local/lib/scala/2.10.6/lib/
 SCALA_CP=$SCALA_LIB/scala-library.jar:$SCALA_LIB/scala-reflect.jar
 javah -cp $SCALA_CP:. example.Sample1
```
#### windows命令如下
```
SCALA_LIB=%SCALA_HOME%\lib
SCALA_CP=%SCALA_LIB%\scala-library.jar;$SCALA_LIB\scala-reflect.jar
javah -cp %SCALA_CP%;. example.Sample1
```
windows会多一个.h文件，请忽略example_Sample1_delayedInit__body.h
只需要example_Sample1.h
[1]: http://weibo.com/smirklijie