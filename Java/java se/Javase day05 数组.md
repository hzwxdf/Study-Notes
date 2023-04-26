# Javase笔记 day05 数组、排序、查找

## 1. 数组

### 1.1 数组介绍

数组可以存放多个同一类型的数据，数组也是一种数据类型，是引用类型。即：数组就是一组数据。

```java
// 数组定义
int[] ages = {3, 2, 34 , 5, 8};
// 数组使用
for (int i = 0; i < ages.length; i++) {
    System.out.println("第" + (i + 1) + "个元素：" + ages[i]);
}
```

### 1.2 数组的使用

#### 1.2.1 数组的使用方式1-动态初始化

语法：

数据类型 数组名[] = new 数据类型[大小]

数据类型[] 数组名 = new 数据类型[大小]

![](/images/2023-04-13-20-22-41-image.png)

```java
int[] ages = new int[6];
ags[0] = 1;
ags[1] = 2;
```

#### 1.2.2 数组的使用方式2-动态初始化

先声明数组，然后再创建数组。

语法：

数据类型[] 数组名；

数组名 = new 数据类型[大小]

![](/images/2023-04-13-20-30-04-image.png)

```java
// 声明数组
int[] ages;
// 赋值并创建数组
ages = new int[6];
```

#### 1.2.3 数组的使用方式3-静态初始化

语法：

数据类型[] 数组名 = { 元素值, 元素值... }

![](/images/2023-04-13-20-34-25-image.png)

```java
int[] ages = {1, 4, 8, 18, 20}
```

### 1.3 数组的注意事项和细节

![](/images/2023-04-13-20-36-31-image.png)

```java
byte[] byteArr = new byte[2];
short[] shortArr = new short[2];
int[] intArr = new int[2];
long[] longArr = new long[2];
float[] floatArr = new float[2];
double[] doubleArr = new double[2];
char[] charArr = new char[2];
boolean[] booleanArr = new boolean[2];
String[] stringArr = new String[2];


System.out.println(byteArr[0]);// 0
System.out.println(shortArr[0]);// 0
System.out.println(intArr[0]);// 0
System.out.println(longArr[0]);// 0
System.out.println(floatArr[0]);// 0.0
System.out.println(doubleArr[0]);// 0.0
System.out.println(charArr[0]);// \u0000 空格
System.out.println(booleanArr[0]);// false
System.out.println(stringArr[0]);// null
```

### 1.4 数组练习

![](/images/2023-04-13-20-45-15-image.png)

```java
// 练习1
int arraySize = 26;
char[] charArray = new char[arraySize];
char start = 'A';
for (int i = 0; i < arraySize; i++) {
    charArray[i] = (char)(start + i);
}
for (int i = 0; i < arraySize; i++) {
    System.out.print(charArray[i] + " ");
}

// 练习2
int[] arr = {4, -1, 9, 10, 23};
int maxElement = arr[0];
int maxIndex = 0;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] > maxElement) {
      maxElement = arr[i];
      maxIndex = i;
    }
}
System.out.println("最大值：" + maxElement);
System.out.println("最大值的下标：" + maxIndex);


// 练习3
int[] scores = {26, 52, 40, 80, 88};
int sum = 0;
int avg = 0;
for (int i = 0; i < scores.length; i++) {
    sum += scores[i];
}
avg = sum / scores.length;
System.out.println("数组的和：" + sum);
System.out.println("数组的平均值：" + avg);
```

### 1.5 数组赋值机制

1.基本数据类型赋值，这个值就是具体的数据，而且相互不影响。

2.数组在默认情况下是引用传递，赋的值是地址。

```java
// 基本数据类型赋值，赋值方式为值拷贝
int n1 = 10;
int n2 = n1;
n2 = 80;
System.out.println(n1);
System.out.println(n2);

// 数组在默认情况下是引用传递，赋的值是地址。赋值方式为引用赋值。
int[] arr1 = {2, 3};
int[] arr2 = arr1;
arr2[0] = 8;
System.out.println(arr1[0]);// 8
System.out.println(arr2[0]);// 8
```

![](/images/2023-04-13-21-14-26-image.png)

![](/images/2023-04-13-21-15-36-image.png)

![](/images/2023-04-13-21-16-56-image.png)

### 1.6 数组拷贝

```java
// 拷贝一个数组，要求拷贝数组和被拷贝数组的数据空间分开。
int[] arr = {1, 2, 5, 7, 9, 22};
int[] copyArr = new int[arr.length];
for (int i = 0; i < arr.length; i++) {
    copyArr[i] = arr[i]
}
```

### 1.7 数组反转

```java
// 将一个数组的元素反转
int[] arr = {1, 2, 3, 4, 5};
for (int i = 0; i < (arr.length / 2); i++) {
    int temp = arr[i];
    arr[i] = arr[arr.length -1 -i];
    arr[arr.length -1 -i] = temp;
}
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// 方法2
int[] arr = {1, 2, 3, 4, 5};
int[] reverseArr = new int[arr.length];
for (int i = 0; i < arr.length; i++) {
    reverseArr[i] = arr[arr.length - 1 - i];
}
arr = reverseArr;// 原来的数据空间(堆)没有了变量引用，会被JVM当做垃圾销毁
for (int i = 0; i < reverseArr.length; i++) {
    System.out.println(reverseArr[i]);
}
```

### 1.8 数组扩容

```java
// 给一个数组实现动态扩容
int[] arr = {1, 2, 3};
int[] arrNew = new int[arr.length + 1];
for (int i = 0; i < arr.length; i++) {
    arrNew[i] = arr[i];
}
arr[arrNew.length - 1] = 4;
arr = arrNew;// 原来的数据空间(堆)没有了变量引用，会被JVM当做垃圾销毁
```

### 1.9 排序

![](/images/2023-04-13-21-57-58-image.png)

![](/images/2023-04-13-21-59-26-image.png)

```java
// 冒泡排序：从小到大
int[] arr = {23, 43, 4, 56, 49};
int[] sortArr = new int[arr.length];
for (int i = 0; i < arr.length; i++) {
    for (int j = i; j < (arr.length - 1); j++) {
       // 前一个数比后一个数大时，两者交换
       if (arr[i] > arr[j + 1]) {
         int temp = arr[i];
         arr[i] = arr[j + 1];
         arr[j + 1] = temp;
       }
    }
    System.out.println("、第" + (i + 1) + "轮排序结果：");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "\t");
    }
}
System.out.print("\r\n排序结果：");
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + "\t");
}
```

### 1.10 查找

![](/images/2023-04-13-22-22-37-image.png)

### 1.11 多维数组

多维数组我们只介绍二维数组。

```java
int[][] arr = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
for (int i = 0; i < arr.length; i++) {
    for(int j = 0; j < arr[i].length; j++) {
      System.out.print(arr[i][j] + "、");
    }
    System.out.print("\r\n");
}
```

#### 1.11.1 二维数组的使用

二维数组的使用1：

![](/images/2023-04-13-22-34-28-image.png)

<mark>二维数组的内存说明：（一维数组里存放的是地址）</mark>

![](/images/2023-04-13-22-36-37-image.png)

![](/images/2023-04-13-22-38-11-image.png)

二维数组的使用2和3：

![](/images/2023-04-13-22-38-34-image.png)

```java
// 允许二维数组的列数不确定
int[][] arr;
arr = {
    {1, 2, 3},
    {4, 5}
};
```

二维数组的使用4：

![](/images/2023-04-13-22-45-02-image.png)

#### 1.11.2 二维数组的细节

![](/images/2023-04-14-08-36-11-image.png)

#### 1.11.3 二维数组的练习

```java
/* 使用二维数组打印一个10行的杨辉三角。
============================
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
......
============================

规律：
1. 第一行有1个元素，第n行有n个元素
2. 每行的第一个元素和最后一个元素都是1.
3. 第三行开始，除第一元素和最后一个元素以外的元素都是等于上一行元素左右相加。
*/
Scanner scanner = new Scanner(System.in);
int level = scanner.nextInt();
// 定义一个二维数组，初始有n层
int[][] arr = new int[level][];
for (int i = 0; i < arr.length; i++) {
    // 定义一个每层中列数的数组。数组大小等于层数。
    arr[i] = new int[i + 1];
    // 第一层和第二层
    if (i < 2) {
      // 给列数数组赋值(1、2层的场合)
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = 1;// 第一层和第二层都是1。
      }
    } else {
      // 给列数数组赋值(1、2层以外的场合)
      for (int j = 0; j < arr[i].length; j++) {
        if ((j == 0) || (j == arr[i].length - 1)) {
          arr[i][j] = 1; //每层的第一个和最后一个元素赋值
        } else {
          arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
        }
      }
    }
}

// 打印二维数组
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[i].length; j++) {
      System.out.print(arr[i][j] + "\t");
    }
    System.out.print("\r\n");
}
// 格式化打印二维数组
System.out.println("----------------------------------");
for (int i = 0; i < arr.length; i++) {
    int leftBlankCount = level - (i + 1);
    for (int k = 0; k < leftBlankCount; k++) {
      System.out.print("\t");
    }
    for (int j = 0; j < arr[i].length; j++) {
      System.out.print(arr[i][j] + "\t");
      if (j < (arr[i].length - 1)) {
        System.out.print("\t");
      }
    }
    System.out.print("\r\n");
}
```
