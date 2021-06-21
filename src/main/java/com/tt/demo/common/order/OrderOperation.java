package com.tt.demo.common.order;

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
public class OrderOperation extends Operation {

    private int tableId;
    private String dish;

    public OrderOperation(int tableId, String dish) {
        this.tableId = tableId;
        this.dish = dish;
    }

    @Override
    public OperationResult execute() {
        log.info("order's executing startup with orderRequest: " + toString());
        //execute order logic
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        log.info("order's executing complete");
        OrderOperationResult orderResponse = new OrderOperationResult(tableId, dish, true);
        return orderResponse;
    }
}
