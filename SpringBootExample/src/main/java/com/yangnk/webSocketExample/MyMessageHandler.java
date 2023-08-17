package com.yangnk.webSocketExample;

import javax.websocket.MessageHandler;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/16 10:30
 **/
public class MyMessageHandler implements MessageHandler {
    public interface Whole<T> extends MessageHandler {
        void onMessage(T var1);
    }

    public interface Partial<T> extends MessageHandler {
        void onMessage(T var1, boolean var2);
    }
}