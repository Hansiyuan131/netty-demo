package com.tt.demo.client.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 编码
 *
 * @author hansiyuan
 * @date 2021年06月19日 18:01
 */
public class TvFrameEncoder extends LengthFieldPrepender {
    public TvFrameEncoder() {
        super(2);
    }
}
