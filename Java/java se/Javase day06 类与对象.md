# Javase笔记 day06 类与对象

# 1.类与对象

## 1.1 概述

一个程序就是一个世界，有很多事物(对象[属性，行为])。

![](/images/2023-04-14-20-07-49-image.png)

![](/images/2023-04-14-20-08-48-image.png)

## 1.2 类与对象的内存布局

![](/images/2023-04-14-20-10-15-image.png)

## 1.3 类与对象之属性

![](/images/2023-04-14-20-11-26-image.png)

![](/images/2023-04-14-20-11-42-image.png)

## 1.4 对象创建

![](/images/2023-04-14-20-13-03-image.png)

## <mark> 1.5 类与对象的分配机制</mark>

![](/images/2023-04-14-20-14-22-image.png)

### 1.5.1 流程说明

1. 当代码执行到`new Person()`时，jvm首先会加载`Person`类的信息(属性信息、方法信息)到方法区中，然后在堆内存中开辟一段空间处理，并初始化类的属性(属性是基本数据类型就存储在堆中，属性是引用类型的话，就在方法区存储数据，在堆中存放相应地址)。

2. 当代码执行到`Person p1 = new Person()`时，会在栈中声明一个变量`p1`，并将1中创建的对象在堆内存中的地址赋值给p1。

3. 当代码执行到`p1.age=10`时，由于`10`是基本数据类型int，所以直接将堆内存中age的值变为10(0->10)。

4. 当代码执行到`p1.name=“小明”`时，由于`"小明"是``String`类型，属于引用类型。所以会先在方法区的常量池中存储`"小明"`，然后将常量池中的地址给`p1.name`(null->常量池地址)。

5. 当代码执行到`Person p2=p1`时，就将`p1`的地址赋给`p2`。此时`p1`和`p2`指向同一个对象(实例)。

### 1.5.2 类与对象的内存分配机制

Java内存的结构分析

1. 栈：一般存放基本数据类型(局部变量)

2. 堆：存放对象(Cat cat，数组等)

3. 方法区：常量池(常量，比如字符串)、类加载信息

![](/images/2023-04-14-20-32-11-image.png)

## 1.6 成员方法

### 1.6.1 概念

![](/images/2023-04-14-20-38-25-image.png)

```java
// 方法定义
public void speak() {
    System.out.println("我是一个好人");
}
/*
int a :叫做形参。
*/
public void getSum(int a, int b) {
    System.out.println("和=" + (a + b);
}

// 方法调用
speak();
getSum(2, 8);
```

### <mark> 1.6.2 方法的调用机制</mark>

![](/images/2023-04-14-21-07-49-image.png)

### 1.6.3 成员方法的定义

![](/images/2023-04-14-21-11-02-image.png)

### 1.6.4 成员方法的注意事项和使用细节

![](/images/2023-04-14-21-12-28-image.png)

![](/images/2023-04-14-21-15-44-image.png)

![](/images/2023-04-14-21-20-03-image.png)

### 1.6.5 方法练习题

![](/images/2023-04-14-21-23-56-image.png)

```java
// 练习1：
class AA {
    public boolean isEvenNumber(int targetNumber) {
      return (targetNumber % 2) == 0;
    }
}
// 方法调用
isEvenNumber(7);
isEvenNumber(4);


// 练习2：
public void printFormatString(int row, int col, String targetString) {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        System.out.print(targetString + "\t");
      }
      System.out.print("\r\n");
    }
}
// 方法调用
printFormatString(4, 4, "#");
```

### <mark> 1.6.6 方法传参机制</mark>

#### 1.6.6.1 基本数据类型

对应基本数据类型，方法传参传递的是值拷贝。

![](/images/2023-04-14-21-47-20-image.png)

![](/images/2023-04-14-21-46-13-image.png)

#### 1.6.6.2 引用数据类型

引用数据类型，方法传参传递的是地址。

![](/images/2023-04-14-21-56-11-image.png)

![](/images/2023-04-14-21-55-53-image.png)

说明：`Person p = new Person()`的前提下，`p = null`和`p = new Person()`不会对原来的对象产生影响。

![](/images/2023-04-14-22-03-10-image.png)

![](/images/2023-04-14-22-02-44-image.png)

#### 1.6.6.3 方法传参练习

![](/images/2023-04-14-22-05-13-image.png)

```java
// 练习2：克隆对象
class Person {
    private String name;
    private int age;
    // 构造方法和属性的get/set方法省略
}

// 方法定义
public Person copyPerson(Person srcPerson) {
    Person copyPerson = new Person();
    copyPerson.name = srcPerson.name;
    copyPerson.age= srcPerson.age;
    return copyPerson;
}
// 方法调用
Person p = new Person();
p.name = "小李";
p.age = 22;
Person copyP = copyPerson(p);
```

# 1.7 方法递归调用

递归就是方法自己调用自己，每次调用时传入不同的变量。

![](/images/2023-04-14-22-58-59-image.png)

![](/images/2023-04-14-22-31-14-image.png)

```java
// 练习：打印阶乘
public int factorial(int n) {
    if (n == 1) {
      return 1;
    } else {
      return factorial(n - 1) * n;
    }
}

System.out.println(factorial(4));// 1*2*3*4 = 24
/* 内存调用说明：
======================
↑ f(1)栈              ↓
↑ factorial(1)        ↓
↑ = 1                 ↓
↑                     ↓ return 1;
======================
↑ f(2)栈              ↓
↑ factorial(2)        ↓
↑ = f(1) * 2          ↓
↑                     ↓ return 1 * 2;
======================
↑ f(3)栈              ↓
↑ factorial(3)        ↓
↑ = f(2) * 3          ↓
                      ↓ return 1 * 2 * 3;
======================
↑ f(4)栈              ↓
↑ factorial(4)        ↓
↑ = f(3) * 4          ↓
↑                     ↓ return 1 * 2 * 3 * 4;
======================
↑ main栈              ↓
↑ factorial(4)        ↓
↑ = f(4)              ↓
↑                     ↓ System.out.println( 1 * 2 * 3 * 4 );
======================
*/
```

## 1.8 递归练习

### 1.8.1 斐波那契数

用户输入一个整数n，输出这个n的斐波那契数。

```java
/* 斐波那契数
1
1
2
3
5
8
13
....
规律：
第一个和第二个数是1，从第三个开始，每个值是前2个数之和。
*/
public int fibonacci(int n) {
    if (n < 0) {
      System.out.println("输入值不正确，请输入正确的值!");
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    } else {
      return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
// 方法调用
System.out.println(fibonacci(5));
```



### 1.8.2 猴子吃桃

![](/images/2023-04-15-12-46-43-image.png)

```java
/*
思路：
第10天    1个桃子
第9天     (第10天桃子 + 1) * 2
第8天     (第9天桃子 + 1) * 2
...
第n天     (第n-1天桃子 + 1) * 2
*/
public int monkeyEatPeach(int day){
    if (day < 1 || day > 10) {
      System.out.println("输入值不正确，请输入正确的值!");
      return 0;
    }
    if (day == 10) {
      return 1;
    } else {
      return (monkeyEatPeach(day + 1) + 1) * 2;
    }
}
// 方法调用
System.out.println(monkeyEatPeach(1));
```



### 1.8.3 老鼠出迷宫

![](/images/2023-04-15-13-44-21-image.png)

```java
/*
思路：
1. 先定义好迷宫地图，并设置障碍物(二维数组实现);
2. 定义迷宫地图的起始点。
3.上下左右这个顺序来判断4个方法是否能移动
*/
```



## 1.9 方法重载

![](/images/2023-04-15-17-01-32-image.png)

![](/images/2023-04-15-17-06-01-image.png)

```java
// 方法重载
public int calculate(int a) {
    return 1;
}
public int calculate(double a) {
    return 2;
}
public int calculate(int a, int b) {
    return 3;
}
public int calculate(int a, double b) {
    return 4;
}
public int calculate(double b, int a) {
    return 5;
}
```



### 1.10 可变参数

可变参数：方法的可变参数可以当作数组使用。可以指定0-n个同类型参数。给可变参数的方法传实参时，也可以传一个数组。

![](/images/2023-04-15-17-18-19-image.png)

![](/images/2023-04-15-17-24-12-image.png)

```java
// 可变参数：方法的可变参数可以当作数组使用。可以指定0-n个同类型参数。
public int sum(int... args) {
    int max = 0;
    for (int i = 0; i < args.length; i++) {
      max += args[i];
    }
    return max;
}

System.out.println(sum());
System.out.println(sum(1 , 2, 3));
System.out.println(sum(1 , 2, 3, 4));
int[] params = {1, 2, 3, 4};
System.out.println(sum(params));


/* 可变参数和普通类型
可变参数和普通类型参数一起使用时，可变参数要放最后。而且方法的形参只能有一个可变参数。
*/
public int sumWithStart(int start, int... args) {
    int max = start;
    for (int i = 0; i < args.length; i++) {
      max += args[i];
    }
    return max;
}

System.out.println(sumWithStart(10));
System.out.println(sumWithStart(10, 1, 2));
System.out.println(sumWithStart(10, 1, 2, 3, 4));
int[] params = {1, 2, 3, 4};
System.out.println(sumWithStart(10, params));
```



### 1.11 变量作用域

![](/images/2023-04-15-17-34-03-image.png)

![](/images/2023-04-15-17-39-56-image.png)

![](/images/2023-04-15-17-44-46-image.png)

```java
class Person {
    private String name = "global";// 全局变量(属性)，作用域：对象的生命周期内
    
    public void test() {
      String name = "var";// 局部变量，作用域：方法的生命周期内
    }
}
```



### 1.12 构造方法

![](/images/2023-04-15-17-52-00-image.png)

![](/images/2023-04-15-17-52-48-image.png)

![](/images/2023-04-15-17-56-35-image.png)

![](/images/2023-04-15-18-13-07-image.png)

```java
class Dog {
    int age;
    // 有默认的无参构造方法
}

class Dog2 {
    int age;
    public Dog2(int dAge){// 显式指明构造方法。默认的无参构造方法就没了
      age = dAge;
    };
    public Dog2(){// 显式指明的无参构造方法
    };
}
```

### 1.12 对象创建流程分析

![](/images/2023-04-15-18-57-36-image.png)

![](/images/2023-04-15-18-51-17-image.png)

![](/images/2023-04-15-18-54-28-image.png)



### 1.13 this关键字

#### 1.13.1 基本说明

每个对象都有一个this能代表当前对象的。

![](/images/2023-04-15-19-13-29-image.png)

![](/images/2023-04-15-19-21-16-image.png)



#### 1.13.2 this关键字的细节

![](/images/2023-04-15-19-25-53-image.png)

```java
class User {
    // 属性
    String name;
    int age;
    // 构造方法
    public User() {
      System.out.println("User类 无参构造方法");
    }
    public User(String name) {
      this.name = naem;
      System.out.println("User类 有参构造方法 name");
    }
    public User(int age) {
      this.age = age;// this区分局部变量和属性
      System.out.println("User类 有参构造方法 age");
    }
    public User(String name; String age) {
      this();// 构造方法this：this只能在构造方法中调用。必须放在第一条语句
      this(name);
      this(age);
      System.out.println("User类 有参构造方法 name + age");
    }
    // 方法
    public void say() {
      String msg = this.getMsg();
      System.out.println("say 方法：" + msg);
    }
    public String getMsg() {
      return "getMsg 方法：" + this.name + "--" + this.age;// this访问属性
    }
    // 比较和另一个个user的姓名年龄是否相等
    public boolean compareTo(User user) {
      return this.name.equals(user.name) && this.age == user.age;
    }
}


// 调用
User user = new User("张三", 28);
user.say();
User user2 = new User("张三", 28);
user.compareTo(user2);
```



### 1.14 作业练习

![](/images/2023-04-15-20-04-06-image.png)

```java
// 作业1
class A01 {
    public double max(double[] array) {
      if (array.length < 1) {
        return 0.0;
      }

      double max = array[0];
      for (int i = 0; i < array.length; i++) {
        if (array[i] > max) {
          max = array[i];
        }
      }
      return max;
    }
}

A01 a = new A01();
double[] arr = {1.2, 2.1, 1.6, 3.1}
a.max(arr);
```

```java
// 作业2
class A02 {
    public int find(String str) {
      String[] array = {"张三", "李四", "王五"};
      int index = -1;
      if (str != null) {
        for (int i = 0; i < array.length; i++) {
          if (str.equals(array[i]) {
            index = i;
            break;
          }
        }    
      }
      return index;
    }
}


A02 a = new A02();
a.find("李四");
a.find("张");
```

```java
// 作业3
class Book {
    String name;
    int price;
    public Book(String name, int price) {
      this.name = name;
      this.price = price;
    }
    public void updatePrice() {
      if (this.price > 150) {
        this.price = 150;
      } else if (this.price > 100) {
        this.price = 150;
      }
    }
    public void getBookInfo() {
      System.out.println("书籍《" + this.name + "》的价格是：" + this.price);
    }
}


Book book = new Book("三国演义", 160);
book.getBookInfo();
book.updatePrice();
book.getBookInfo();
```



![](/images/2023-04-15-20-34-00-image.png)

```java
class A03 {
    public int[] copyArr(int[] oldArr) {
      if (oldArr.length < 1) {
        return null;
      }
      int[] copyArray = new int[oldArr.length];
      for (int i = 0; i < oldArr.length; i++) {
        copyArray[i] = oldArr[i];
      }
      return copyArray;
    }
}

int[] arr = {2, 4, 6, 8};
A03 a = new A03();
int[] copyaArr = a.copyArr();
```



![](/images/2023-04-15-20-47-46-image.png)

![](/images/2023-04-15-20-48-08-image.png)

![](/images/2023-04-15-20-49-43-image.png)

```java
/* 作业11
method(method(10.0,20.0),100)
由最内层的方法调用可知，method方法有2个形参，参数类型都是double
然后method最外层的调用可知，最外层调用的第一个参数位置是使用的method的返回值，
而method的形参是double，所以method的返回值是double。
*/
public double method(double a, double b) {
    // 内部逻辑未知
    return 0.0;
}
```

![](/images/2023-04-15-20-56-29-image.png)

![](/images/2023-04-15-20-56-48-image.png)

```java
/*
作业14：
*/
class Tom {
    int gameLimit; // 游戏最大次数
    int gameNumber = 1; // 当前游戏次数
    int[][] gameList; // 游戏记录

    public Tom(int gameLimit) {
      this.gameLimit = gameLimit;
      this.gameList = new int[gameLimit][3];
    }

    public void game(int user) {
      if (gameNumber > gameLimit) {
         System.out.println("游戏次数用完了");
      }
      if (user < 0 || user > 2) {
         System.out.println("出的不对");
      }
      //int computer = (int)(Math.random() * 3);
      int computer = new Random().nextInt(3);

      // 游戏
      int winFlag; // 0:平手, -1: 输，1: 赢
      if (user == computer) {
        winFlag = 0;
      } else {
       winFlag = -1;
       switch (user) {
        case 0:
          if (computer == 1) {
            winFlag = 1;
          } else if (computer == 2) {
            winFlag = -1;
          }
          break;
        case 1:
          if (computer == 0) {
            winFlag = -1;
          } else if (computer == 2) {
            winFlag = 1;
          }
          break;
        case 2:
          if (computer == 0) {
            winFlag = 1;
          } else if (computer == 1) {
            winFlag = -1;
          }
          break;
       }
      }
      
      this.printGameResult(user, computer, winFlag);
   
      // 结果保留
      gameList[gameNumber - 1][0] = user;
      gameList[gameNumber - 1][1] = computer;
      gameList[gameNumber - 1][2] = winFlag;
      gameNumber++;
    }

   public void showGameHistory() {
     for (int i = 0; i < this.gameList.length; i++) {
       int[] current = this.gameList[i];
       if (current[2] != 0) {
         this.printGameResult(current[0], current[1], current[2]);
       }
     }
   }

   public void printGameResult(int user, int computer, int winFlag) {
      System.out.print(this.getName(user)+ 
                       " VS " + 
                       this.getName(computer));
      if (winFlag == 1) {
        System.out.println(" 结果：你赢了");
      } else if (winFlag == -1) {
        System.out.println(" 结果：你输了");
      } else {
        System.out.println(" 结果：平手");
      }
   }

    public String getName(int input) {
      String label = null;
      switch (input) {
        case 0:
          label = "石头";
          break;
        case 1:
          label = "剪刀";
          break;
        case 2:
          label = "布";
          break;
      }
      return label;
    }
}



int gameLimit = 4;
Tom tom = new Tom(gameLimit);
while (gameLimit > 0) {
    Scanner scanner = new Scanner(System.in);
    int user = scanner.nextInt();
    tom.game(user);
    gameLimit--;
}
System.out.println("----------------------------");
tom.showGameHistory();
```
