package com.tt.demo.common.tv;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tt.demo.common.Operation;
import com.tt.demo.common.OperationResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author hansiyuan
 * @date 2021年06月19日 17:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class TvOperation extends Operation {

    private int tableId;
    private String dish;

    public TvOperation(int tableId, String dish) {
        this.tableId = tableId;
        this.dish = dish;
    }

    @Override
    public OperationResult execute() {
        log.info("TV相关操作开始执行 " + toString());
        //execute tv logic
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        log.info("TV相关操作执行完成");
        TvOperationResult tvResponse = new TvOperationResult(tableId, dish, true);
        return tvResponse;
    }
}
