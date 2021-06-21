package com.tt.demo.common.keepalive;

import com.tt.demo.common.Operation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hansiyuan
 * @date 2021年06月19日 17:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class KeepaliveOperation  extends Operation {
    private long time;

    public KeepaliveOperation() {
        this.time = System.nanoTime();
    }

    @Override
    public KeepaliveOperationResult execute() {
        KeepaliveOperationResult orderResponse = new KeepaliveOperationResult(time);
        return orderResponse;
    }
}
