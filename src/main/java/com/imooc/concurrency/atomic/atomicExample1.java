package com.imooc.concurrency.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
@Slf4j
public class atomicExample1 {
    private static AtomicLong atomicInteger = new AtomicLong(0);
    public static void main(String[] args) throws InterruptedException {
        int threadTotal = 50;
        int clientCount = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(clientCount);
        Semaphore semaphore = new Semaphore(threadTotal);

        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0 ; i < clientCount; i ++){
            executor.execute(() ->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("atomicInteger:" + atomicInteger);
        executor.shutdown();
    }

    private static void add(){
        atomicInteger.incrementAndGet();
    }
}
