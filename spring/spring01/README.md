### spring01
#### 通过配置文件中的<bean>标签，将对象交给spring管理
```
概要：
1.<bean id="beanName" class="类的全路径">
```
---
```
流程：
1.maven project
2.pom依赖
3.pojo类
4.applicationContext.xml配置文件配置bean对象
5.SpringTest类读取配置，获取bean对象
```