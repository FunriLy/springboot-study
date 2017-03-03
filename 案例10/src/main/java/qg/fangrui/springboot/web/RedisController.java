package qg.fangrui.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qg.fangrui.springboot.model.User;
import qg.fangrui.springboot.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zggdczfr on 2017/2/28.
 */
@RestController
public class RedisController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Object getSession(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SessionId", request.getSession().getId());
        map.put("ServerPort", "服务端口号为 "+port);
        return map;
    }

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public String redisTest(){
        System.out.println("====== 进行 Redis 缓存试验 ======");
        User user = new User();
        //生成第一个用户的唯一标识符 UUID
        String u1_uuid = UUID.randomUUID().toString();
        //去掉 UUID 的 - 符号
        String uuid1 = u1_uuid.substring(0,8)+u1_uuid.substring(9,13)+u1_uuid.substring(14,18)+u1_uuid.substring(19,23)+u1_uuid.substring(24);
        user.setUuid(uuid1);
        user.setAge(20);
        user.setName("张三");

        try {
            userService.save(user);
        } catch (Exception e) {
            System.out.println("保存用户出现异常");
        }

        //第一次查询
        System.out.println(userService.findByUuid(user.getUuid()));
        //通过缓存查询
        System.out.println(userService.findByUuid(user.getUuid()));

        System.out.println("====== 修改 Redis 缓存数据 ======");
        //修改用户数据
        user.setAge(18);
        user.setName("李四");
        System.out.println(userService.update(user));

        System.out.println(userService.findByUuid(user.getUuid()));

        return "success";
    }
}
