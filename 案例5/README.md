## springboot 1.4.1.RELEASE 集合 自定义注解+拦截器 ?秒防刷新

### 前景介绍
所谓的?秒防刷新，其实就是限制用户在某个时间内对某个 Controller 的访问时间限制。最常见的，比如学校教务系统(正方)的3s防刷新。

### 相应依赖 pom.xml
```xml
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-aop</artifactId>
      </dependency>
```

### application.properties 中的参数配置
无(默认配置即可)

### 相应博客地址
spring boot 学习(九) : http://blog.csdn.net/u011244202/article/details/54783337