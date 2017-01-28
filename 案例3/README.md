## springboot 1.4.1.RELEASE 集合 自定义注解+拦截器 解决表单重复提交

### 防止情况
1. 不通过正常路径访问页面表单；
2. session 失效情况下提交表单；
3. 短时间内不止一次提交表单。

### 解决思路
1. 网页点击事件，网页提交发送申请；
2. 服务器收到申请，并产生令牌(Token)，并存于 Session 中；
3. 服务器将令牌返回给页面，页面将令牌与表单真正提交给服务器。

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
spring boot 学习(七) : http://blog.csdn.net/u011244202/article/details/54744996