package com.tt.demo.common;

import com.tt.demo.common.auth.AuthOperation;
import com.tt.demo.common.auth.AuthOperationResult;
import com.tt.demo.common.keepalive.KeepaliveOperation;
import com.tt.demo.common.keepalive.KeepaliveOperationResult;
import com.tt.demo.common.tv.TvOperation;
import com.tt.demo.common.tv.TvOperationResult;

import java.util.function.Predicate;

/**
 * 客户端发起操作类型
 *
 * @author hansiyuan
 * @date 2021年06月19日 16:51
 */
public enum OperationType {

    /**
     * 授权操作
     */
    AUTH(1, AuthOperation.class, AuthOperationResult.class),
    /**
     * 心跳操作
     */
    KEEPALIVE(2, KeepaliveOperation.class, KeepaliveOperationResult.class),
    /**
     * TV业务操作
     */
    ORDER(3, TvOperation.class, TvOperationResult.class);

    private final int opCode;
    private final Class<? extends Operation> operationClazz;
    private final Class<? extends OperationResult> operationResultClazz;

    OperationType(int opCode, Class<? extends Operation> operationClazz, Class<? extends OperationResult> responseClass) {
        this.opCode = opCode;
        this.operationClazz = operationClazz;
        this.operationResultClazz = responseClass;
    }

    public int getOpCode() {
        return opCode;
    }

    public Class<? extends Operation> getOperationClazz() {
        return operationClazz;
    }

    public Class<? extends OperationResult> getOperationResultClazz() {
        return operationResultClazz;
    }

    public static OperationType fromOpCode(int type) {
        return getOperationType(requestType -> requestType.opCode == type);
    }

    public static OperationType fromOperation(Operation operation) {
        return getOperationType(requestType -> requestType.operationClazz == operation.getClass());
    }

    private static OperationType getOperationType(Predicate<OperationType> predicate) {
        OperationType[] values = values();
        for (OperationType operationType : values) {
            if (predicate.test(operationType)) {
                return operationType;
            }
        }
        throw new AssertionError("no found type");
    }
}
