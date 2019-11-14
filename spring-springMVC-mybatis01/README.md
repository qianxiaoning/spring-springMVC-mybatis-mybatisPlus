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
1.创建maven war项目
2.生成web.xml文件：切换project explorer视图，deployment descriptor（部署描述符）右击，generate...生成部署描述符
3.建/WEB-INF/pages/hello.jsp，WEB-INF/下不能直接访问，通过转发访问
4.添加tomcat，右键项目-build path-add libraries...-server runtime
5.直接复制pom依赖

6.web.xml中配置前端控制器（指定配置文件，拦截除jsp请求），ctrl+shift+h，输入类名查类全路径
7.新建springmvc-config.xml文件
8.添加springmvc-config.xml配置（放行静态资源，注解驱动，包扫描路径，视图解析器添加前后缀）

9.创建书写HelloController.java
10.创建User pojo，测试对象传参 
11.创建form.html，用它发起post请求测试post乱码问题
12.在web.xml中加入过滤器解决乱码问题
13.在HelloController.java中使用model，在hello.jsp展现
```
