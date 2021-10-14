### springMVC03
#### 基于java文件注解方式构建springMVC，html页面
```
概要：
1.SpringWebConfig.java，springmvc配置类
2.WebInitializer.java，springmvc前端控制器，代替web.xml
3.RequestHandleController.java请求路径，请求方式，请求参数
4.ResponseHandleController.java
响应方式转发重定向，map手动转换json
5.UserController.java，map自动转换json
```
---
```
流程：
1.配置maven war包插件（忽略web.xml）
pom.xml中alt+/，insert plugin，输入war，选中war包插件
failOnMissingWebXml设为false 
2.maven update
3.添加tomcat
4.pom.xml添加项目依赖
5.添加springmvc配置类，SpringWebConfig.java
6.创建WebInitializer类配置springmvc前端控制器
```


