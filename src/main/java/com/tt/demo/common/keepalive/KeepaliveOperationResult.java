package com.tt.demo.common.keepalive;

import com.tt.demo.common.OperationResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hansiyuan
 * @date 2021年06月19日 17:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class KeepaliveOperationResult extends OperationResult {
    private final long time;
}
