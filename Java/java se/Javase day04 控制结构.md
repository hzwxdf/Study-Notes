# Javase笔记 day04 控制结构

# 1.顺序控制

程序是从上往下顺序执行，中间没有任何判断和跳转。

## 2. 分支控制`if-else`

分支控制有3中，单分支控制、双分支控制、多分支控制。

### 2.1 单分支控制

单分支控制指的是`if (...) {...}`这种结构。

基本语法：

```
if (条件表达式) {

执行代码块;(可以有多条语句)

}
```

当条件表达式为`true`时，才会执行`{}`内的代码。如果为`false`，不执行`{}`内的代码。特别说明，如果`{}`内只有一条语句时，可以不写`{}`。

```java
boolean flag = true;
if (flag) {
    System.out.println("flag is true");
}

if (flag) System.out.println("flag is true v2");
```

练习案例：用户输入年龄，大于等于18岁时，控制台输出: 你已经成年了。

```java
Scanner scanner = new Scanner(System.in);
System.out.println("请输入年龄");
int age = scanner.nextInt();
if (age >= 18) {
    System.out.println("你已经成年了");
}
```

### 2.2 双分支控制

双分支控制指的是`if (...) {...} else {...}`这种结构。

基本语法：

```
if (条件表达式) {

执行代码块1;(可以有多条语句)

} else {

执行代码块2;(可以有多条语句)

}
```

当条件表达式为`true`时，才会执行`{执行代码块1}`内的代码。如果为`false`，则执行`{执行代码块2}`内的代码。特别说明，如果`{}`内只有一条语句时，可以不写`{}`。

练习案例：用户输入年龄，大于等于18岁时，控制台输出: 你已经成年了, 否则输出：未成年。

```java
Scanner scanner = new Scanner(System.in);
System.out.println("请输入年龄");
int age = scanner.nextInt();
if (age >= 18) {
    System.out.println("你已经成年了");
} else {
    System.out.println("未成年");
}
```

### 2.3 多分支控制

双分支控制指的是`if (...) {...} else if (...) {...} else {...}`这种结构。

基本语法：

```
if (条件表达式1) {
    执行代码块1;(可以有多条语句)
} else if (条件表达式2) {
    执行代码块2;(可以有多条语句)
} else {
    执行代码块3;(可以有多条语句)
}
```

当条件表达式1为`true`时，才会执行`{执行代码块1}`内的代码。如果条件表达式1为`false`时，如果条件表达式2为`true`时，执行`{执行代码块2}`内的代码，如果条件表达式2为`false`,则执行`{执行代码块2}`内的代码。

练习案例：用户输入分数，分数在100，控制台输出：极好，分数在(80, 99]，控制台输出：优秀，分数在[60, 80]，控制台输出：良好，分数在其他情况，控制台输出：不及格。

```java
Scanner scanner = new Scanner(System.in);
System.out.println("请输入分数");
int score= scanner.nextInt();
if (score == 100) {
    System.out.println("极好");
} else if (score > 80 && score <= 99) {
    System.out.println("优秀");
} else if (score >= 60 && score <= 80) {
    System.out.println("良好");
} else {
    System.out.println("不及格");
}
```

## 3. Switch语法

### 3.1 switch基本语法

![](/images/2023-04-13-10-20-09-image.png)

```
switch (表达式) {
    case 常量1：
      语句块1；
      break;
    case 常量2:
      语句块2；
      break;
    ...
    default:
      default语句块;
      break;
}
```

练习案例：用户输入一个字符，按照a-g的顺序，输出星期一 - 星期天，a-g以外的字符，输出：错误命令。

```java
Scanner scanner = new Scannner(System.in);
System.out.println("请输入一个字符(a-g)：");
char day = scanner.next().chartAt(0);
switch (day) {
    case 'a':
      System.out.println("星期一");
      break;
    case '':
      System.out.println("星期二");
      break;
    case 'a':
      System.out.println("星期三");
      break;
    case 'a':
      System.out.println("星期四");
      break;
    case 'a':
      System.out.println("星期五");
      break;
    case 'a':
      System.out.println("星期六");
      break;
    case 'a':
      System.out.println("星期天");
      break;
    default:
      System.out.println("错误命令");
      break;
}
```

### 3.2 switch细节

![](/images/2023-04-13-10-31-01-image.png)

## 4. for循环

### 4.1 基本语法

![](/images/2023-04-13-10-38-48-image.png)

### 4.2 for循环执行流程

![](/images/2023-04-13-10-41-04-image.png)

### 4.3 for循环细节

![](/images/2023-04-13-10-44-11-image.png)

```java
// 循环初始值和循环变量迭代写在其他地方
for (int i = 0; i < 3; i++) {
    System.out.println("i=" + i);
}
int j = 0;
for (;j < 3;) {
    System.out.println("j=" + j);
     j++;
}

// for循环：多条循环初始值和多条循环变量迭代
for (int a = 0, b = 10; a < b; a++, b--) {
    System.out.println("a和b相等，a=" + a + "，b=" + b);
}
```

### 4.4 for循环练习

练习1：打印1-100之间所有是9的倍数的整数，统计个数及其总和

```java
int count = 0;
int sum = 0;
for (int i = 1;i <= 100; i++) {
    // 使用取模运算9的倍数
    if ((i % 9) == 0) {
      System.out.println("1-100内9的倍数的整数：" + i);
      count++;
      sum += i;
    }
}
System.out.println("1-100内9的倍数的整数的合计个数：" + count);
System.out.println("1-100内9的倍数的整数的合计值：" + sum);
```

练习2：完成下面图片中的表达式的输出。

![](/images/2023-04-13-11-06-43-image.png)

```java
int start = 0;
int max = 5;
for (int i = start ; i <= max; i++) {
    int augend = max - i;
    System.out.println(i + " + " + augend  + " = " + (i + augend ));
}
```

## 5. while循环

### 5.1 while循环的基本语法

![](/images/2023-04-13-11-14-27-image.png)

### 5.2 while循环的执行流程

![](/images/2023-04-13-11-18-34-image.png)

### 5.3 while循环的细节

![](/images/2023-04-13-11-20-12-image.png)

### 5.4 while循环的练习

练习1：打印1-100之间能被3整除的数。

```java
int minNum = 1;
int maxNum = 100;
int divisor = 3;
int i = minNum ;
while (i <= maxNum) {
    if ((i % divisor) == 0) {
      System.out.println("1-100能被" + divisor + "整除的数：" + i);
    }
    i++;
}
```

练习2：打印40-200之间所有的偶数。

```java
int minNum = 40;
int maxNum = 200;
int i = minNum;
while (i <= maxNum) {
    if ((i % 2) == 0) {
      System.out.println("40-200之间的偶数" + i);
    }
    i++;
}
```

## 6. do while循环

### 6.1 do while循环的基本语法

![](/images/2023-04-13-11-33-15-image.png)

### 6.2 do while循环的执行流程

![](/images/2023-04-13-11-33-42-image.png)

### 6.2 do while循环的细节

![](/images/2023-04-13-11-35-14-image.png)

### 6.3 do while循环练习

练习1：打印1-100

```java
int start = 1;
int end = 100;
int i = start;
do {
    System.out.println(i);
    i++;
} while (i <= end);
```

练习2：计算1-100的总和

```java
int start = 1;
int end = 100;
int sum = 0;
int i = 0;
do {
    sum += i;
    i++;
} while (i <= end );
System.out.println("1-100的和=" + sum);
```

练习3：统计1-200之间能被5整除不能被3整除的数的个数

```java
int start = 1;
int end = 200;
int count = 0;
int i = 0;
do {
    if ((i % 5 == 0) && (i % 3 != 0) {
      count++;
    }
    i++;
} while (i <= end );
System.out.println("1-200之间能被5整除不能被3整除的数=" + scount ;
```

练习4：如果用户一直输入“同意”两个字，就一直让用户输入。

```java
Scanner scanner = new Scanner(System.in);
String input = null;
System.out.println("是否同意用户协议？");
do {
    input = scanner.next();
    if ("同意".equals(input)) {
      break;
    }
} while (true);
// 方法2
Scanner scanner = new Scanner(System.in);
char input = ' ';
System.out.println("是否同意用户协议？y/n");
do {
    input = scanner.next().charAt(0);
} while (input != 'y');
```

## 7. 多重循环

### 7.1 多重循环基本介绍

![](/images/2023-04-13-12-02-28-image.png)

### 7.2 多重循环练习

![](/images/2023-04-13-12-05-13-image.png)

练习3：打印九九乘法表

```java
int max = 9;
for (int i = 1; i <= max; i++) {
    // 九九乘法表的一行
    for (int j = 1; j <= i; j++) {
      // 九九乘法表的一列
      int result = j * i;
      System.out.print(j + " * " + i + " = " + result + "\t");
    }
    System.out.print("\r\n");
}
```

练习4：打印一个空心金字塔。

![](/images/2023-04-13-12-14-14-image.png)

```java
System.out.println("请输入要打印的金字塔的层数：);
Scanner scanner = new Scanner(System.in);
int totalLevel = scanner.nextInt();

/* 居左金字塔
================
*
**
***
****
*****
================
*/
System.out.println("居左金字塔-----------------------------");
int v1 = 1;
while (v1 <= totalLevel) {
  // 一层金字塔
  int i = 1;
  while (i <= v1) {
    // 一层 *
    System.out.print("*");
    i++;
  }
  System.out.print("\r\n");
  v1++;
}

/* 实心金字塔
================
    *    
   ***   
  *****  
 ******* 
*********
================

================
实现思路：
实心金字塔中每层输出的空格数量和*数量的总量是不变的，而且每层*的数量是有一定规律的，每层空格的数量=每层输出的重量 - 每层*的数量。
而且每层空格的数量是左右两边对半分的。所以我们可以计算出每层*和空格各种的数量，然后用循环输出每层的*和空格。
每层的输出组成 = 左边的空格 + * + 右边的空格

实心金字塔中每层输出的*是有规律的。规律如下：
1=1 + 0*2
3=1 + 1*2
5=1 + 2*2
7=1 + 3*2

由此可得，每层*的输出个数的计算公式= 1 + (层数-1) * 2
================
*/
System.out.println("实心金字塔-----------------------------");
// 计算出最后一层的 * 的个数
int levelStarMaxCount = 1 + ((totalLevel - 1) * 2);
int v2 = 1;
while (v2 <= totalLevel) {
  // 一层 * 的数量
  int levelStarCount = 1 + ((v2 - 1) * 2);
  // 计算出一层金字塔中 空白 的数量，将得到的数量除以2就是一层中左边空白的数量
  int levelAllBlankCount = levelStarMaxCount - levelStarCount;
  // 一层金字塔中左边 空白 的数量
  int levelLeftevelBlankCount = levelAllBlankCount / 2;
  // 一层金字塔中右边 空白 的数量
  int levelRightBlankCount = levelAllBlankCount / 2;

  // 输出一层金字塔：左边空白
  int i = 1;
  while (i <= levelLeftevelBlankCount) {
    System.out.print(" ");
    i++;
  }
  // 输出一层金字塔：金字塔 *
  int j = 1;
  while (j <= levelStarCount) {
    System.out.print("*");
    j++;
  }
  // 输出一层金字塔：右边空白
  int k = 1;
  while (k <= levelRightBlankCount) {
    System.out.print(" ");
    k++;
  }
  System.out.print("\r\n");
  v2++;
}


/* 空心金字塔
================
    *    
   * *   
  *   *  
 *     * 
*********
================

================
实现思路：
在实心金字塔的基础上，我们已经知道了每层输出多少个*了，我们只需在循环输出每层的*时判断一下，只有每层的第一个和最后一个*才输出、以及第一层和最后一层输出*，其他输出空白即可。
================
*/
System.out.println("空心金字塔-----------------------------");
int v3 = 1;
while (v3 <= totalLevel) {
  // 一层 * 的数量
  int levelStarCount = 1 + ((v3 - 1) * 2);
  // 计算出一层金字塔中 空白 的数量，将得到的数量除以2就是一层中左边空白的数量
  int levelAllBlankCount = levelStarMaxCount - levelStarCount;
  // 一层金字塔中左边 空白 的数量
  int levelLeftevelBlankCount = levelAllBlankCount / 2;
  // 一层金字塔中右边 空白 的数量
  int levelRightBlankCount = levelAllBlankCount / 2;

  // 输出一层金字塔：左边空白
  int i = 1;
  while (i <= levelLeftevelBlankCount) {
    System.out.print(" ");
    i++;
  }
  // 输出一层金字塔：金字塔 *
  int j = 1;
  while (j <= levelStarCount) {
    // * 输出条件：第一层和最后一层的全部*、每层的第一个*和最后一个*
    boolean startOutputFlag = (v3 == 1) || (v3 == totalLevel) || (j == 1) || (j == levelStarCount)
    if (startOutputFlag) {
      System.out.print("*");
    } else {
      System.out.print(" ");
    }
    j++;
  }
  // 输出一层金字塔：右边空白
  int k = 1;
  while (k <= levelRightBlankCount) {
    System.out.print(" ");
    k++;
  }
  System.out.print("\r\n");
  v3++;
}
```

练习：输入一个年份，判断是否是闰年。
闰年是指能被4整除的年份。

```java
/*
闰年：能被4整除的年份
*/
Scanner scanner = new Scanner(System.in);
int year = scanner.nextInt();
if (year % 4 == 0)  {
  System.out.println(year + "是闰年");
} else {
  System.out.println(year + "不是闰年");
}
```

练习：输入一个整数，判断是否是水仙花数。
水仙花数是指一个3位整数的每一位的立方之和等于本身。比如：`153 = 1*1*1 + 5*5*5 + 3*3*3 = 153`。

```java
/*
水仙花数：指一个3位整数的每一位的立方之和等于本身。
比如：`153 = 1*1*1 + 5*5*5 + 3*3*3 = 153`。
*/
Scanner scanner = new Scanner(System.in);
int inputNumber = scanner.nextInt();

if (inputNumber > 0 && inputNumber < 1000) {
  // 获取输入数字的个位数(立方和也可以借助Math.pow方法)
  int unitsDigit = inputNumber % 10;
  int unitsDigitSum = unitsDigit * unitsDigit * unitsDigit;
  System.out.println(inputNumber + "的个位数：" + unitsDigit);

  // 获取输入数字的十位数
  int tensDigitSum = 0;
  if (inputNumber >= 10) {
    int tensDigit = (inputNumber / 10) % 10;
    tensDigitSum = tensDigit * tensDigit * tensDigit;
    System.out.println(inputNumber + "的十位数：" + tensDigit);
  }

  // 获取输入数字的百位数
  int hundredsDigitSum = 0;
  if (inputNumber >= 100) {
    int hundredsDigit = (inputNumber / 100) % 10;
    hundredsDigitSum = hundredsDigit * hundredsDigit * hundredsDigit;
    System.out.println(inputNumber + "的百位数：" + hundredsDigit);
  }

  if ((unitsDigitSum + tensDigitSum + hundredsDigitSum) == inputNumber) {
    System.out.println(inputNumber + "是水仙花数");
    return;
  }
}

System.out.println(inputNumber + "不是水仙花数");
```

## 8. 跳转控制语句

跳转控制语句有`break`、`continue`、`return`。

### 8.1 跳转控制语句-`break`

![](/images/2023-04-13-19-46-38-image.png)

![](/images/2023-04-13-19-47-21-image.png)

```java
loop1:
for (int i =0; i< 3; i++) {
    loop2:
    for (int j =0; j < 3; j++) {
      if (i == 2) {
        // break;
        break loop1;
      }
      System.out.println(j);
    }
}
```

### 8.2 跳转控制语句-`continue`

![](/images/2023-04-13-19-54-24-image.png)

### 8.3 跳转控制语句-`return`

![](/images/2023-04-13-19-55-39-image.png)
