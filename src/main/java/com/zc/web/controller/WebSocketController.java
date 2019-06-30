package com.zc.web.controller;

import com.zc.model.User;
import com.zc.websocket.ChatWebSocketHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@EnableAutoConfiguration
@RequestMapping("chat")
public class WebSocketController {


    @RequestMapping("{username}")
    public String loginPage(@PathVariable("username") User user, Model model , HttpServletRequest request) {
        if ((String)request.getSession().getAttribute("sharecode") == null){
            String sharecode = UUID.randomUUID().toString().replaceAll("-", "");
            request.getSession().setAttribute("sharecode", sharecode);
        }
        System.out.println("1111111111");
        System.out.println(((User)request.getSession().getAttribute("user")).getId());
        System.out.println("1111111111");
        if (((User) request.getSession().getAttribute("user")).getId() == null){
            System.out.println("22222222222");
            String uuid = UUID.randomUUID().toString();
            user.setId(uuid);
            request.getSession().setAttribute("user", user);
        }
        List<User> list = ChatWebSocketHandler.getOnlineUsers();
        User removeUser = null;
        for (User user1: list) {
            if (user1.getId().equals(((User) request.getSession().getAttribute("user")).getId())) {
                removeUser = user1;
            }
        }
        list.remove(removeUser);
        model.addAttribute("users", list);

        model.addAttribute("myself", user.getUsername());
        return "chat/chatroom";
    }

    @RequestMapping("/ws/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return "websocket/send";
    }
}
