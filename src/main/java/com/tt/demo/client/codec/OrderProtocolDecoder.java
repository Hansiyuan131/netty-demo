package com.tt.demo.client.codec;

import com.tt.demo.common.RequestMessage;
import com.tt.demo.common.ResponseMessage;
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
public class OrderProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        // 对请求消息进行解码操作
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.decode(byteBuf);

        // 必须添加到list 否则无效
        list.add(responseMessage);
    }
}
