## springboot 1.4.1.RELEASE + Redis + SpringSession(实现多账户)

### SpringBoot 缓存
在 Spring Boot中，通过`@EnableCaching`注解自动化配置合适的缓存管理器（CacheManager），Spring Boot根据下面的顺序去侦测缓存提供者：
*   Generic
*   JCache (JSR-107)
*   EhCache 2.x
*   Hazelcast
*   Infinispan
*   Redis
*   Guava
*   Simple


### 相应依赖 pom.xml
```xml
      <!-- 缓存依赖 -->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-cache</artifactId>
      </dependency>
      <!-- spring boot redis 依赖 -->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-redis</artifactId>
      </dependency>
      <!-- spring session -->
      <dependency>
          <groupId>org.springframework.session</groupId>
          <artifactId>spring-session-data-redis</artifactId>
      </dependency>
```

### application.properties 配置
```xml
# Redis 配置(默认配置)
# Redis 数据库索引（默认为0）
spring.redis.database=0
# Redis 服务器地址
spring.redis.host=localhost
# Redis 服务器端口
spring.redis.port=6379
# Redis 服务器密码(默认为空)
spring.redis.password=
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.pool.max-active=8
# 连接池中的最大空闲连接
spring.redis.pool.max-idle=8
# 连接池中的最小空闲连接
spring.redis.pool.min-idle=0
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.pool.max-wait=-1
# 设置连接超时
spring.redis.timeout=0
```

### SpringBoot 中的缓存注解
在支持 Spring Cache 的环境下，
*  `@EnableCaching` : 开启SpringBoot缓存策略，放在启动主类。
*  `@CacheConfig(cacheNames = "XXX")` : 设置一个名为"XXX"的缓存空间。
*  `@Cacheable` : Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
*  `@CacheEvict` : 清除缓存。
*  `@CachePut` : `@CachePut`也可以声明一个方法支持缓存功能。使用`@CachePut`标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。

### SpringSession 原理解释
`@EnableRedisHttpSession` 这个注解创建了一个名为 springSessionRepositoryFilter 的 bean，负责替换 httpSession,同时由 redis 提供缓存支持。
`maxInactiveIntervalInSeconds`:设置Session失效时间。使用Redis Session之后，原Boot的server.session.timeout属性不再生效

### 相应博客地址
spring boot 学习(十四) : http://blog.csdn.net/u011244202/article/details/60154444