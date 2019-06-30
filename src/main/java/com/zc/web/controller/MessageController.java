package com.zc.web.controller;

import com.zc.model.Message;
import com.zc.model.User;
import com.zc.service.impl.MessageServiceImpl;
import com.zc.websocket.ChatWebSocketHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

//@Controller
//@EnableAutoConfiguration
//@RequestMapping("chat")
public class MessageController {

//    @RequestMapping("{username}")
//    public String userIndex(@PathVariable("username") User user, Model model, HttpServletRequest request) {
//        String uuid = UUID.randomUUID().toString();
//        user.setId(uuid);
//        request.getSession().setAttribute("user", user);
//        List<User> list = ChatWebSocketHandler.getOnlineUsers();
//        model.addAttribute("users", list);
//        model.addAttribute("myself", user.getUsername());
//        //System.out.println("index执行了");
//        return "chat/chatroom";
//    }

//    @ResponseBody
//    public Map<String, Object> receiveMessage(Message message) {
//        MessageServiceImpl messageService = new MessageServiceImpl();
//        messageService.save(message);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("code", 0);
//        return map;
//    }
}
