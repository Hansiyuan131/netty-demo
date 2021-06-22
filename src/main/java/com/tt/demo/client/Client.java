package com.tt.demo.client;

import com.tt.demo.client.codec.TvFrameDecoder;
import com.tt.demo.client.codec.TvFrameEncoder;
import com.tt.demo.client.codec.TvProtocolDecoder;
import com.tt.demo.client.codec.TvProtocolEncoder;
import com.tt.demo.common.RequestMessage;
import com.tt.demo.common.tv.TvOperation;
import com.tt.demo.util.IdUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

/**
 * @author hansiyuan
 * @date 2021年06月21日 18:52
 */
public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        /*
         * Netty 服务器端创建
         *  1. ServerBootstrap
         */
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

        bootstrap.group(new NioEventLoopGroup());

        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                ChannelPipeline pipeline = nioSocketChannel.pipeline();
                pipeline.addLast(new TvFrameDecoder());
                pipeline.addLast(new TvFrameEncoder());
                pipeline.addLast(new TvProtocolEncoder());
                pipeline.addLast(new TvProtocolDecoder());
                pipeline.addLast(new LoggingHandler(LogLevel.INFO));
            }
        });
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8090).sync();

        RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), new TvOperation(1001, "tudou"));

        channelFuture.channel().writeAndFlush(requestMessage);

        channelFuture.channel().closeFuture().get();
    }
}
