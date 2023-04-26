# Javase笔记 day07 类与对象(高级)

## 1. 类变量和类方法

### 1.1 类变量

类变量是一个可以被类的所有对象(实例)所共享的变量。使用`static`关键字声明类变量。

类变量又叫静态变量。

<mark>类变量是被同一个类的所有对象实例共享。</mark>

<mark>类变量是在类加载的时候生成的。</mark>

#### 1.1.1 类变量的内存分析

![](/images/2023-04-25-20-40-32-image.png)

类变量：jdk7、8之前是放在方法区的静态域中，jdk8以后是放在堆中。

#### 1.1.2 类变量的定义

![](/images/2023-04-25-20-45-25-image.png)

```java
public class Test {
    public static void main(String[] args) {
        // 类变量访问方式1(推荐)：类名.类变量名
        // 类变量是随着类的加载而加载，所以没有对象实例也可以访问
        System.out.println(A.name);
        System.out.println(A.name2);
        // 类变量访问方式2：对象.类变量名
        A a = new A();
        System.out.println(a.name);
        System.out.println(a.name2);
    }
}

class A {
    // 类变量
    public static String name = "类变量定义方法1（推荐）";
    static public String name2 = "类变量定义方法2（不推荐）";
}
```

#### 1.1.3 类变量的使用细节

![](/images/2023-04-25-20-52-42-image.png)

![](/images/2023-04-25-20-55-06-image.png)

### 1.2 类方法

类方法也叫静态方法，被`static`关键字修饰。

静态方法只可以访问类变量/静态属性、类方法/静态方法。

非静态方法可以访问静态方法、静态属性、非静态方法、非静态属性。

#### 1.2.1 基本介绍

![](/images/2023-04-25-20-56-56-image.png)

```java
public class Test {
    public static void main(String[] args) {
        // 类方法访问方式1(推荐)：类名.类方法名
        A.m1();
        A.m2();
        // 类方法访问方式2：对象.类方法名
        A a = new A();
        a.m1();
        a.m2();
    }
}

class A {
    // 类方法
    public static void m1(){
        System.out.println("类方法定义1（推荐）");
    }
    static public void m2(){
        System.out.println("类方法定义2（推荐）");
    }
}
```

#### 1.2.2 类方法的细节

![](/images/2023-04-25-21-05-33-image.png)

![](/images/2023-04-25-21-06-49-image.png)

## 2. main语法

![](/images/2023-04-25-21-15-42-image.png)

![](/images/2023-04-25-21-21-15-image.png)

## 3. 代码块

代码块又叫初始化块。属于类的成员(即是类的一部分)，将逻辑封装在方法体中，用`{}`包围。

代码块分为静态代码块(即`static`关键字修饰的代码块)和普通代码块(即没有`static`关键字修饰的代码块)。

代码块是在类的加载、对象创建过程中，在调用构造方法之前执行。即代码块的调用是优先于构造方法的。

静态代码块：随着类的加载而执行，类加载时只执行一次。

普通代码块：随着对象的创建而执行，对象每创建一次执行一次

### 3.1 基本介绍

![](/images/2023-04-25-21-26-45-image.png)

![](/images/2023-04-25-21-29-37-image.png)

### 3.2 代码块的细节

![](/images/2023-04-25-21-35-32-image.png)

```java
public class Test {
    public static void main(String[] args) {

        // 静态代码块随类的加载而执行
        // 1. 创建对象实例时
        ST1 st1 = new ST1();
        // 2. 调用类变量时
        System.out.println(ST2.name);
        // 3. 创建子类对象实例时
        ST3C st3C = new ST3C();

        // 普通代码块
        ST4 st4 = new ST4();// 静态代码块只执行一次
        ST4 st41 = new ST4();// 对象实例创建2次，普通代码块执行2次
    }
}

class ST1 {
    // 静态代码块
    static {
        System.out.println("ST1 静态代码块执行...");
    }
}
class ST2 {
    public static String name = "test";
    // 静态代码块
    static {
        System.out.println("ST2 静态代码块执行...");
    }
}
class ST3P {
    // 静态代码块
    static {
        System.out.println("ST3P 父类 静态代码块执行...");
    }
}
class ST3C extends ST3P {
    static {
        System.out.println("ST3C 子类 静态代码块执行...");
    }
}

class ST4 {
    // 静态代码块
    static {
        System.out.println("ST4 静态代码块执行...");
    }
    // 普通代码块
    {
        System.out.println("ST4 普通代码块执行...");
    }
}
```

![](/images/2023-04-25-21-58-00-image.png)

```java
public class Test {
    public static void main(String[] args) {

      /* 类的过程中代码块和属性和构造方法的顺序。1->2->3
      1.静态代码块和静态属性的执行顺序：两者的优先级相同，按照定义位置的先后顺序执行。
      2.普通代码块和普通属性的执行顺序：两者的优先级相同，按照定义位置的先后顺序执行。
      3.构造方法。
      */
      ST1 st1 = new ST1();
      /* 输出结果
        静态方法 getName() 执行
        静态方法 getName2() 执行
        静态代码块1 执行...
        静态代码块2 执行...
        普通方法 getAge() 执行
        普通方法 getAge2() 执行
        普通代码块1 执行...
        普通代码块2 执行...
        ST1 无参构造方法 执行
      */
    }
}

class ST1 {
    // 静态属性
    public static String name = getName();
    public static String name2 = getName2();
    // 静态代码块
    static {
        System.out.println("静态代码块1 执行...");
    }
    static {
        System.out.println("静态代码块2 执行...");
    }
    // 静态方法
    public static String getName(){
        System.out.println("静态方法 getName() 执行");
        return "静态属性";
    }
    public static String getName2(){
        System.out.println("静态方法 getName2() 执行");
        return "静态属性2";
    }

    // 普通属性
    public int age = getAge();
    public int age2 = getAge2();
    // 普通代码块
    {
        System.out.println("普通代码块1 执行...");
    }
    {
        System.out.println("普通代码块2 执行...");
    }
    // 普通方法
    public int getAge() {
        System.out.println("普通方法 getAge() 执行");
        return 100;
    }
    public int getAge2() {
        System.out.println("普通方法 getAge2() 执行");
        return 200;
    }

    // 构造方法
    public ST1() {
        System.out.println("ST1 无参构造方法 执行");
    }
}
```

![](/images/2023-04-25-22-19-25-image.png)

![](/images/2023-04-25-22-23-59-image.png)

```java
public class Test {
    public static void main(String[] args) {

        /* 当有继承关系时，代码块和属性和构造方法之间的执行顺序。
        ST2 st2 = new ST2();
        通过new ST2()创建对象时，需要先加载类的信息，那自然就是静态代码块和静态属性/方法先执行(按照从上到下的顺序执行)，
        加载完类的信息就开始调用构造方法创建对象，子类ST2的构造方法的默认第一行有super()，所以先去执行父类的构造方法。
        父类的构造方法的第一行也有super()，这个是Object类的，没什么输出不用管它，然后执行父类的普通代码块，最后执行父类的构造方法。
        父类执行完毕后，开始执行子类的构造方法，子类的构造方法中执行子类的普通代码块，最后执行子类的构造方法。

        具体顺序如下：
        1.父类的静态代码块和静态属性：两者的优先级相同，按照定义位置的先后顺序执行。
        2.子类的静态代码块和静态属性：两者的优先级相同，按照定义位置的先后顺序执行。
        3.父类的普通代码块和普通属性的执行顺序：两者的优先级相同，按照定义位置的先后顺序执行。
        4.父类的构造方法。
        5.子类的普通代码块和普通属性的执行顺序：两者的优先级相同，按照定义位置的先后顺序执行。
        6.子类的构造方法。
         */
        ST2 st2 = new ST2();
        /* 执行结果：
        ST1父类 静态方法 getName() 执行
        ST1父类 静态代码块 执行...
        ST2子类 静态方法 getName2() 执行
        ST2子类 静态代码块2 执行...
        ST1父类 普通方法 getAge() 执行
        ST1父类 普通代码块 执行...
        ST1父类 无参构造方法 执行
        ST2子类 普通方法 getAge2() 执行
        ST2子类 普通代码块2 执行...
        ST2子类 无参构造方法 执行
         */

    }
}

class ST1 {
    // 静态属性
    public static String name = getName();
    // 静态代码块
    static {
        System.out.println("ST1父类 静态代码块 执行...");
    }
    // 静态方法
    public static String getName(){
        System.out.println("ST1父类 静态方法 getName() 执行");
        return "静态属性";
    }

    // 普通属性
    public int age = getAge();
    // 普通代码块
    {
        System.out.println("ST1父类 普通代码块 执行...");
    }
    // 普通方法
    public int getAge() {
        System.out.println("ST1父类 普通方法 getAge() 执行");
        return 100;
    }

    // 构造方法
    public ST1() {
        // super();
        // 调用普通代码块和普通属性初始化
        System.out.println("ST1父类 无参构造方法 执行");
    }
}
class ST2 extends ST1 {
    // 静态属性
    public static String name2 = getName2();
    // 静态代码块
    static {
        System.out.println("ST2子类 静态代码块2 执行...");
    }
    // 静态方法
    public static String getName2(){
        System.out.println("ST2子类 静态方法 getName2() 执行");
        return "静态属性";
    }

    // 普通属性
    public int age2 = getAge2();
    // 普通代码块
    {
        System.out.println("ST2子类 普通代码块2 执行...");
    }
    // 普通方法
    public int getAge2() {
        System.out.println("ST2子类 普通方法 getAge2() 执行");
        return 100;
    }

    // 构造方法
    public ST2() {
        // super();
        // 调用普通代码块和普通属性初始化
        System.out.println("ST2子类 无参构造方法 执行");
    }
}
```

### 3.3 单例设计模式

![](/images/2023-04-26-19-45-19-image.png)

![](/images/2023-04-26-19-45-43-image.png)

![](/images/2023-04-26-19-46-17-image.png)

![](/images/2023-04-26-20-04-52-image.png)

```java
/**
 * 单例设计模式
 * 懒汉式和饿汉式
 */
public class SingleTon {
    public static void main(String[] args) {

        SingleTon01.getInstance();
        SingleTon02.getInstance();
    }
}
/**
 * 懒汉式
 */
class SingleTon01 {
    private static SingleTon01 obj;
    private SingleTon01() {

    }
    public static SingleTon01 getInstance() {
        if (obj == null) {
            obj = new SingleTon01();
        }
        return obj;
    }
}
/**
 * 饿汉式
 */
class SingleTon02 {
    private static SingleTon02 obj = new SingleTon02();
    private SingleTon02() {

    }
    public static SingleTon02 getInstance() {
        return obj;
    }
}
```



## 4. final关键字

### 4.1 基本介绍

![](/images/2023-04-26-20-10-26-image.png)

```java
// final表示类不可以被继承
final class End {
    
}
class User {
    // final修饰属性，表示属性不可以被修改
    final String name = "标识符";
    // final修饰方法,表示方法不可以被覆盖或者重写
    public final void say() {
      // final修饰局部变量，表示局部变量不可以被修改稿
      final double tax_rate = 0.08
    }
}
```

### 4.2 final关键字的细节

![](/images/2023-04-26-20-19-23-image.png)

```java
public class FinalDemo {

    C c = new C();

}

class A {
    // 定义时赋值
    public final double TAX_RATE = 0.08;
    // 定义时不赋值，在构造方法中赋值
    public final double TAX_RATE2;
    // 定义时不赋值，在普通代码块中赋值
    public final double TAX_RATE3;

    public A() {
        TAX_RATE2 = 0.08;
    }
    {
        TAX_RATE3 = 0.08;
    }
}

class B {
    // 定义时赋值
    public final static double TAX_RATE = 0.08;
    // 定义时不赋值，在静态代码块中赋值
    public final static double TAX_RATE2;
    static {
        TAX_RATE2 = 0.08;
    }
}
// final类无法继承，但是可以实例化
final class C {
    public String name = "name";
}
class D {
    public final void m1() {
        System.out.println("m1");
    }
    public void m2() {
        System.out.println("m2");
    }
}
// 非final中存在final方法时，类可以继承，但是final方法无法覆写
class DC extends D {

}
```

![](/images/2023-04-26-20-36-37-image.png)

```java
public class FinalDemo02 {

    public static void main(String[] args) {
        System.out.println(AA.num);// 静态代码块不会执行，final和static一起使用时有优化
        System.out.println(BB.num);// 静态代码块会执行
    }
}
class AA {
    public final static int num = 100;
    static {
        System.out.println("AA 静态代码块执行..");
    }
}

class BB {

    public static int num = 100;
    static {
        System.out.println("BB 静态代码块执行..");
    }
}
```



## 5. 抽象类

### 5.1 基本介绍

![](/images/2023-04-26-20-47-36-image.png)

![](/images/2023-04-26-20-50-03-image.png)

![](/images/2023-04-26-20-51-03-image.png)

### 5.2 抽象类的细节

![](/images/2023-04-26-20-52-53-image.png)

![](/images/2023-04-26-20-56-02-image.png)

![](/images/2023-04-26-20-58-59-image.png)

### 5.3 模板设计模式

抽象类的最佳实践模板设计模式。

![](/images/2023-04-26-21-09-23-image.png)

![](/images/2023-04-26-21-18-58-image.png)

```java
/**
 * 模板设计模式
 * 抽象类的最佳实践
 */
public class AbstractDemo02 {
    public static void main(String[] args) {
        new User().calculateJobTime();
    }
}
abstract class Template {
    public void calculateJobTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("任务耗时：" + (end - start) + "ms");
    }

    abstract void job();
}
class User extends Template {
    @Override
    void job() {
        int num = 0;
        for (int i = 0; i <= 90000000; i++) {
            num += i;
        }
    }
}
```



## 6. 接口

### 6.1 基本介绍

![](/images/2023-04-26-21-44-29-image.png)

```java
interface USBInterface {
    String name = "usb";
    // 接口中在抽象方法，可以省略 abstract 关键字
    void say();
    // jdk1.8后，接口中可以有静态方法
    static void hello() {
        System.out.println("静态方法....");
    }
    // jdk1.8后，接口中可以有默认实现方法，关键字 default 声明的方法
    default void speak() {
        System.out.println("接口默认实现方法...");
    }
}
class Computer implements USBInterface {
    @Override
    public void say() {
        System.out.println("电脑实现了USB接口的say方法");
    }
}
```

### 6.2 接口的细节

![](/images/2023-04-26-22-01-05-image.png)

![](/images/2023-04-26-22-02-54-image.png)

### 6.4 接口和继承类

![](/images/2023-04-26-22-08-53-image.png)

![](/images/2023-04-26-22-10-28-image.png)

### 6.5 接口的多态性

![](/images/2023-04-26-22-12-08-image.png)


