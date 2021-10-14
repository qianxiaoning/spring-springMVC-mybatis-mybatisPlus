### spring02
```
概要：
1.
SpringConfig.java 配置类，确定扫描路径
ReadBeans.java 读取到的容器

2.
DataSourceConfig.java 第三方数据库（DRUID,HiKariCP）驱动对象
TestDataSource.java 测试数据库驱动对象
//@Bean里可以指定名字，开始和销毁的方法
@Bean(value="druid",initMethod="init",destroyMethod="close")

3.
InterfaceA.java 接口A
ImplementsA.java 实现类A，延迟加载
TestImplementsA.java 测试实现类A，读取容器，从容器池中取对象

4.
ImplementsB.java 实现类B，@Component("implementsB")指定bean名
ServiceInterface.java ServiceA接口
ServiceA.java ServiceA自动注入了实现类A，@Qualifier("implementsA")指定注入对象
TestServiceA.java 测试ServiceA对象
```
---
```
流程：
1.maven project，jar
2.pom依赖
```