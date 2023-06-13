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
   <br>在spring项目中，将对象理解为Bean，也可以叫bean对象，这个bean和容器之间有个依赖关系，bean对象的创建是依赖容器的，就好像孩子依赖父母一样，孩子不能自己生出自己，需要父母的合作才能出生，这里的孩子就是bean，父母就是容器
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
