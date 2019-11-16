### spring-springMVC-mybatis01
#### springMVC，mvc模式的web轻量框架
```
一种分层架构思想，按职责各司其职。获取参数、响应请求，分离了控制器、模型对象、过滤器等
c控制器：接收请求，调用业务类，派发页面(@Controller)
m模型：service，dao，pojo，返回处理结果(@Service)
v视图：视图渲染(jsp,html)
```
```
概要：
1.@Controller
申明控制层
2.@RequestMapping("/showJsp")
匹配路径
3.return "forward:/showJsp";
转发
4.return "redirect:/showJsp";
重定向
5.(Model model) model.addAttribute("list",list);
放入Model
6.@ResponseBody
返回json
```
---
```
流程：
maven project-war
project视图生成web.xml
项目右键build path-add libs，添加tomcat
导入pom依赖
创建log4j.properties log4j配置
创建spring配置文件 applicationContext.xml
创建并配置 springMVC配置文件 applicationContext.xml
配置web.xml中
创建springMVCTest.html
建SpringMVCTest测试类
自己推测整合mybatis
```
