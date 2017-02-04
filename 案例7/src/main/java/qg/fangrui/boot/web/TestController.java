package qg.fangrui.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import qg.fangrui.boot.model.User;
import qg.fangrui.boot.service.UserService;

import javax.mail.internet.MimeMessage;
import java.io.File;

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
