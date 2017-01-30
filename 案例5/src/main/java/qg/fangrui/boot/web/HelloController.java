package qg.fangrui.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qg.fangrui.boot.aop.RequestLimit;

import javax.servlet.http.HttpServletRequest;

/**
 * 第一个 Spring Boot 项目学习
 * Created by zggdczfr on 2017/1/15.
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    @RequestLimit(count = 10)
    public String hello(HttpServletRequest request) {
        return "Hello World";
    }

}