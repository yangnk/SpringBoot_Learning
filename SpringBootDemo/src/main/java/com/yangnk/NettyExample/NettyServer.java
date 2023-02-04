package com.yangnk.NettyExample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class NettyServer {
    private static String IP = "127.0.0.1";
    private static int port = 9000;
    private static final EventLoopGroup bossGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() * 2);
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup(100);

    private static void init() {
        //创建ServerBootStrap
        ServerBootstrap bootstrap = new ServerBootstrap();
        //关联EventLoopGroup
        bootstrap.group(bossGroup, workerGroup);
        //关联channel
        bootstrap.channel(NioServerSocketChannel.class);

        bootstrap.childHandler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                //配置pipeline
                ChannelPipeline pipeline = channel.pipeline();
                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                pipeline.addLast(new LengthFieldPrepender(4));
                pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                pipeline.addLast(new NettyServerHandler());
            }
        });

        //channel返回的处理
        try {
            ChannelFuture channelFuture = bootstrap.bind(IP, port).sync();
            channelFuture.addListener((ChannelFutureListener) channelFuture1 -> {
                System.out.println("complete connected.");
            });
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NettyServer.init();
    }
}
