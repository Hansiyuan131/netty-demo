package com.tt.demo.common;

/**
 * @author hansiyuan
 * @date 2021年06月19日 17:18
 */
public class ResponseMessage extends Message<OperationResult> {
    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationResultClazz();
    }
}
