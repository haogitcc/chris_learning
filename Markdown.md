# Markdown 语法学习

## HTML学习
<html>
    <body bgcolor="Gold">
        <h1 align="center">我的标题h1</h1>
        <h2 align="left">我的标题h2</h2>
        <h3 align="right">我的标题h3</h3>
        <h4>我的标题h4</h4>
        <h5>我的标题h5</h5>
        <h6>我的标题h6</h6>
        <p>我的第一个段落。<a href="http://www.bing.com">必应链接</a></p>
        <p>我的第二个段落。</p>
    </body>
</html>

## （1）标题语法
> Markdown 支持两种标题的语法，类 Setext 和类 atx 形式。
> ### 类 Atx 形式
> 在行首插入 1 到 6 个 # ，对应到标题 1 到 6 阶
> # Heading level 1
> <h1>Heading level 1</h1>
>
> ## Heading level 2
> <h2>Heading level 2</h2>
>
> ### Heading level 3
> <h3>Heading level 3</h3>
>
> #### Heading level 4
> <h4>Heading level 4</h4>
>
> ##### Heading level 5
> <h5>Heading level 5</h5>
>
> ###### Heading level 6
> <h6>Heading level 6</h6>
>
> ### 类 Setext 形式
> 用底线的形式，利用 = （最高阶标题）和 - （第二阶标题）
> 任何数量的 = 和 - 都可以有效果。
>
> Heading level 1
> =
>
> Heading level 2
> -

##（2）段落语法

### 正常，不自动换行
I really like using
Markdown.

I think I'll use it to
format all of my
documents from now on.

### 行末尾加两个或多个空格
I really like using（加两个空格换行）  
Markdown.

I think I'll use it to（加两个空格换行）  
format all of my（加HTML的\<br\>标签换行）<br>
documents (行末尾加\\换行)\
from now on.

## （3）字体
> Markdown 使用星号（*）和底线（_）作为标记强调字词的符号，
> 你可以随便用你喜欢的样式，唯一的限制是，你用什么符号开启标签，就要用什么符号结束。
> 但个人感觉写中文时还是（*）比较好用，因为它不区分全角半角，不用切换输入法。

### 粗体
I just love **bold text**.

I just love __bold text__.

I just love <strong>bold text</strong>.

### 斜体
This is *Italic text*.

This is _Italic text_.

This is <em>Italic text</em>.

### 粗体和斜体
This text is ***really important***.

This text is ___really important___.

This text is __*really important*__.

This text is **_really important_**.

This text is <strong><em>really important</em></strong>.

This text is <em><strong>really important</strong></em>.

### 删除线

how ~~delete this code~~ do you do.

### 下划线

增加<u>下划线</u>

### 脚注
> Todo: 无效，原因未知
>
创建脚注格式类似这样 [^comment]

## （4）引用语法
> 在引用的文字前加 > 即可。
>
> 区块引用可以嵌套（例如：引用内的引用），只要根据层次加上不同数量的 >

每一行
> Dorothy followed her through many of the beautiful rooms in her castle.
>
> The Witch bade her clean the pots and kettles and sweep the floor and keep the fire fed with wood.
>> This is embedded in

一整段
> This is a blockquote with two paragraphs. Lorem ipsum dolor sit amet,
consectetuer adipiscing elit. Aliquam hendrerit mi posuere lectus.
Vestibulum enim wisi, viverra nec, fringilla in, laoreet vitae, risus.

## （5）列表语法
> Markdown 支持有序列表和无序列表。
>
> 无序列表使用星号、加号或是减号作为列表标记。
>
> 有序列表则使用数字接着一个英文句点作为标记。
>
### 无序
- First item (末尾添加两空格)  
  I'm first item's paragraph (末尾添加两空格)  
  I'm first item's paragraph
- First item

* First item
  > I'm first item's paragraph (末尾添加两空格)
  > I'm first item's paragraph
* First item

+ First item

  I'm first item's paragraph (段落换行)

  I'm first item's paragraph
    + Second item
        + Third item

<ul>
  <li>First item
    <ul>
      <li>First item
        <ul>
          <li>First item</li>
          <li>Second item</li>
          <li>Third item</li>
        </ul>
      </li>
      <li>Second item</li>
    </ul>
  </li>
  <li>Second item</li>
  <li>Third item</li>
  <li>Fourth item</li>
</ul>

### 有序
1. First item
    1. 二级目录1
        1. 三级目录1
            - 无序的条目
            - 无序的条目
            - 无序的条目
        2. 三级目录2
    2. 二级目录2
    3. 二级目录3
2. Second item
3. Third item

<ol>
  <li>First item</li>
  <li>Second item
    <ol>
      <li>First item
          <ol>
            <li>First item</li>
            <li>Second item</li>
            <li>Third item</li>
          </ol>
      </li>
      <li>Second item</li>
    </ol>
  </li>
  <li>Third item</li>
  <li>Fourth item</li>
</ol>

## (6)代码块

四个空格或一个制表符缩进

    code style 1 四个空格
    code style 2 一个制表符
`code style 3 反引号`

`printf()`函数

```
三个反引号
<html>
  <h1>
    <title>Test</title>
  </h1>
</html>
```

> > code style 2
>> <code>
>> nano code
>> </code>

## （7）图片
### 一般图片 `![alt 属性文本](图片地址)`
![alt 这是图片](moon.jpg)

### 带标题图片 `![alt 属性文本](图片地址 "可选标题")`
![这是月亮表面的图片](moon.jpg "标题月亮")

### 图片作为链接 `[![alt 属性文本](图片地址 "可选标题")](链接)`
[![这是月亮表面的图片](moon.jpg "标题月亮")](https://markdown.com.cn)

### 高级
这个链接用 1 作为网址变量 [月亮图片][1].

然后在文档的结尾为变量赋值（网址）

[1]: moon.jpg

## (8)分隔线语法
> 在一行中用三个以上的星号、减号、底线来建立一个分隔线，行内不能有其他东西。你也可以在星号或是减号中间插入空格。

Try to put a blank line before

减号

---
- - -

星号

***
* * *

下划线
___
_ _ _

...and after a horizontal rule.

## （9）链接

### `[链接名称](链接地址)`

[超链接显示名](https://cn.bing.com/ "超链接title")

### `<链接地址>`

<https://markdown.com.cn>

### 高级链接
这个链接用 1 作为网址变量 [必应][1]

这个链接用 baidu 作为网址变量 [百度][baidu]

然后在文档的结尾为变量赋值（网址）

[1]: http://www.bing.com/
[baidu]: http://www.baidu.com/

### HTML
<a href="https://cn.bing.com/" title="超链接title">超链接显示名</a>


**<fake@example.com>**

## （10）转义字符
backslash \

backtick ''

asterisk *

underscore _

curly braces {}

brackets []

parentheses ()

pound sign #

plus sign +

minus sign -

dot .

exclamation mark !

pipe |

小于号 &lt;

大于号 &gt;

小于等于 &le;

大于等于 &ge;

与 &amp;

著作权 &copy;

## (11)表格

|表头大于内容左对齐|表头大于内容区中|表头大于内容右对齐|
|:---|:---:|---:|
|内容|内容|内容|
|内容|内容|内容|

|表头|表头|表头|
|:---|:---:|---:|
|内容大于表头|内容大于表头|内容大于表头|
|内容大于表头|内容大于表头|内容大于表头|

## (12)高级技巧
### 支持的 HTML 元素

使用 <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Del</kbd> 重启电脑

<font face="黑体">我是黑体字</font>

<font face="微软雅黑">我是微软雅黑</font>

<font face="STCAIYUN">我是华文彩云</font>

<font color=red>我是红色</font>

<font color=#008000>我是绿色</font>

<font color=Blue>我是蓝色</font>

<font size=5>我是尺寸</font>

<font face="黑体" color=green size=5>我是黑体，绿色，尺寸为5</font>

<table><tr><td bgcolor="yellow">背景色yellow</td></tr></table>

<center>居中</center>
<p align="left">左对齐</p>
<p align="right">右对齐</p>

H<sub>2</sub>O  CO<sub>2</sub>
爆米<sup>TM</sup>

This is [an example](http://example.com/ "Title") inline link.

[This link](http://example.net/) has no title attribute.

<a href="超链接地址" target="_blank">超链接名</a>