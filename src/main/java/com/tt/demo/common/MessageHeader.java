package com.tt.demo.common;

import lombok.Data;

/**
 * 业务数据结构 Frame = length + message
 * message = MessageHeader + MessageBody
 *
 * @author hansiyuan
 * @date 2021年06月19日 16:13
 */
@Data
public class MessageHeader {
    private int version = 1;
    private int opCode;
    private long streamId;
}
