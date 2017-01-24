package qg.fangrui.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qg.fangrui.boot.model.User;
import qg.fangrui.boot.service.UserService;

/**
 * 测试 springboot+mybatis+druid 的 Controller
 * Created by zggdczfr on 2017/1/23.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String add(User user){
        return String.valueOf(userService.add(user));
    }

}
