package qg.fangrui.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by zggdczfr on 2016/9/29.
 * Spring Boot主类
 */
@SpringBootApplication
@EnableScheduling   //开启定时任务
@EnableAsync        //开启异步任务
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}