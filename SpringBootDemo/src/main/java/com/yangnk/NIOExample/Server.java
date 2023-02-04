package com.yangnk.NIOExample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class Server {
    final static int DEFAULT_PORT = 9000;
    final int port;
    Selector selector;

    public Server(int port) {
        this.port = port;
    }

    public Server() {
        this(DEFAULT_PORT);
    }

    public void start() {
        //创建ServerSocketChannel
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            //根据ServerSocketChannel创建ServerSocket
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress(this.port));
            //创建selector
            selector = Selector.open();
            //serverSocketChannel注册到selector中
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    handleEvent(selectionKey);
                    selectionKeyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleEvent(SelectionKey selectionKey) {
        SocketChannel client;
        //判断是否是建立连接事件
        if (selectionKey.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            try {
                client = serverSocketChannel.accept();
                if (client == null) {
                    return;
                }
                client.configureBlocking(false);
                //将channel注册到selector上
                client.register(selector, SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (selectionKey.isReadable()) {
            //处理读事件，通过ByteBuffer来接受数据
            client = (SocketChannel) selectionKey.channel();
            ByteBuffer recvBuffer = ByteBuffer.allocate(1024);
            recvBuffer.clear();
            try {
                int count = client.read(recvBuffer);
                if (count > 0) {
                    String recvMsg = new String(recvBuffer.array(), 0, count);
                    System.out.println("received client message is : " + recvMsg);
                }
                //向client发送写数据
                ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
                sendBuffer.clear();
                client = (SocketChannel) selectionKey.channel();
                String sendMsg = "hello, " + new Date().toString();
                sendBuffer.put(sendMsg.getBytes());
                sendBuffer.flip();
                client.write(sendBuffer);
                System.out.println("send client message is : " + sendMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
