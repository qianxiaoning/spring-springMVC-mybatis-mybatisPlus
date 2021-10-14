### mybatis01
#### xml配置SqlSessionFactory，命名空间方式访问数据库
```
概要：
1.mapper namespace为mapper文件名
<mapper namespace="EmpMapper">
2.TestMybatis1.java中调用namespace.方法id
int rows = session.update("EmpMapper.insert");
Emp emp = session.selectOne("EmpMapper.findById",5);
List<Emp> list = session.selectList("EmpMapper.findAll2",map);
```
---
```
流程：
1.maven project
2.pom依赖
3.mybatis-config.xml 数据库配置，导入mapper文件
<mapper resource="EmpMapper.xml"/>
4.jdbc.properties
5.log4j.properties
6.创建EmpMapper.xml文件注明namespace
<mapper namespace="EmpMapper"></mapper>
7.Emp pojo
8.TestMybatis1.java session.selectList("EmpMapper.findAll");
9.EmpMapper.xml写入sql标签和id
<select id="findAll" resultType="com.qxn.pojo.Emp">
	select * from emp
</select>
```