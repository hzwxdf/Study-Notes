# Javase笔记 day01 Java概述

## 1. Java概述

### 1.1 Java特性

- java语言是面向对象的(oop)

- java语言是健壮的。java的强类型机制、异常处理、垃圾的自动回收等是java程序健壮性的重要保证。

- java语言是跨平台的。（编译产生的字节码文件可以在windows上运行，也可以在linux上运行）

- java是解释性语言。
  
  解释性语言：编译后的代码，不能直接被机器执行。例如：java、javascript、php。
  
  编译性语言：编译后的代码可以直接被机器执行。例如：c、c++。

### 1.2 JDK和JRE

#### 1.2.1 JDK

JDK的全称(Java Development Kit, Java开发工具包)。JDK=JRE + java的开发工具(java、javac、javadoc等)，JDK是提供给开发人员用的，其中包含了JRE，所以安装了JDK就不用安装JRE了。

#### 1.2.2 JRE

JRE的全称(Java Runtime Environment, Java运行环境)。JRE=JVM + java的核心类库(类)。包含JVM(Java Virtual Machine, java虚拟机器)，Java程序所需的核心类库等，想要运行一个开发好的Java程序，只需按照JRE即可。

#### 1.2.3 JDK安装和环境变量配置

JDK安装去官网下载对应安装包进行安装即可

环境变量配置：（windows为例）

1. 我的电脑--属性--高级系统设置--环境变量

2. 增加`%JAVA_HOME`环境变量，设置值就是java的安装路径。

3. 编辑`path`环境变量，增加`%JAVA_HOME%\bin`。

4. 应用好环境变量后，打开DOS命令行，输入`java`和`javac`,验证是否配置成功。如有命令输出则代表配置成功。

### 1.3 Java运行机制

java是先编辑一个`XXX.java`的源文件，然后执行`javac XXX.java`对源文件进行编译，编译之后会产生一个同名的`XXX.class`字节码文件，最后执行`java XXX`命令运行字节码文件。

### 1.4 Java开发细节

1. Java源文件是以`.java`结尾，java字节码文件以`.class`结尾。

2. Java程序的执行入口是`main()` 方法。一般都是固定写法`public static void main(String[] args) {...}`。

3. Java语言严格区分大小写。

4. Java方法由一条条语句构成，每个语句以`;`结尾。

5. Java中大括号`{}`一定是成对出现，   缺一不可。

6. 一个源文件只能包含一个`public`类，其他类的个数不限。

7. 如果源文件包含一个`public`类，那么文件名必须按照类名命名。

8. 一个源文件中最多只有一个`public`类，其他类的个数不限。也可以将`main()`方法写在非`public`类上，这样执行非`public`类的入口就是非`public`类的`main()`方法。

### 1.5 Java常用转义字符

- \t：一个制表符

- \n：一个换行符

- \r： 一个回车

- \\\：一个\

- \\"：一个“

- \‘：一个’

### 1.6 Java注释

#### 1.6.1 单行注释

```java
// 单行注释
public class Demo {
    public static void main(String[] args) { ... }
}

 
```

 

#### 1.6.2 多行注释

```java
/*
  多行注释
  多行注释
*/
public class Demo {
    public static void main(String[] args) { ... }
}

 
```

 

#### 1.6.3 文档注释

文档注释可用`javadoc`命令来生成说明文档。中文乱码可以在`javadoc`命令增加参数解决，即`javadoc -encoding UTF-8 -charset UTF-8`。

```java
/*
* 类的文档注释
* @author test
* @version 1.0
*/
public class Demo {
    public static void main(String[] args) {
      add(1, 2);
    }
    
    /*
     * 2个数相加的方法
     * @param 相加数
     * @param 被加数
     * @return 2个数的相加结果
     */
    public static int add(int num1, int num2) {
      return num1 + num2;
    }
}

 
```

上面的例子中可以使用命令`javadoc -d d:\\api -author -version Demo.java`来生成说明文档。
