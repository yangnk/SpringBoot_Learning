package com.yangnk.webSocketExample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/15 00:31
 **/

/**
 * @ServerEndpoint 注解的作用
 *
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocketServer {

    /**
     * 与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;

    /**
     * 标识当前连接客户端的用户名
     */
    private String name;

    /**
     * 用于存所有的连接服务的客户端，这个对象存储是安全的
     * 注意这里的kv,设计的很巧妙，v刚好是本类 WebSocket (用来存放每个客户端对应的MyWebSocket对象)
     */
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();


    /**
     * 连接建立成功调用的方法
     * session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "name") String name){

        log.info("----------------------------------");
        this.session = session;
        this.name = name;
        // name是用来表示唯一客户端，如果需要指定发送，需要指定发送通过name来区分
        webSocketMap.put(name,this);
        log.info("[WebSocket] 连接成功，当前连接人数为：={}", webSocketMap.size());
        GroupSending(name+" 来了");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void OnClose(){
        webSocketMap.remove(this.name);
        log.info("[WebSocket] 退出成功，当前连接人数为：={}", webSocketMap.size());
        GroupSending(name+" 走了");
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void OnMessage(String message_str){
        log.info("[WebSocket] 收到消息：{}",message_str);
        //判断是否需要指定发送，具体规则自定义
        //message_str的格式 TOUSER:user2;message:aaaaaaaaaaaaaaaaaa;
        if(message_str.indexOf("TOUSER") == 0){
            //取出 name和message的值
            String[] split = message_str.split(";");
            String[] split1 = split[0].split(":");
            String[] split2 = split[1].split(":");
            String name = split1[1];
            String message = split2[1];
            //指定发送
            AppointSending(name,message);
        }else{
            //群发
            GroupSending(message_str);
        }
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        log.info("发生错误");
        error.printStackTrace();
    }

    /**
     * 群发
     * @param message
     */
    public void GroupSending(String message){
        for (String name : webSocketMap.keySet()){
            try {
                webSocketMap.get(name).session.getBasicRemote().sendText(name + ":" + message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 指定发送
     * @param name
     * @param message
     */
    public void AppointSending(String name,String message){
        try {
            webSocketMap.get(name).session.getBasicRemote().sendText(name + ":" + message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}