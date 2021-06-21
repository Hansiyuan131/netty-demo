package com.tt.demo.client.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 订单数据结构解码器（Frame -> 防止粘包/半包问题）
 *
 * @author hansiyuan
 * @date 2021年06月19日 17:22
 */
public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {
    public OrderFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
