# Javase笔记 day02 变量和基本数据类型

## 1. 变量的概念

变量是一个数据存储空间的表示，可以通过变量名去查找到变量(值)。

1.1 变量的使用

```java
// 声明变量
int age;
// 给变量赋值
age = 1;
// 再使用变量
System.out.println("age = " + age);

// 声明变量并赋值
int age = 1;
```

## 2. 基本数据类型

java数据类型分为基本数据类型和引用数据类型。

### 2.1 基本数据类型

基本数据类型又分为数值型、字符型、布尔型。

1. 数值型
- 整数类型
  
  byte：字节，占1字节（1字节=8位(bit)）
  
  short：短整型，占2字节
  
  int：整型，占4字节
  
  long：长整型，占8字节

- 浮点类型
  
  float：单精度，占4字节
  
  double：双精度，占8字节
2. 字符型
   
   char：2字节，存放单个字符，例如：‘a’。

3. 布尔型
   
   boolean：1字节，存放true、false。

注：long、float、double变量声明时，常量须带后缀。long可以带`l`或者`L`，float可以带`f`或者`F`，double可以带`d`或`D`。

```java
long longVarA = 100l;
long longVarB = 100L;
float floatVarA = 100.0f;
float floatVarB = 100.0F;
double doubleVarA = 100.0d;
double doubleVarB = 100.0D;
```

### 2.2 引用数据类型

引用数据类型分为类（class）、数组（[]）、接口（interface）。

## 3 基本数据类型的使用

### 3.1 整型

整型常量默认是int型。

```java
// 整型变量声明并赋值
byte nameByte = 10;
short hShort = 10;
int hInt = 10;
long longVar = 10L;

/*
整型变量声明并赋值时，需要注意精度损失问题。
高精度常量赋值给低精度变量时，会发生精度损失，代码执行会报错
低精度常量赋值给高精度变量时，不会发送精度损失，代码不会报错。
*/
int a1 = 10;
int a2 = 10L; // 8字节->4字节，发生精度损失

long b1 = 10;
long b2 = 10L;
```

### 3.2 浮点类型

1. 浮点型常量默认是double。

2. 浮点类型在机器中存放形式，浮点数=符号位+指数位+尾数位，其中尾数位可能丢失，造成精度损失。
   
   float：
   
   | 符号位（S）：1bit | 指数位（E）：8bit | 尾数位（M）：23bit |
   | ----------- | ----------- | ------------ |
   
   double:
   
   | 符号位（S）：1bit | 指数位（E）：11bit | 尾数位（M）：52bit |
   | ----------- | ------------ | ------------ |

3. 浮点型常量有2中表示方式：十进制表示和科学计数法表示。
   
   十进制：5.12 512.0f(使用f后缀) .512(0.512运行省略0)
   
   科学计数法：512e2[] 5.12e-2[]

4. 浮点型推荐使用double。

```java
// 十进制
float c0 = 5.12; // 会发生精度损失
double c1 = 5.12;
float c2 = 5.12f;
double c3 = .512;
// 科学计数法
System.out.println(5.12e2); // 等价于 5.12 * 10的2次方
System.out.println(5.12e-2);// 等价于 5.12 / 10的2次方

// 浮点数计算陷阱
double d1 = 2.7;
double d2 = 8.1 / 3;
System.out.println("d1=" + d1 + "  d2=" + d2); 
// d1=2.7  d2=2.6999999999999997 
System.out.println(d1 == d2); 
// 绝对值的误差在某个精度内就认为它相等
if (Math.abs(d1 - d2) <  0.00001) {
  System.out.println("相等");
}
```

### 3.3 字符类型

字符类型常量必须使用`‘’`来声明。

字符类型本质是一个整数，在输出时，是输出对应Unicode码的字符（ASCII编码表）。

字符类型是可以运算的，因为本质是一个整数。

```java
char a1 = 'a';
char a2 = '\t';
char a3 = '中';
char a4 = 97; // a,可以直接输入数字

// char的运算
char a5 = 'a';
char a6 = a5 + 1;// b
```

### 3.4 字符编码表

#### 3.4.1 常用字符编码表

- ASCII：ASCII编码表，1个字节表示，一共128个字符。实际上一个字节可以表示256个字符，只用128个。

- Unicode：Unicode编码表，固定大小的编码，一个字符用2个字节来表示，字母和汉字都是2个字节。

- UTF-8：编码表，大小可变的编码表（可变长为1-6个字节），一个字母用1个字节表示，一个汉字用3个字节表示。

- GBK：可以表示汉字，而且范围广。字母使用1个字节，汉字使用2个字节。

- GBK2312：可以表示汉字，GBK2312 < GBK。

- BIG5：big5码，繁体中文，台湾、香港。

#### 3.4.2 编码表

ASCII编码表一开始是美国开发的标准，只有128个字符。

Unicode编码表是ASCII的增强，Unicode编码是兼容ASCII编码表的。

UTF-8是对Unicode编码表的改进。

### 3.5 布尔类型

布尔类型也叫`boolean`类型，只能取`true`或者`false`。常用在逻辑运算和程序流程控制。

```java
boolean setFlag = false;
boolean getFlag = true;
```

### 3.6 基本数据类型转换

#### 3.6.1 自动类型转换

java程序在进行赋值或者运算时，精度小的数据类型会自动转成精度大的数据类型，这个就是自动类型转换。

```java
/* 自动类型转换：
char -> int -> long -> float -> double
byte -> short -> int -> long -> float -> double
*/
int a = 'a';// a是2字节的char型常量，自动类型转换成4字节的int。
double b = 80;// 80是int型常量，4字节，自动类型转换成8字节的double。
```

自动类型转换细节

1. 多种数据类型进行混合运算时，系统首先将所有数据转换成精度最大的那种数据类型，然后再进行计算。

2. 精度大的数据类型赋值给精度小的数据类型会报错（会发生精度损失），精度小的数据类型赋值给精度大的数据类型会进行自动类型转换。

3. （byte、short）和char这三者之间不能互相自动转换。
   
   ```java
   // 1
   int a1 = 2;
   short a2 = 2;
   double a3 = 4.0d;
   int a4 = a1 + a2 + a3;// 精度损失
   double a5 = a1 + a2 + a3;// 不会精度损失
   // 2
   int a6 = a3;
   double a7 = a1;
   // （byte、short）和char这三者之间不能互相自动转换。
   byte b1 = 10;
   // 细节1：当具体赋值给byte时，byte会先判断是否在-128~127这个范围内，如果是就可以
   int b2 = 1;
   byte b3 = b2; // 报错
   // 细节2：当变量赋值给byte时，会判断类型（不允许高精度到低精度） 
   char b4 = b1;
   // 细节3：byte、short、char之间不能互相转换。
   ```

4. byte、short、char三者可以运算，运算时首先将它们提升为int类型。
   
   ```java
   char a1 = 'a';
   byte a2 = 1;
   short a3 = 10;
   short a4 = a1 + a2 + a3;// 报错，byte、short、char参数运算，会提升为int型
   int a4 = a1 + a2 + a3;
   
   byte b1 = 1;
   byte b2 = 2;
   byte b3 = b1 + b2; // 错， 运算结果为int型
   ```

5. 布尔类型（boolean）不参与转换。

6. 自动提示原则：表达式结果的类型 自动提示为操作数中最大的数据类型。

#### 3.6.2 强制类型转换

1. 将精度大的数据类型转换成精度小的数据类型，使用时需要加上强制转换符`()`。强制类型转换可能造成精度损失或溢出。
   
   ```java
   // 精度损失
   int a1 = (int)1.5f;// 1
   // 数据溢出
   int b1 = 2000;
   byte b2 = (byte)b1;// -48
   ```

2. 强制转换符只对最近的操作数有效。
   
   ```java
   int a1 = (int)1.5 * 2 + 3 * 2.4;// 报错
   int a2 = (int)(1.5 * 2 + 3 * 2.4);// 不报错
   ```

3. char类型可以报错int常量值，但不能保存int变量值。需要强转。
   
   ```java
   char a1 = 100;
   int a2 = 100;
   char a3 = a2;
   char a4 = (char)a2;
   ```

4. char、byte和short在运算时，当作int型处理。

#### 3.6.3 基本数据类型和String字符串的相互转换

基本数据类型转String字符串：只需要加`“”`就可以了。

String字符串转基本数据类型：只需调用对应基本类型的封装对象的方法即可。

```java
byte a1 = 1;
short a2 = 2;
int a3 = 3;
long a4 = 4L;
float a5 = 5.0f;
double a6 =6.0d;
char a7 = 'a';
boolean a8 = true;
// 基本数据类型 -> 字符串
String s1 = a1 + "";
String s2 = a2 + "";
String s3 = a3 + "";
String s4 = a4 + "";
String s5 = a5 + "";
String s6 = a6 + "";
String s7 = a7 + "";
String s8 = a8 + "";
// 字符串 -> 基本数据类型
byte b1 = Byte.parseByte(s1);
short b2 = Short.parseShort(s2);
int b3 = Integer.parseInt(s3);
long b4 = Long.parseLong(s4);
float b5 = Float.parseFloat(s5);
double b6 =Double.parseDouble(s6);
char b7 = s7.charAt(0);
boolean b8 = Boolean.parseBoolean(s8);
```
