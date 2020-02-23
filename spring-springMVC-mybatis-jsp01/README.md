### spring-springMVC-mybatis-jsp01
#### springMVC，mvc模式的web轻量框架
```
汉堡王门店、订单增删改查
jsp-controller-dao-pojo-mapper.xml-jsp
```
```
概要：
1.引入jstl
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
2.el和jstl的标签语法
3.form submit提交，controller中能直接获得实体类对象
4.数据库字段door_id，pojo中属性doorId，mapper.xml中可以通过mysql语法door_id doorId给door_id设置别名，实现数据库door_id对pojo doorId的赋值
```
---
```
流程：
1.maven project-war
2.project视图生成web.xml
3.项目右键build path-add libs，添加tomcat，起服务器方法，手动点servers，右键启动
4.导入pom依赖
5.创建log4j.properties log4j配置
6.创建spring配置文件 applicationContext.xml
7.创建并配置 springMVC配置文件 applicationContext.xml
8.配置web.xml中
9.建mybatis-config配置文件

10.MybatisTest测试mybatis
11.SpringTest测试spring和mybatis结合
12.SpringMVCTest测试springmvc配置和ssm配置

13.jsp页面-controller方法-dao接口-mapper.xml sql语句-pojo实体类-jsp页面
```
