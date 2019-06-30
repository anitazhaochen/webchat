package com.zc.web.controller;

import com.zc.model.User;
import com.zc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;


//@RestController //声明 Rest 风格的控制器
@Controller
@EnableAutoConfiguration // 自动配置，相当于写了 spring 的配置文件
// @RequestMapping("user")
public class UserController {

    @RequestMapping("{id}")
    @ResponseBody
    public User userinfo(@PathVariable("id") String id) {
        User user = new User("zc", "123");
        user.setId(id);
        return user;
    }

    @Autowired
    private IUserService userService;
    @RequestMapping("register")
    @ResponseBody
    public String register(String username, String password) {
        userService.register(username, password);
        return "success";
    }

    @RequestMapping("find")
    @ResponseBody
    public User find(String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String uuid = UUID.randomUUID().toString();
        request.getSession().setAttribute("uuid",uuid);
        System.out.println("进入登录页面");
        return "login";
    }

    @RequestMapping("session")
    @ResponseBody
    public String session(Model model, HttpSession httpSession, String username) {
        System.out.println("请求到了 session");
        httpSession.setAttribute("user", new User(username));
        return username;
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request, HttpServletResponse response) {

        return "index";

    }

}
