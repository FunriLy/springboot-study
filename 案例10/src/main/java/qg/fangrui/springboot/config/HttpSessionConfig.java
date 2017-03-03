package qg.fangrui.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * spring session 配置
 * 用 spring session 的实现来支持代替 httpsession 的实现
 * Created by zggdczfr on 2017/3/3.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class HttpSessionConfig {
    /**
     * `@EnableRedisHttpSession` 这个注解创建了一个名为 springSessionRepositoryFilter
     * 的 bean，负责替换 httpSession,同由 redis 提供缓存支持。
     * 为了做到全部替换，我们要确保Servlet容器(Tomcat)对于某个请求都使用这个Filter,这个由SpringBoot负责。
     *
     * `maxInactiveIntervalInSeconds`:设置Session失效时间
     * 使用Redis Session之后，原Boot的server.session.timeout属性不再生效
     */
}
