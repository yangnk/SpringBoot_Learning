package com.yangnk.NIOExample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//建立连接-->进行处理
public class Client {
    private final String serverPort;
    private final int serverHost;
    private Selector selector;
    private SelectionKey selectionKey;
    private ExecutorService service = Executors.newCachedThreadPool();
    private SocketChannel client;


    public Client(String serverPort, int serverHost) {
        this.serverPort = serverPort;
        this.serverHost = serverHost;
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 9000);
        client.connect();
        client.sendMsg();
    }

    private void sendMsg() {
        try {
            if (!client.finishConnect()) {
                throw new Error();
            }

            ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
            sendBuffer.clear();
            sendBuffer.put("hello server.".getBytes());
            sendBuffer.flip();
            client.write(sendBuffer);
            if (selectionKey != null) {
                selectionKey.interestOps(SelectionKey.OP_READ);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        //获取socket-->设置selector-->发起连接
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            selector = Selector.open();
            selectionKey = socketChannel.register(selector, 0);
            boolean connected = socketChannel.connect(new InetSocketAddress(serverPort, serverHost));
            if (!connected) {
                selectionKey.interestOps(SelectionKey.OP_CONNECT);
            }
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            SelectionKey selectionKey = iterator.next();

            iterator.remove();
            int readyOps = selectionKey.readyOps();
            if ((readyOps & SelectionKey.OP_CONNECT) != 0) {
                client = (SocketChannel) selectionKey.channel();
            }
            service.execute(this::handle);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handle() {
        //获取SocketChannel-->读取数据
        try {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            if (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                int readyOps = selectionKey.readyOps();
                if ((readyOps & SelectionKey.OP_CONNECT) != 0) {
//                    client = (SocketChannel) selectionKey.channel();
                } else if ((readyOps & SelectionKey.OP_READ) != 0) {
                    client = (SocketChannel) selectionKey.channel();
                    ByteBuffer recvBuffer = ByteBuffer.allocate(1024);
                    recvBuffer.clear();
                    int count = client.read(recvBuffer);
                    if (count > 0) {
                        String recvMsg = new String(recvBuffer.array(), 0, count);
                        System.out.println("received server message is : " + recvMsg);
                    }
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
