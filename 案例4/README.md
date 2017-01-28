## SpringBoot 利用 `@Scheduled` 创建定时任务

### 创建一个 Spring Boot 项目
**要注意，SpringBoot 项目需要 JDK8 的编译环境！**
*  (自动完成初始化)http://blog.csdn.net/u011244202/article/details/54767036
*  (手动完成初始化)http://blog.csdn.net/u011244202/article/details/54604421

### 实现步骤
1. 在项目主类中加入`@EnableScheduling`注解
2. 创建定时任务实现类，注意加上注解`@Scheduled`

### 注意：
**cron、fixedDelay、fixedRate 三者之间不能共存！！！**

### 官方文档
*  实例文档 : http://spring.io/guides/gs/scheduling-tasks/
*  注解文档 : http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/Scheduled.html

### 相应博客地址
spring boot 学习(八) : http://blog.csdn.net/u011244202/article/details/54767268