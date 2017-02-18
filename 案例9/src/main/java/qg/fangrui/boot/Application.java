package qg.fangrui.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * Created by zggdczfr on 2016/9/29.
 * Spring Boot主类
 * //@EnableScheduling   //开启定时任务
 * //@EnableAsync        //开启异步任务
 * //@EnableCaching      //开启缓存
 */
@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}