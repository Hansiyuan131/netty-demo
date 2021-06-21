package com.tt.demo.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * StreamId生成
 *
 * @author hansiyuan
 * @date 2021年06月19日 17:20
 */
public class IdUtil {
    private static final AtomicLong IDX = new AtomicLong();

    private IdUtil() {
    }

    public static long nextId() {
        return IDX.incrementAndGet();
    }
}
