package com.tt.demo.server.codec;

import com.tt.demo.common.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2021年06月19日 18:03
 */
public class OrderProtocolEncoder extends MessageToMessageEncoder<ResponseMessage> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ResponseMessage responseMessage, List<Object> list) throws Exception {
        // 分配ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        // 编码
        responseMessage.encode(buffer);
        // 添加到list
        list.add(buffer);
    }
}
