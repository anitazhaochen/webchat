package com.zc.websocket;

import com.zc.model.User;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class ChatHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        System.out.println("websocket before Handshake!!");
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                User user = (User) session.getAttribute("user");
                System.out.println("websokcet before "+ user.getUsername());
                if (session != null) {
                    map.put("user", user);
                }
            }

        }

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
