package qg.fangrui.boot.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Spring Boot 定时任务
 * Created by zggdczfr on 2017/1/28.
 */
@Component
public class ScheduledTasks {

    //输出时间格式
    private static final SimpleDateFormat format = new SimpleDateFormat("HH(hh):mm:ss S");

    /**
     * initialDelay 在第一次执行fixedRate（）或fixedDelay（）任务之前延迟
     * fixedRate 上一次开始执行时间点之后执行
     * fixedDelay 上一次执行完毕时间点之后执行
     * cron cron表达式
     * zone 表示解析cron表达式的时区
     */
    //项目启动后延迟 8s 执行第一次定时任务，然后每隔 5s 执行定时任务
    //@Scheduled(initialDelay = 8000, fixedRate = 5000)
    public void firstScheduledTasks(){
        System.out.println("定时任务执行，现在时间是 : "+format.format(new Date()));
    }
}
