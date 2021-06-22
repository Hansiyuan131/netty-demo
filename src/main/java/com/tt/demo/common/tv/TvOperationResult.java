package com.tt.demo.common.tv;

import com.tt.demo.common.OperationResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hansiyuan
 * @date 2021年06月19日 17:03
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TvOperationResult extends OperationResult {
    private final int tableId;
    private final String dish;
    private final boolean complete;
}
