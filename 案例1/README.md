## SpringBoot+MyBatis(xml)+Druid 

#### 前言
集合了我 SpringBoot+MyBatis+Druid 的学习案例！！！
仅供个人参考！

### 主要依赖
```xml
        <!-- Mybatis -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.1.1</version>
            <!-- 请不要使用1.0.0版本，因为还不支持拦截器插件 -->
        </dependency>
        <!-- druid阿里巴巴数据库连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.20</version>
        </dependency>
        <!-- MySql数据库驱动 -->
        <dependency>
            <groupId> mysql</groupId>
            <artifactId> mysql-connector-java</artifactId>
            <version> 5.0.5</version>
        </dependency>
```
### application.properties 配置
```xml
# 驱动配置信息
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.url = jdbc:mysql://127.0.0.1:3306/myboot?useUnicode=true&characterEncoding=utf-8
spring.datasource.username = root
spring.datasource.password = 123456
spring.datasource.driverClassName = com.mysql.jdbc.Driver

#连接池的配置信息
spring.datasource.initialSize=5
spring.datasource.minIdle=5
spring.datasource.maxActive=20
spring.datasource.maxWait=60000
spring.datasource.timeBetweenEvictionRunsMillis=60000
spring.datasource.minEvictableIdleTimeMillis=300000
spring.datasource.validationQuery=SELECT 1 FROM DUAL
spring.datasource.testWhileIdle=true
spring.datasource.testOnBorrow=false
spring.datasource.testOnReturn=false
spring.datasource.poolPreparedStatements=true
spring.datasource.maxPoolPreparedStatementPerConnectionSize=20
spring.datasource.filters=stat,wall,log4j
spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000

# MyBatis 配置
mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.type-aliases-package=qg.fangrui.boot.model
```
还有，MyBatis在SpringBoot中的参数配置
*   mybatis.mapper-locations：xml文件扫描位置
*   mybatis.type-aliases-package：Model包扫描位置
*   mybatis.config：mybatis-config.xml配置文件的路径
*   mybatis.typeHandlersPackage：扫描typeHandlers的包
*   mybatis.checkConfigLocation：检查配置文件是否存在
*   mybatis.executorType：设置执行模式（`SIMPLE, REUSE, BATCH`），默认为`SIMPLE`


### 相应博客地址
spring boot 学习(五) : http://blog.csdn.net/u011244202/article/details/54709060