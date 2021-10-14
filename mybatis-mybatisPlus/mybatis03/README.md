### mybatis03
#### xml/java配置SqlSessionFactory，命名空间/接口/注解方式访问数据库
```
mybatis的缓存，提高查询速度
一级缓存SqlSession级缓存，不能共享
二级缓存，不同SqlSession间
```
```
概要：
1.TestBaseWithJava.java java配置SqlSessionFactory
2.TestBaseWithXml.java xml配置SqlSessionFactory
3.TestCompanyDao01.java xml配置SqlSessionFactory，命名空间方式访问数据库
4.TestCompanyDao02.java xml配置SqlSessionFactory，接口方式访问数据库
5.TestCompanyDao03.java java配置SqlSessionFactory，注解方式访问数据库。java配置SqlSessionFactory，接口方式访问数据库
6.TestCahce01.java 测一级缓存，同一SqlSession间。测二级缓存，不同SqlSession间
```
---
```
流程：
1.参照之前项目
```