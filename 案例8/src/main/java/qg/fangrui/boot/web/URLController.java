package qg.fangrui.boot.web;

import com.sun.net.httpserver.Authenticator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import qg.fangrui.boot.aop.RequestLimit;
import qg.fangrui.boot.aop.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zggdczfr on 2017/1/26.
 */
@Controller
public class URLController {
    @Token(save = true, remove = true)
    @RequestLimit(count=10,time=5000)
    @RequestMapping("/urltest")
    @ResponseBody
    public String test(HttpServletRequest request, ModelMap modelMap, HttpServletResponse response) {
        return "aaa";
    }

    @Token(save = true)
    @RequestMapping("/savetoken")
    @ResponseBody
    public String getToken(HttpServletRequest request, HttpServletResponse response){
        return (String) request.getSession().getAttribute("token");
    }

    @Token(remove = true)
    @RequestMapping("/removetoken")
    @ResponseBody
    public String removeToken(HttpServletRequest request, HttpServletResponse response){
        return "success";
    }

    @RequestMapping("/url/test")
    @ResponseBody
    public String URLtest() {
        return "success";
    }
}