package com.tt.demo.common;

/**
 * 客户端发起操作
 *
 * @author hansiyuan
 * @date 2021年06月19日 16:52
 */
public abstract class Operation extends MessageBody {
    public abstract OperationResult execute();
}
