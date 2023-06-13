### 如何理解IoC

[Inversion of Control Containers and the Dependency Injection pattern](https://www.martinfowler.com/articles/injection.html)
IoC只是一种设计思想

#### Spring Bean是什么

Spring里面的bean就类似是定义的一个组件，而这个组件的作用就是实现某个功能的，这里所定义的bean就相当于给了你一个更为简便的方法来调用这个组件去实现你要完成的功能。

#### IoC是什么

> 控制反转，不是什么技术，而是一种设计思想。在Java开发中，Ioc意味着将你设计好的对象交给容器控制，而不是传统的在你的对象内部直接控制。

1. **谁控制谁？**
   ![img.png](img/img02-1.png)
   <br>传统Java SE程序设计，我们直接在对象内部通过new进行创建对象，是程序主动去创建依赖对象；而IoC是有专门一个容器来创建这些对象，即由Ioc容器来控制对象的创建；
   <br>谁控制谁？当然是IoC容器控制了对象；控制什么？那就是主要控制了外部资源获取（不只是对象包括比如文件等）。
2. **什么是反转？**
   ![img.png](img/img02-2.png)
   <br>既然叫反转，肯定就有正转，正转其实就是对象去找实例，而反转就反过来了嘛，让实例来找对象；怎么找呢？当然是通过容器啦！
3. **谁依赖谁？**
   <br>
   在spring项目中，将对象理解为Bean，也可以叫bean对象，这个bean和容器之间有个依赖关系，bean对象的创建是依赖容器的，就好像孩子依赖父母一样，孩子不能自己生出自己，需要父母的合作才能出生，这里的孩子就是bean，父母就是容器
4. **谁注入谁？**
   <br>通过容器注入了bean对象，而且这个过程是自动化的，也就是说容器会自动找到和bean对象匹配的类型实例注入到对象中

#### IoC和DI是什么关系

> 控制反转是通过依赖注入实现的，其实它们是同一个概念的不同角度描述。通俗来说就是IoC是设计思想，DI是实现方式。

### Ioc 配置的三种方式

#### xml 配置

顾名思义，就是将bean的信息配置.xml文件里，通过Spring加载文件为我们创建bean。这种方式出现很多早前的SSM项目中，将第三方类库或者一些配置工具类都以这种方式进行配置，主要原因是由于第三方类不支持Spring注解。

- 优点： 可以使用于任何场景，结构清晰，通俗易懂
- 缺点： 配置繁琐，不易维护，枯燥无味，扩展性差

举例：

1. 配置xx.xml文件
2. 声明命名空间和配置bean

#### Java 配置

将类的创建交给我们配置的JavcConfig类来完成，Spring只负责维护和管理，采用纯Java创建方式。其本质上就是把在XML上的配置声明转移到Java配置类中

- 优点：适用于任何场景，配置方便，因为是纯Java代码，扩展性高，十分灵活
- 缺点：由于是采用Java类的方式，声明不明显，如果大量配置，可读性比较差

举例：

1. 创建一个配置类， 添加@Configuration注解声明为配置类
2. 创建方法，方法上加上@bean，该方法用于创建实例并返回，该实例创建后会交给spring管理，方法名建议与实例名相同（首字母小写）。注：实例类不需要加任何注解

#### 注解配置

通过在类上加注解的方式，来声明一个类交给Spring管理，Spring会自动扫描带有@Component，@Controller，@Service，@Repository这四个注解的类，然后帮我们创建并管理，前提是需要先配置Spring的注解扫描器。

- 优点：开发便捷，通俗易懂，方便维护。
- 缺点：具有局限性，对于一些第三方资源，无法添加注解。只能采用XML或JavaConfig的方式配置

举例：

1. 对类添加@Component相关的注解，比如@Controller，@Service，@Repository
2. 设置ComponentScan的basePackage, 比如<context:component-scan base-package='com.kirin.springframework'>
   或者@ComponentScan("com.kirin.springframework")注解，
   或者 new AnnotationConfigApplicationContext("com.kirin.springframework")指定扫描的basePackage.

### 依赖注入的三种方式

> 常用的注入方式主要有三种：构造方法注入（Construct注入），setter注入，基于注解的注入（接口注入）

#### 1.setter方式注入

在Spring3.x刚推出的时候，推荐使用注入的就是这种, 但是这种方式比较麻烦，所以在Spring4.x版本中推荐构造函数注入。

```xml

<bean id="userService" class="com.kirin.springframework.service.UserServiceImpl">
    <!-- setter注入方式 -->
    <property name="userDao" ref="userDao"/>
</bean>
```

写成Java代码,写起来不太方便，看起来也不整洁:

```java

@Controller
public class HelloController {
    private AlphaService alphaService;
    private BetaService betaService;

    @Autowired
    public void setAlphaService(AlphaService alphaService) {
        this.alphaService = alphaService;
    }

    @Autowired
    public void setBetaService(BetaService betaService) {
        this.betaService = betaService;
    }
}
```

#### 2.构造函数注入

在XML配置方式中，<constructor-arg>是通过构造函数参数注入，比如下面的xml:

```xml

<bean id="userService" class="com.kirin.springframework.service.UserServiceImpl">
    <!-- 构造函数注入 -->
    <constructor-arg name="userDao" ref="userDao"/>
</bean>
```

本质上是new UserServiceImpl(userDao)创建对象，所以对应的service类是这样的：

```java
public class UserServiceImpl {

    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDao = userDaoImpl;
    }
}
```

在Spring4.x版本中推荐的注入方式就是这种：

```java

@Controller
public class HelloController {
    private final AlphaService alphaService;
    private final BetaService betaService;

    @Autowired
    public HelloController(AlphaService alphaService, BetaService betaService) {
        this.alphaService = alphaService;
        this.betaService = betaService;
    }
}
```

#### 3.Field注入

以@Autowired（自动注入）注解注入为例，修饰符有三个属性：Constructor，byType，byName。**默认按照byType注入**。

-

constructor：通过构造方法进行自动注入，spring会匹配与构造方法参数类型一致的bean进行注入，如果有一个多参数的构造方法，一个只有一个参数的构造方法，在容器中查找到多个匹配多参数构造方法的bean，那么spring会优先将bean注入到多参数的构造方法中。

- byName：被注入bean的id名必须与set方法后半截匹配，并且id名称的第一个单词首字母必须小写，这一点与手动set注入有点不同。
- byType：查找所有的set方法，将符合符合参数类型的bean注入。

比如：

```java

@Controller
public class HelloController {
    @Autowired
    private AlphaService alphaService;
    @Autowired
    private BetaService betaService;
}
```

### 为什么推荐构造器注入方式？

> The Spring team generally advocates constructor injection as it enables one to implement application components as
> immutable objects and to ensure that required dependencies are not null. Furthermore constructor-injected components
> are
> always returned to client (calling) code in a fully initialized state.

简单的翻译一下：这个构造器注入的方式能够保证注入的组件不可变，并且确保需要的依赖不为空。此外，构造器注入的依赖总是能够在返回客户端（组件）代码的时候保证完全初始化的状态。

- **依赖不可变**：其实说的就是final关键字。
- **依赖不为空**
  （省去了我们对其检查）：当要实例化UserServiceImpl的时候，由于自己实现了有参数的构造函数，所以不会调用默认构造函数，那么就需要Spring容器传入所需要的参数，所以就两种情况：1、有该类型的参数->
  传入，OK 。2：无该类型的参数->报错。
- **完全初始化的状态**
  ：这个可以跟上面的依赖不为空结合起来，向构造器传参之前，要确保注入的内容不为空，那么肯定要调用依赖组件的构造方法完成实例化。而在Java类加载实例化的过程中，构造方法是最后一步（之前如果有父类先初始化父类，然后自己的成员变量，最后才是构造方法），所以返回来的都是初始化之后的状态。

为啥不推荐setter注入:

```java

@Service
public class UserServiceImpl {

    private final UserDaoImpl userDao;

    public UserServiceImpl(final UserDaoImpl userDaoImpl) {
        this.userDao = userDaoImpl;
    }
}
```

如果使用setter注入，缺点显而易见，对于IOC容器以外的环境，除了使用反射来提供它需要的依赖之外，无法复用该实现类。而且将一直是个潜在的隐患，因为你不调用将一直无法发现NPE的存在。

```
UserServiceImpl userService = new UserServiceImpl();
// -> NullPointerException, 潜在的隐患
userService.findUserList();
```

循环依赖的问题：使用field注入可能会导致循环依赖，即A里面注入B，B里面又注入A：

```java
public class A {
    @Autowired
    private B b;
}

public class B {
    @Autowired
    private A a;
}
```

> 如果使用构造器注入，在spring项目启动的时候，就会抛出：BeanCurrentlyInCreationException：Requested bean is currently in
> creation: Is there an unresolvable circular reference？从而提醒你避免循环依赖，
> 如果是field注入的话，启动的时候不会报错，在使用那个bean的时候才会报错。

> 小结使用构造器注入的好处:
>- 保证依赖不可变（final关键字）
>- 保证依赖不为空（省去了我们对其检查）
>- 保证返回客户端（调用）的代码的时候是完全初始化的状态
>- 避免了循环依赖
>- 提升了代码的可复用性

### @Autowired和@Resource以及@Inject等注解注入有何区别？

> Field injection is not recommended (字段注入是不被推荐的)

-

依赖识别方式：@Autowired默认是byType,可以配合使用@Qualifier指定Name;@Resource默认ByName如果找不到则ByType;@Inject是默认按照类型匹配的,如果需要按名称进行装配，则需要配合@Named,没有required属性

- 适用对象：@Autowired、@Inject可以对构造器、方法、参数、字段使用，@Resource只能对方法、字段使用
- 提供方：@Autowired是Spring提供的，@Resource是JSR-250提供的,@Inject是JSR330规范实现的

Field注入的缺点:

- 不能像构造器那样注入不可变的对象
- 依赖对外部不可见，外界可以看到构造器和setter，但无法看到私有字段，自然无法了解所需依赖
- 会导致组件与IoC容器紧耦合（这是最重要的原因，离开了IoC容器去使用组件，在注入依赖时就会十分困难）
- 导致单元测试也必须使用IoC容器，原因同上
- 依赖过多时不够明显，比如我需要10个依赖，用构造器注入就会显得庞大，这时候应该考虑一下此组件是不是违反了单一职责原则

> 为什么IDEA只对@Autowired警告???
> <br>
> @Autowired是Spring提供的，它是特定IoC提供的特定注解，这就导致了应用与框架的强绑定，一旦换用了其他的IoC框架，是不能够支持注入的。
> <br>
> 而@Resource是JSR-250提供的，它是Java标准，我们使用的IoC容器应当去兼容它，这样即使更换容器，也可以正常工作。

代替方案：
<br>
如果不使用@Autowired，我们还可以使用JDK提供的@Resource注解，可减少与Spring的耦合，使用一样简单，所以一样会有容易滥用的问题。
<br>
更推荐的方式是使用构造注入。当需要越多依赖的时候，构造参数越多，看起来很丑陋，我们可以使用Lombok来简化构造器注入。
<br>
Lombok提供了三个相关的注解来简化依赖注入：

1. @AllArgsConstructor 用来生成包含所有字段构的造方法；
2. @NoArgsConstructor 用来生成无参的构造方法；
3. @RequiredArgsConstructor 生成的构造方法只包含声明为final或者non-null的字段。