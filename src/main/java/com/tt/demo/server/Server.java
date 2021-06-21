package com.tt.demo.server;

import com.tt.demo.server.codec.OrderFrameDecoder;
import com.tt.demo.server.codec.OrderFrameEncoder;
import com.tt.demo.server.codec.OrderProtocolDecoder;
import com.tt.demo.server.codec.OrderProtocolEncoder;
import com.tt.demo.server.handler.OrderServerProcessHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import javafx.print.PageLayout;

/**
 * @author hansiyuan
 * @date 2021年06月21日 15:42
 */
public class Server {
    public static void main(String[] args) {

        /*
         * Netty 服务器端创建
         *  1. ServerBootstrap
         */
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);


        serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            serverBootstrap.group(group);
            serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                    ChannelPipeline pipeline = nioSocketChannel.pipeline();
                    pipeline.addLast(new OrderFrameDecoder());
                    pipeline.addLast(new OrderFrameEncoder());
                    pipeline.addLast(new OrderProtocolEncoder());
                    pipeline.addLast(new OrderProtocolDecoder());
                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                    pipeline.addLast(new OrderServerProcessHandler());
                }
            });
            ChannelFuture channelFuture = serverBootstrap.bind(8090).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception ignored) {
        } finally {
            group.shutdownGracefully();
        }
    }
}
