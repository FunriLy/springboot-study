package qg.fangrui.boot.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zggdczfr on 2017/1/28.
 */
@Component
public class ScheduledTasks {

    //输出时间格式
    private static final SimpleDateFormat format = new SimpleDateFormat("HH(hh):mm:ss S");

    @Scheduled(initialDelay = 8000, fixedRate = 5000)
    public void firstScheduledTasks(){
        System.out.println("定时任务执行，现在时间是 : "+format.format(new Date()));
    }
}
