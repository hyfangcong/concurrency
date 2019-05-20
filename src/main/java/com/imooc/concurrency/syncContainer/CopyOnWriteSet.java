package com.imooc.concurrency.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
@Slf4j
public class CopyOnWriteSet {

    static CopyOnWriteArrayList<Integer> set = new CopyOnWriteArrayList<>();
    static List<Integer> list = new ArrayList<>();

    static int threadCount = 50;
    static int clientCount = 5000;
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(threadCount);
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientCount);
        for(int i = 0 ;i < clientCount ; i++){
            final int count = i;
           executor.execute(() -> {
               try {
                   semaphore.acquire();
                   set.add(count);
                   list.add(count);
                   semaphore.release();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                   countDownLatch.countDown();
               }
           });
        }
        countDownLatch.await();
        log.info("{}", set.size());
        log.info("{}", list.size());

        executor.shutdown();
    }

}
