package qg.fangrui.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qg.fangrui.boot.task.Task;

/**
 * 异步任务控制器
 * 开启一个控制器来执行三个不存在依赖关系的任务
 * Created by zggdczfr on 2017/2/4.
 */
@Controller
public class TaskController {

    @Autowired
    private Task TASK;

    @ResponseBody
    @RequestMapping("/task")
    public String task() throws Exception {
        System.out.println("开始执行Controller任务");
        long start = System.currentTimeMillis();
        TASK.doTaskOne();
        TASK.doTaskTwo();
        TASK.doTaaskThree();
        long end = System.currentTimeMillis();
        System.out.println("完成Controller任务，耗时：" + (end - start) + "毫秒");
        return "success";
    }
}
