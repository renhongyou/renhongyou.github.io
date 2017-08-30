使用mybatis访问数据库的步骤：

1. 至少添加对下列两个jar包的依赖（或直接引入）：
	mybatis-3.4.5.jar
	mysql-connector-java-5.1.40.jar

2. 添加mybatis-config.xml文件，应至少包含如下内容（多数据库同池连接）：
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
<!-- 引用外部资源文件 -->
  <properties resource=" ***properties文件路径*** "></properties>
  <environments default=" ***默认连接的数据库环境*** ">
  
    <environment id=" ***数据库环境1*** ">
      <transactionManager type="JDBC"/> <!-- 事务管理 -->
      <!-- 数据源 -->
      <dataSource type="POOLED"> <!-- 池化管理数据库连接 -->
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}***数据库名1***"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
    
    <environment id=" ***数据库环境2*** ">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}***数据库名2***"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
    
  </environments>
  <mappers>
    <mapper resource="***SqlMapper.xml路径***"/> <!-- 如果有多个应该写多个 -->
  </mappers>
</configuration>

3. 添加.properties文件，应至少包含如下内容：
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/
username=
password=
	
4. 编写xxxSqlMapper.xml，应至少包含如下内容（思想是通过id去找对应方法及参数）：
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.lanqiao.mybatis3.dao.IxxxDao">

<resultMap... id="..."></resultMap>
<select... id="..."></select>

</mapper>