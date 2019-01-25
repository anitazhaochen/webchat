package com.zc.web.controller;

import com.zc.model.Message;
import com.zc.service.impl.MessageServiceImpl;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("chat")
public class MessageController {

    @RequestMapping("{username}")
    public String userIndex(@PathVariable("username") String username, Model model) {
        model.addAttribute("username", username);
        System.out.println("index执行了");
        return "chat/chatroom";
    }

    @RequestMapping("reveive")
    @ResponseBody
    public Map<String, Object> receiveMessage(Message message) {
        MessageServiceImpl messageService = new MessageServiceImpl();
        messageService.save(message);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        return map;
    }
}
