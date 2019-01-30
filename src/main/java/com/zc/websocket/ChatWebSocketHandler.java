package com.zc.websocket;

import com.zc.model.Message;
import com.zc.model.User;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.*;

public class ChatWebSocketHandler implements WebSocketHandler {


    private static final Map<String, WebSocketSession> USER_SOCKET_MAP;

    static {
        USER_SOCKET_MAP = new HashMap<String, WebSocketSession>();
    }

    public ChatWebSocketHandler() {
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println("成功建立 socket 连接");
        newUserJoin(webSocketSession);
        String id = getUserId(webSocketSession);
        USER_SOCKET_MAP.put(id, webSocketSession);
        System.out.println("当前线上用户数量"+ USER_SOCKET_MAP.size());
    }

    public void newUserJoin(WebSocketSession webSocketSession) throws IOException {
        String username = getUsername(webSocketSession);
        String id = getUserId(webSocketSession);
        Message message = new Message();
        // 00 代表上线
        message.setCode("00");
        message.setId(id);
        message.setUsername(username);
        JsonHelper jm = new JsonHelper();
        for (WebSocketSession session : USER_SOCKET_MAP.values()) {
            TextMessage promptMsg = new TextMessage(jm.toJson(message));
            session.sendMessage(promptMsg);
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> webSocketMessage) throws Exception {
        sendMessageToAll(webSocketMessage, session);
        System.out.println("群发完毕");
    }

    public void sendMessageToAll(WebSocketMessage<?> message,WebSocketSession webSocketSession) throws IOException {
        String text = (String) message.getPayload();
        User user = (User) webSocketSession.getAttributes().get("user");
        user.setContext(text);
        JsonHelper jm = new JsonHelper();
        for (WebSocketSession session : USER_SOCKET_MAP.values()) {
            if (webSocketSession != session) {
                TextMessage promptMsg = new TextMessage(jm.toJson(user));
                session.sendMessage(promptMsg);
            }
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        System.out.println("socket 出现异常");

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        String id = getUserId(webSocketSession);
        USER_SOCKET_MAP.remove(id);
        Message message = new Message();
        message.setId(id);
        JsonHelper jm = new JsonHelper();
        message.setCode("01");
        for (WebSocketSession session : USER_SOCKET_MAP.values()) {
            TextMessage promptMsg = new TextMessage(jm.toJson(message));
            session.sendMessage(promptMsg);
        }
        System.out.println("下线执行完毕");
    }

    public String getUserId(WebSocketSession session) {
        return ((User) session.getAttributes().get("user")).getId();
    }

    public String getUsername(WebSocketSession session) {
        return ((User) session.getAttributes().get("user")).getUsername();
    }

    public static List<User> getOnlineUsers() {
        List<User> list = new ArrayList<>();
        for (WebSocketSession session : USER_SOCKET_MAP.values()) {
            User user = (User) session.getAttributes().get("user");
            list.add(user);
        }
        return list;
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
