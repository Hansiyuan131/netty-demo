package com.tt.demo.server.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 编码
 *
 * @author hansiyuan
 * @date 2021年06月19日 18:01
 */
public class OrderFrameEncoder extends LengthFieldPrepender {
    public OrderFrameEncoder() {
        super(2);
    }
}
