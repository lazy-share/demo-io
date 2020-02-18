package com.lazy.demo.io.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/13.
 */
public class FalseAsynTimeServerHandlerExecutePool {


    private ExecutorService executorService;

    public FalseAsynTimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        this.executorService = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize)
        );
    }

    public void execute(Runnable task) {
        executorService.execute(task);
    }
}
