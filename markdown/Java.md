# chris_learn_java
> 重温Java基础知识

## 1. JVM
> **JVM**是Java Virtual Machine的缩写。它是一种基于计算设备的规范，是一台虚拟机，即虚构的计算机。
>
> JVM屏蔽了具体操作系统平台的信息（显然，就像是我们在电脑上开了个虚拟机一样），
> 当然，JVM执行字节码时实际上还是要解释成具体操作平台的机器指令的。
>
> 通过JVM，Java实现了平台无关性，Java语言在不同平台运行时不需要重新编译，只需要在该平台上部署JVM就可以了。
> 因而能实现一次编译多处运行。(就像是你的虚拟机也可以在任何安了VMWare的系统上运行)
>> **JRE**：Java Runtime Environment，也就是JVM的运行平台，联系平时用的虚拟机，
> 大概可以理解成JRE=虚拟机平台+虚拟机本体(JVM)。类似于你电脑上的VMWare+适用于VMWare的Ubuntu虚拟机。
> 这样我们也就明白了JVM到底是个什么。
>>
>> **JDK**：Java Develop Kit，Java的开发工具包，JDK本体也是Java程序，因此运行依赖于JRE,
> 由于需要保持JDK的独立性与完整性，JDK的安装目录下通常也附有JRE。
> 目前Oracle提供的Windows下的JDK安装工具会同时安装一个正常的JRE和隶属于JDK目录下的JRE。

### 1. 线程
JVM允许一个程序使用多个并发线程，**Hotspot JVM**中Java的线程与原生操作系统的线程是直接映射关系。

即当线程本地存储、缓冲区分配、同步对象、栈、程序计数器等准备好以后，就会创建一个操作系统原生线程。
Java 线程结束，原生线程随之被回收。操作系统负责调度所有线程，并把它们分配到任何可用的 CPU 上。
当原生线程初始化完毕，就会调用 Java 线程的 run() 方法。run() 返回时，被处理未捕获异常，
原生线程将确认由于它的结束是否要终止 JVM 进程（比如这个线程是最后一个非守护线程）。
当线程结束时，会释放原生线程和 Java 线程的所有资源。

Hotspot JVM后台运行的系统线程主要有下面几个：

|结构 |	解释
|:---|:---
|虚拟机线程VMthread|这个线程等待 JVM 到达安全点操作出现。这些操作必须要在独立的线程里执行，因为当堆修改无法进行时，线程都需要JVM 位于安全点。这些操作的类型有：stop-the-world 垃圾回收、线程栈 dump、线程暂停、线程偏向锁（biased locking）解除。
|周期性任务线程|这线程负责定时器事件（也就是中断），用来调度周期性操作的执行。
|GC线程| 这些线程支持 JVM 中不同的垃圾回收活动。
|编译器线程| 这些线程在运行时将字节码动态编译成本地平台相关的机器码。
|信号分发线程| 这个线程接收发送到 JVM 的信号并调用适当的 JVM 方法处理。

### 2. JVM内存区域
JVM主要包括：
- 程序计数器(Program Counter)，
- Java堆(Heap)，
- Java虚拟机栈(Stack)，
- 本地方法栈(Native Stack)，
- 方法区(Method Area)

详细的结构如下：
![alt JVM结构.png](pic/java/JVM结构.png "JVM结构")

![alt JVM内存存储区.png](pic/java/JVM内存存储区.png "JVM内存存储区")

#### 1. 程序计数器(PC, Program Counter) <u>（线程私有ThreadLocal）</u>
是一个寄存器，可以看作是代码行号指示器，类似于实际计算机里的PC，用于指示，跳转下一条需要执行的命令。
Java的基础操作以及异常处理等都十分依赖PC。

JVM多线程是通过线程轮流切换并分配处理器执行时间的方式来实现的。在一个确定的时刻，
一个处理器（或者说多核处理器的一个内核）只会执行一条线程中的命令。
因此，为了正常的切换线程，每个线程都会有一个独立的PC，各线程的PC不会互相影响。这个私有的PC所占的这块内存即是线程的“私有内存”。

- 如果线程在执行的是Java方法，那么PC记录的是正在执行的虚拟机字节码指令的地址。
- 如果正在执行的不是Java方法即Native方法，那么PC的值为undefined。

PC的内存区域是唯一的没有规定任何OutOfMemoryError的Java虚拟机规范中的区域。

#### 2. Java虚拟机栈(Stack，Java Virtual Mechine Stacks) <u>（线程私有ThreadLocal）</u>
同PC一样(从工作流程图里我们可以看到，实际上，PC也是存在于JVM Stack上的)，也是线程私有的，生命周期与线程相同。
虚拟机栈<u>描述Java方法执行的内存模型</u>，每个方法被执行时都会创建一个栈帧(Stack Frame)，栈帧会利用局部变量数组存储
- 局部变量(Local Variables)，
- 操作栈(Operand Stack)，
- 方法出口(Return Value)，
- 动态连接(Current Class Constant Pool Reference)等信息。

**局部变量数组**存储了
- 编译可知的八个基本类型(int, boolean, char, short, byte, long, float, double)，
- 对象引用(根据不同的虚拟机实现可能是引用地址的指针或者一个handle)，
- returnAddress类型。

64位的long和double会占用两个Slot， 其余类型会占用一个Slot。
在编译期间，局部变量所需的空间就会完成分配，动态运行期间不会改变所需的空间。

操作栈在执行字节码指令时会被用到，这种方式类似于原生的CPU寄存器，大部分JVM把时间花费在操作栈的花费上，
操作栈和局部变量数组会频繁的交换数据。

动态连接控制着运行时常量池和栈帧的连接。所有方法和类的引用都会被当作符号的引用存在常量池中。
符号引用是实际上并不指向物理内存地址的逻辑引用。
JVM 可以选择符号引用解析的时机，
- 一种是当类文件加载并校验通过后，这种解析方式被称为饥饿方式。
- 另外一种是符号引用在第一次使用的时候被解析， 这种解析方式称为惰性方式。

无论如何 ，JVM 必须要在第一次使用符号引用时完成解析并抛出可能发生的解析错误。
绑定是将对象域、方法、类的符号引用替换为直接引用的过程。绑定只会发生一次。一旦绑定，符号引用会被完全替换。
果一个类的符号引用还没有被解析，那么就会载入这个类。
每个直接引用都被存储为相对于存储结构（与运行时变量或方法的位置相关联的）偏移量。

对Java虚拟机栈这个区域，Java虚拟机规范规定了**两种异常**：
- 线程请求的栈深度大于虚拟机所允许的深度，抛出StackOverFlow异常。
- 对于支持动态扩展的虚拟机，当扩展无法申请到足够的内存时会抛出OutOfMemory异常。

#### 3. 本地方法栈(Native Stack) <u>（线程私有ThreadLocal）</u>
本地方法栈如其名字，和Java Virtual Machine Stack其实极为类似，只是执行的是Native方法，为Native方法服务。
在JVM规范中，没有对它的实现做具体规定。

#### 4. Java 堆(Heap, Garbage Collection Heap) <u>（线程共享ThreadShared）</u> - 运行时数据区
![alt Java垃圾回收.png](pic/java/Java垃圾回收.png "Java垃圾回收")

Java堆是被所有线程共享的一块区域，在虚拟机启动时创建。此内存区域的唯一目的就是存放对象实例，
几乎所有的对象实例都在这里分配内存(随着技术的发展，已不绝对)。

Java堆是垃圾收集器管理的主要区域，因而也被称为GC堆。收集器采用分代回收法，
GC堆可以分为新生代(Yong Generation)和老生代(Old Generation)。 新生代包括Eden Space和Survivor Space
*(新生代又分为 Eden 区、ServivorFrom、ServivorTo 三个区)*。但无论哪个区域，如何划分，存储的都是Java对象实例，
进一步的划分是为了更好的回收内存或快速的分配内存。

根据Java虚拟机规范，堆所在的物理内存区间可以是不连续的，只要逻辑连续就可以。
实现时既可以是固定大小，也可以是可扩展的。如果堆无法扩展时，就会抛出OutOfMemoryError。

#### 5. 方法区(Method Area) <u>（线程共享ThreadShared）</u>
方法区和Java堆类似，也属于各线程共享的内存区域。用于存储已被虚拟机加载的类信息，常量，静态变量，即时编译器编译后的代码数据等。
它属于非堆区(Non Heap)，和Java堆区分开。对于存在永久代(Permanent)概念的虚拟机(HotSpot)而言，方法区存在于永久代。
Java虚拟机规范对方法区的规定很宽松，甚至可以不实现GC。不过并非进入方法区的数据就会永久存在了，
这块区域的内存回收主要为常量池的回收和类型的卸载。这个区域的回收处理不善也会导致严重的内存泄漏。

当方法区无法满足内存分配需求时也会抛出OutOfMemoryError。

#### 6. 代码缓存(Code Cache)
用于编译和存储那些被 JIT 编译器编译成原生代码的方法。

#### 7. 类信息(Class Data)
类信息存储在方法区，其主要构成为运行时常量池(Run-Time Constant Pool)和方法(Method Code)。

一个编译后的类文件包括以下结构：

|结构 |	解释
|:---|:---:
|magic,minor_version,major_version|类文件的版本信息和用于编译这个类的 JDK 版本。
|constant_pool	|类似于符号表，尽管它包含更多数据。下面有更多的详细描述。
|access_flags	|提供这个类的描述符列表。
|this_class	|提供这个类全名的常量池(constant_pool)索引，比如org/jamesdbloom/foo/Bar。
|super_class	|提供这个类的父类符号引用的常量池索引。
|interfaces	|指向常量池的索引数组，提供那些被实现的接口的符号引用。
|fields	|提供每个字段完整描述的常量池索引数组。
|methods	|指向constant_pool的索引数组，用于表示每个方法签名的完整描述。如果这个方法不是抽象方法也不是 native 方法，
那么就会显示这个函数的字节码。
|attributes	|不同值的数组，表示这个类的附加信息，包括 RetentionPolicy.CLASS 和 RetentionPolicy.RUNTIME 注解。

#### 8. 运行时常量池(Run-Time Constant Pool)
运行时常量池是方法区的一部分。Class文件中有类的版本，字段，方法，接口等描述信息和用于存放编译期生成的各种字面量和符号引用。
这部分内容将在类加载后存放到方法区的运行时常量池中。Java虚拟机规范对Class的细节有着严苛的要求而对运行时常量池的实现不做要求。
一般来说除了翻译的Class,翻译出来的直接引用也会存在运行时常量池中。

运行时常量池具备动态性，即运行时也可将新的常量放入池中。比如String类的intern()方法。

常量池无法申请到足够的内存分配时也会抛出OutOfMemoryError。

#### 9. 直接内存(Direct Memory) <u>（不受JVM GC管理）</u>
直接内存并不在Java虚拟机规范中，不是Java的一部分，但是也被频繁使用并可能导致OutOfMemoryError。
Native函数库可以直接分配堆外内存，通过存储在Java堆里的DirectDataBuffer对象作为这块内存的引用进行操作。
这样做在一些场景中可以显著提高性能。

直接内存是堆外内存，自然不受Java堆大小的限制，但是可能受实体机内存大小的限制。如果内存各部分总和大于实体机的内存时，
也会报出OutOfMemoryError。

### 3. JVM运行时内存
Java 堆从 GC 的角度还可以细分为: 新生代(Eden 区、From Survivor 区和 To Survivor 区)和老年代。

![alt JVM运行时内存.png](pic/java/JVM运行时内存.png "JVM运行时内存")

- 新生代
    - Eden 区
    - ServivorFrom
    - ServivorTo
> MinorGC 的过程（复制->清空->互换）
>
> 1. eden、servicorFrom 复制到 ServicorTo，年龄+1
> 2. 清空 eden、servicorFrom
> 3. ServicorTo 和 ServicorFrom 互换

- 老年代
- 永久代

### 4. 垃圾回收与算法
将内存中不再被使用的对象进行回收，GC中用于回收的方法称为收集器，由于GC需要消耗一些资源和时间，
1. 如何确定垃圾
    - 引用计数法
    - 可达性分析
2. 标记清除算法（Mark-Sweep）
3. 复制算法（copying）
4. 标记整理算法(Mark-Compact)
5. 分代收集算法
    - 新生代与复制算法
    - 老年代与标记复制算法

- 分代收集算法
- 分区收集算法

### 5. Java中四种引用类型
不同的对象引用类型， GC会采用不同的方法进行回收，JVM对象的引用分为了四种类型：
- 强引用：默认情况下，对象采用的均为强引用（这个对象的实例没有其他对象引用，GC时才会被回收）。
- 软引用：软引用是Java中提供的一种比较适合于缓存场景的应用（只有在内存不够用的情况下才会被GC）。
- 弱引用：在GC时一定会被GC回收。
- 虚引用：由于虚引用只是用来得知对象是否被GC。

### 6. GC分代收集算法 vs 分区收集算法
Java在对对象的生命周期特征进行分析后，按照新生代、旧生代的方式来对对象进行收集，以尽可能的缩短GC对应用造成的暂停。

### 7. GC垃圾收集器
- Serial 垃圾收集器（单线程、复制算法）
- ParNew 垃圾收集器（Serial+多线程）
- Parallel Scavenge 收集器（多线程复制算法、高效）
- Serial Old 收集器（单线程标记整理算法 ）
- CMS 收集器（多线程标记清除算法）
- G1 收集器
### 8. Java IO/NIO

### 9. JVM类加载机制

## 2. Java集合
### 1. 接口继承关系和实现
#### 集合框架
![alt 集合框架](pic/java/集合框架.png "集合框架")


![alt Collection](pic/java/Collection.png "Collection")
![alt AbstractCollection<E>](pic/java/AbstractCollection.png "AbstractCollection<E>")

#### Map<K, V>
![alt Map<K, V>](pic/java/Map.png "Map<K, V>")

### 2. List
#### 1. LinkList
![alt LinkList<E>](pic/java/LinkedList.png "LinkList<E>")

### 3. Set
#### 1. HashSet<E>
![alt HashSet<E>](pic/java/HashSet.png "HashSet<E>")

### 4. Map
#### 1. HashMap<K,V>
![alt HashMap<K,V>](pic/java/HashMap.png "HashMap<K,V>")

## 3. Java多线程并发
### 1. JAVA 并发知识库
### 2. JAVA 线程实现/创建方式
### 3. 四种线程池
### 4. 线程生命周期(状态)
### 5. 终止线程 4 种方式
### 6. sleep 与 wait 区别
### 7. start 与 run 区别
### 8. JAVA 后台线程
### 9. JAVA 锁
### 10. 线程基本方法
### 11. 线程上下文切换
### 12. 同步锁与死锁
### 13. 线程池原理
### 14. JAVA 阻塞队列原理
### 15. CyclicBarrier、CountDownLatch、Semaphore 的用法
### 16. volatile 关键字的作用（变量可见性、禁止重排序）
### 17. 如何在两个线程之间共享数据
### 18. ThreadLocal 作用（线程本地存储）
### 19. synchronized 和 ReentrantLock 的区别
### 20. ConcurrentHashMap 并发
### 21. Java 中用到的线程调度
### 22. 进程调度算法
### 23. 什么是 CAS（比较并交换-乐观锁机制-锁自旋）
### 24. 什么是 AQS（抽象的队列同步器）

## 3. Java基础
### 1. JAVA 异常分类及处理
### 2. JAVA 反射

#### Java反射API

![](pic/java/反射核心接口和类.png)
![](pic/java/反射获取类方法属性等.png)
![](pic/java/反射类对象获取和方法和属性等获取.png)
![](pic/java/反射获得%20Class%20对象.png)
![](pic/java/反射获取对象的构造方法.png)
![](pic/java/反射获取对象的成员.png)
![](pic/java/反射获取对象的方法.png)

反射 API 用来生成 JVM 中的类、接口或则对象的信息。
1. Class 类：反射的核心类，可以获取类的属性，方法等信息。
2. Field 类：Java.lang.reflec 包中的类，表示类的成员变量，可以用来获取和设置类之中的属性值。
3. Method 类： Java.lang.reflec 包中的类，表示类的方法，它可以用来获取类中的方法信息或者执行方法。
4. Constructor 类： Java.lang.reflec 包中的类，表示类的构造方法。

反射使用步骤（获取 Class 对象、调用对象方法）
1. 获取想要操作的类的 Class 对象，他是反射的核心，通过 Class 对象我们可以任意调用类的方法。
2. 调用 Class 类中的方法，既就是反射的使用阶段。
3. 使用反射 API 来操作这些信息。

反射的应用场合
- 编译时类型和运行时类型
- 编译时类型无法获取具体方法

获取 Class 对象的 3 种方法
1. 调用某个对象的 getClass()方法
```java
   Person p=new Person();
   Class clazz=p.getClass();
```
2. 调用某个类的 class 属性来获取该类对应的 Class 对象
```java
   Class clazz=Person.class;
```
3. 使用 Class 类中的 forName()静态方法(最安全/性能最好)
```java
    Class clazz=Class.forName("类的全路径"); //(最常用)
```

创建对象的两种方法
1. Class 对象的 newInstance()
   ```java
   //获取 Person 类的 Class 对象
   Class clazz=Class.forName("com.chris.test.aaclazz.Person");
   //使用.newInstane 方法创建对象
   Person p = (Person) clazz.newInstance();
   ```
2. 调用 Constructor 对象的 newInstance()
    ```java
    //获取构造方法并创建对象
    Constructor c = clazz.getDeclaredConstructor();
    //创建对象并设置属性
    Person p1 = (Person) c.newInstance(); 
   ```

通过反射调用方法
```java
    //公有方法
    Person.class.getDeclaredMethod("walk", int.class).invoke(p1, 100);
    Person.class.getDeclaredMethod("setName", String.class).invoke(p1, "chris");
    //私有方法
    Method eatMethod = Person.class.getDeclaredMethod("eat");
    eatMethod.setAccessible(true);
    eatMethod.invoke(p1);
```

通过反射获取属性
```java
    //私有属性
    Field nameField = Person.class.getDeclaredField("name");
    nameField.setAccessible(true);
    System.out.println("nameFiled is " + nameField.get(p1));
```

#### 动态语言（动态代理）
在 Java 中的反射机制是指在运行状态中，对于任意一个类都能够知道这个类所有的属性和方法；

并且对于任意一个对象，都能够调用它的任意一个方法；这种动态获取信息以及动态调用对象方法的功能成为 Java 语言的反射机制。

##### InvocationHandler
InvocationHandler 是由动态代理处理器实现的接口，对代理对象的方法调用，会路由到该处理器上进行统一处理。

**核心方法**
```java
/**
* proxy : 代理对象
* method ： 调用方法
* args : 调用方法参数
**/
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
```

##### Proxy
Proxy 用于生成代理对象。

**核心方法**
```java
/**
* 获取代理类<br />
* loader : 类加载器
* interfaces: 类实现的接口
*
*/
Class<?> getProxyClass(ClassLoader loader, Class<?>... interfaces);
/*
* 生成代理对象<br />
* loader : 类加载器
* interfaces : 类实现的接口
* h : 动态代理回调
*/
Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h);

/*
* 判断是否为代理类<br />
* 
* cl ： 待判断类
*/
public static boolean isProxyClass(Class<?> cl);

/*
* 获取代理对象的InvocationHandler <br />
*
* proxy : 代理对象
*/
InvocationHandler getInvocationHandler(Object proxy);
```

### 3. JAVA 注解
Annotation（注解）是 Java 提供的一种对元程序中元素关联信息和元数据（metadata）的途径和方法。

Annatation(注解)是一个接口，程序可以通过反射来获取指定程序中元素的Annotation对象，
然后通过该 Annotation 对象来获取注解中的元数据信息。

### 4. JAVA 内部类
#### 静态内部类

#### 成员内部类

#### 局部内部类

#### 匿名内部类

### 5. JAVA 泛型
#### 泛型方法 `<E>`

`<? extends T>`表示该通配符所代表的类型是 T 类型的子类。

`<? super T>`表示该通配符所代表的类型是 T 类型的父类。

#### 泛型类 `<T>`
```java
class 类名称 <泛型标识：可以随便写任意标识号，标识指定的泛型的类型>{
  private 泛型标识 /*（成员变量类型）*/ var; 
  .....

  }
}
```
### 6. JAVA 序列化(创建可复用的 Java 对象)
### 7. JAVA 复制