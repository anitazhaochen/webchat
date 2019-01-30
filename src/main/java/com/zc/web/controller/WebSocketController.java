package com.zc.web.controller;

import com.zc.websocket.ChatWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebSocketController {


    @RequestMapping("/ws/lginPage")
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {
        return "/ws/login";
    }

    @RequestMapping("/ws/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return "websocket/send";
    }
}
