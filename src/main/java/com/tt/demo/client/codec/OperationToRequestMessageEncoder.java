package com.tt.demo.client.codec;

import com.tt.demo.common.Operation;
import com.tt.demo.common.RequestMessage;
import com.tt.demo.util.IdUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2021年06月21日 19:14
 */
public class OperationToRequestMessageEncoder extends MessageToMessageEncoder<Operation> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Operation operation, List<Object> list) throws Exception {
        RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), operation);
        list.add(requestMessage);
    }
}
