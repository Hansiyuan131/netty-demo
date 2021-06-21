package com.tt.demo.server.handler;

import com.tt.demo.common.Operation;
import com.tt.demo.common.OperationResult;
import com.tt.demo.common.RequestMessage;
import com.tt.demo.common.ResponseMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hansiyuan
 * @date 2021年06月19日 18:05
 */
public class OrderServerProcessHandler extends SimpleChannelInboundHandler<RequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage requestMessage) throws Exception {
        Operation operation = requestMessage.getMessageBody();
        OperationResult operationResult = operation.execute();
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessageHeader(requestMessage.getMessageHeader());
        responseMessage.setMessageBody(operationResult);
        ctx.writeAndFlush(responseMessage);
    }
}
