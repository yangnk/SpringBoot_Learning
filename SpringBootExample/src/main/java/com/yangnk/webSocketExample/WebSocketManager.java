package com.yangnk.webSocketExample;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/16 14:49
 **/
public class WebSocketManager {
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
}