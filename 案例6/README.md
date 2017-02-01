## springboot 1.4.1.RELEASE 发送文本邮件、html邮件、带附件邮件、带静态资源邮件、引擎模板邮件

### 相应依赖 pom.xml
mail邮件依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```
引擎模板依赖：从 SpringBoot 1.4 开始，暂时只支持 FreeMaker 引擎模板发送邮件
```xml
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-freemarker</artifactId>
      </dependency>
```

### application.properties 中的参数配置
```xml
# JavaMailSender 邮件发送的配置
spring.mail.host=smtp.163.com
spring.mail.username=用户163邮箱
spring.mail.password=邮箱密码
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
```

### 关于使用QQ邮箱的问题(具体参考博客说明)
1. application.properties 中的参数配置：
spring.mail.host=smtp.qq.com
spring.mail.password=QQ邮箱**授权码**
2. JDK版本问题
SpringBoot只支持JDK1.8，但会影响到QQ邮箱要求的配置。
因为JDK1.8中`jre\lib\security`中两个 jar 包替换的缘故。将下载后的`local_policy.jar`和`US_export_policy.jar`替换到JDK1.8的`jre\lib\security`文件夹即可。
地址：http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html

### 相应博客地址
spring boot 学习(十) : http://blog.csdn.net/u011244202/article/details/54809696