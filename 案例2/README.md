## springboot 1.4.1.RELEASE + slf4j + log4j2

### 相应依赖 pom.xml
```xml
      <!--去掉springboot本身日志依赖-->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter</artifactId>
          <exclusions>
              <exclusion>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-starter-logging</artifactId>
              </exclusion>
          </exclusions>
      </dependency>

      <!--log4j2-->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-log4j2</artifactId>
      </dependency>
```

### log4j2的配置文件 log4j2.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--启动项设置为 trace，加载 springboot 启动内部各种详细输出-->
<Configuration status="trace">
    <Appenders>
        <!--添加一个控制台追加器-->
        <Console name="Console" target="SYSTEM_OUT" follow="true">
            <PatternLayout>
                <pattern>[%-5p] %d %c - %m%n</pattern>
            </PatternLayout>
        </Console>
        <!--添加一个文本追加器，文件位于根目录下，名为log.log-->
        <File name="File" fileName="log.log">
            <PatternLayout>
                <pattern>[%-5p] %d %c - %m%n</pattern>
            </PatternLayout>
        </File>
    </Appenders>
    <Loggers>
        <Logger name="com.github" level="debug" />
        <!--记录 qg.fangrui.boot 包及其子包 debug 及其以上的记录，并输出到文件中-->
        <Logger name="qg.fangrui.boot" level="debug">
            <!-- AppenderRef 可以控制文件输出对象-->
            <AppenderRef ref="File" />
        </Logger>
        <!--根记录全部输出到控制台上-->
        <Root level="debug">
            <AppenderRef ref="Console" />
        </Root>
    </Loggers>
</Configuration>
```

### application.properties 中的参数配置
logging.config=classpath:log4j2.xml

### 相应博客地址
spring boot 学习(六) : http://blog.csdn.net/u011244202/article/details/54730374