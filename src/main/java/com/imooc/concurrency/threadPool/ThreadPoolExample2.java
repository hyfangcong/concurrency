package com.imooc.concurrency.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: fangcong
 * @date: 2019/5/20
 */
@Slf4j
public class ThreadPoolExample1 {
    static ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) {
        for(int i = 0 ; i < 5 ; i++){
            final int index = i;
            service.scheduleAtFixedRate(() ->{
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("schedule run{}", index);
            }, 0, 3, TimeUnit.SECONDS);
        }
    }
}
