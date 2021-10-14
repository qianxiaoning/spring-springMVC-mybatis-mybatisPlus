### mybatis02
#### xml配置SqlSessionFactory，接口方式访问数据库
```
概要：
1.mapper namespace为mapper接口全路径
<mapper namespace="com.qxn.dao.EmpMapper">
2.TestMybatis1.java中session获取mapper接口，调接口方法
EmpMapper empMapper = session.getMapper(EmpMapper.class);
List<Emp> list = empMapper.findAllEmp();
Emp emp = empMapper.findEmpById(1);
int rows = empMapper.insertEmp(emp);
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
<mapper namespace="mapper接口全路径"></mapper>
7.Emp pojo
8.TestMybatis1.java List<Emp> list = empMapper.findAllEmp();
9.EmpMapper.java接口中生成方法 List<Emp> findAllEmp();
10.EmpMapper.xml写入sql标签
<select id="findAllEmp" resultType="com.qxn.pojo.Emp">
	select * from emp;
</select>
```