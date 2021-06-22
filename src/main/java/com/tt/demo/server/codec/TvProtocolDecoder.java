package com.tt.demo.server.codec;

import com.tt.demo.common.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * 二次解码 ByteBuf -> RequestMessage
 *
 * @author hansiyuan
 * @date 2021年06月19日 17:34
 */
public class TvProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        // 对请求消息进行解码操作
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.decode(byteBuf);

        // 必须添加到list 否则无效
        list.add(requestMessage);
    }
}
