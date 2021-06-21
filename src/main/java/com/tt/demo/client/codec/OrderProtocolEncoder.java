package com.tt.demo.client.codec;

import com.tt.demo.common.RequestMessage;
import com.tt.demo.common.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2021年06月19日 18:03
 */
public class OrderProtocolEncoder extends MessageToMessageEncoder<RequestMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, RequestMessage requestMessage, List<Object> list) throws Exception {
        // 分配ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        // 编码
        requestMessage.encode(buffer);
        // 添加到list
        list.add(buffer);
    }
}
