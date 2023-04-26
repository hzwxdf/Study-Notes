# Javase笔记 day07 包

## 1.包

### 1.1 基本概念

![](/images/2023-04-18-17-49-56-image.png)

### 1.2 包的命名

![](/images/2023-04-18-17-55-33-image.png)

### 1.3 常用的包

![](/images/2023-04-18-17-57-32-image.png)

### 1.4 包的使用细节

![](/images/2023-04-18-17-58-54-image.png)

![](/images/2023-04-18-18-03-27-image.png)

### 1.6 访问修饰符

![](/images/2023-04-18-18-05-14-image.png)

![](/images/2023-04-18-18-08-01-image.png)

## 2. 面向对象编程三大特性

面向对象编程有三大特性：封装、继承和多态。

![](/images/2023-04-18-18-17-26-image.png)

### 2.1 封装

![](/images/2023-04-18-18-25-13-image.png)

![](/images/2023-04-18-18-25-55-image.png)

```java
class Person {
    String name;
    int age;
}
// 使用时会将属性暴露在外面
Person p = new Person();
p.namn;
p.age;

// 所以需要将属性私有化，提供get/set方法供外部访问
class Person {
    private String name;
    private int age;

// constructor
public Person(String name, int age){
    //this.name = name;
    //this.age = age;
    // 也可以调用set方法赋值
    this.setName(name);
    this.setAge(age);
}    

// get/set
public void setName(String name){
    if (name.length() >= 1 && name.length() <= 16) {
      this.name = name;
    } else {
      System.out.println("请输入1-16位的用户名！");
    }
}
public String getName(){
    return this.name;
}
public void setAge(int age){
    if (age >= 0 && age <= 100) {
      this.age = age;
    } else {
      System.out.println("请输入1-100的年龄！");
    }
}
public int getAge(){
    return this.age;
}
}

// 调用
Person p2 = new Person(“encpaslution”, 99);
```

### 2.2 继承

![](/images/2023-04-18-18-58-09-image.png)

#### 2.2.1 继承的细节

![](/images/2023-04-20-17-19-13-image.png)

![](/images/2023-04-20-17-32-04-image.png)

![](/images/2023-04-20-17-43-00-image.png)

![](/images/2023-04-20-17-53-39-image.png)

![](/images/2023-04-20-17-58-21-image.png)

#### 2.2.2 继承的本质

![](/images/2023-04-20-18-02-03-image.png)

![](/images/2023-04-20-18-14-45-image.png)

#### 2.2.3 super的使用

![](/images/2023-04-20-18-42-44-image.png)

![](/images/2023-04-20-19-00-44-image.png)

![](/images/2023-04-20-19-01-04-image.png)

![](/images/2023-04-20-19-08-36-image.png)

继承中属性和方法的查找遵循最近原则，先本来查找属性或者方法，找不到再查找父类，找不到就继续向上查找，知道Object类。

在子类中直接`.属性`或者`.方法`，代表从子类开始查找，找不到开始向上(父类)查找。

在子类中直接`this.属性`或者`this.方法`，代表从子类开始查找，找不到开始向上(父类)查找。

在子类中直接`super.属性`或者`super.方法`，代表从父类开始查找，找不到开始向上(父类的父类)查找。

```java
// 继承练习
class A {
    String name = "A name";
    int age = 18;
    private String hobby = "旅游";
    // 构造方法
    public A() {
      System.out.println("A() 无参构造方法");
    }
    public A(String name) {
      System.out.println("A(String name) 有参构造方法");
    }
    // 方法
    public void test() {
      System.out.println("A test()");
    }
}
class B {
    String name = "B name";
    // 构造方法
    public B() {
      // 这里不显示的写super，会默认调用父类的无参构造方法，即: A()
      //super(); // 显示指定父类的构造方法
      //super("调用父类A有参构造方法");// // 显示指定父类的有参构造方法
      this("调用子类B的有参构造方法");
      System.out.println("B() 无参构造方法");
    }
    public B(String name) {
      System.out.println("B(String name) 有参构造方法");
    }
    public void test() {
      System.out.println("A test()");
    }
}

/*
属性或者方法的查找流程
1. 先去本类中查找是否存在对应属性或方法。
2. 本类中没找到对应属性或者方法，就去父类中查找是否存在对应属性或方法。
3. 如果父类中没找到，就去父类的父类中查找是否存在对应属性或方法。一直持续到Object类。
   如果找到了属性或者方法，但是无法访问时会报错
   如果没找到属性或者方法，那会报找不到的错误
*/
B b = new B();
System.out.println(b.name);
System.out.println(b.age);
System.out.println(b.hobby);
/* hobby 是父类A的私有属性，所以会报错
解决办法是让父类A提供公共方法以供访问，例如:public String getHobby(){...}
*/
System.out.println(b.aaa);// aaa 是不存在的属性，所以会报错
b.test();
```

#### 2.2.4 方法重写(Override)

![](/images/2023-04-20-19-36-20-image.png)

![](/images/2023-04-20-19-39-09-image.png)

![](/images/2023-04-20-20-09-31-image.png)

```java
class A {
}
class B extends A {
}

class Person {
    void m1(int a){
      System.out.println("Person m1()");
    }
    public Object m2(){
    }
    public String m3(){
    }
    String m4(){
    }
}

class Student extends Person {
    // 重写父类的m1方法
    void m1(int a){
      System.out.println("Student m1()");
    }
    // public Object m3()//父类的返回值类型是String,但是重写时指定Object，会报错
    public String m3(){
    }
    // 父类的返回值类型是Object，这里重写的返回值类型是Object的子类型，允许
    public String m2(){
    }
    // 不允许缩小父类的访问权限。 public -> protected -> 默认 -> private
    // 使用private会报错，因为private在默认的下面
    protected String m4(){   
    }
}
```

### 2.3 多态

#### 2.3.1 多态基本介绍

![](/images/2023-04-20-20-52-53-image.png)

![](/images/2023-04-20-20-55-55-image.png)

#### 2.3.2 多态细节

![](/images/2023-04-20-21-06-34-image.png)

向上转型：

1.可以调用父类中的所有成员（需遵守访问权限）。

2.不能调用子类中特有成员；（因为在编译阶段，能调用哪些属性和方法，是由编译类型决定的）。

3.最终运行效果看子类的具体实现。（运行时看运行类型。调用方法时，从子类方法开始查找开始调用，找不到向上查找）

![](/images/2023-04-20-21-19-40-image.png)

向下转型：

1.只能强转父类的引用，不能强转父类的对象。

```java
// A是父类，B是A的子类
B b1 = new A();// 这种强转父类对象是不可以的
A a1 = new B();
B b2 = (B)a1;// 强转父类的引用
```

![](/images/2023-04-20-21-27-53-image.png)

注意：instanceof判断的是运行类型。

```java
// 属性 多态
class A {
    int count = 1;
}
class B extends {
    int count = 2;
}
// 调用
B b1 = new B();
b1.count;//编译类型是B，所有是2
A a1 = new B();
a1.count;// 编译类型是A，所有是1


// instanceof 判断是否是某类型或者某类型的子类型
a1 instanceof A;//true
a1 instanceof B;//true
b1 instanceof A;//true
b1.instanceof B;//true
```

#### 2.3.3 动态绑定机制

![](/images/2023-04-20-21-53-08-image.png)

动态绑定机制：

1.当调用对象方法时，该方法回合该对象的内存地址/运行类型绑定。

2.当调用对象属性时，没有动态绑定机制，哪里声明哪里使用。

```java
class A {
    int i = 10;
    int sum(){
      return getI() + 10;
    }
    int sum2(){
      return i + 10;
    }
    int getI(){
      return i;
    }
}
class B extends A {
    int i = 20;
    int sum3() {
      return i + 10;
    }
    int getI(){
      return i;
    }
}

A a = new B();
a.sum();
/*
a的编译类型是A，运行类型是B
1.先去B中找sum方法，B中没有sum方法，所以去A中找
2.A中找到sum方法，但是在sum方法中使用了getI方法
3.由于运行类型是B，所以调用B的getI方法，返回20
4.A的sum方法结果= 20 + 10 = 30;
*/
a.sum2();
/* 
B中没有sum2方法，所以去A中找，A中返回的是属性，
由于属性没有动态绑定，所以返回A的10
*/
a.sum3();
/*
B中有sum3方法，所以去B中找，B中返回的也是属性
所以返回B的20
*/
```

#### 2.3.4 多态练习

![](/images/2023-04-20-22-16-03-image.png)

![](/images/2023-04-20-22-18-01-image.png)

### 2.4 equals方法

![](/images/2023-04-20-22-22-15-image.png)

![](/images/2023-04-20-22-24-03-image.png)

### 2.5 hashCode方法

![](/images/2023-04-20-22-37-54-image.png)



### 2.6 toString方法

![](/images/2023-04-21-19-30-16-image.png)



### 2.6 finalize方法

![](/images/2023-04-21-19-31-01-image.png)
