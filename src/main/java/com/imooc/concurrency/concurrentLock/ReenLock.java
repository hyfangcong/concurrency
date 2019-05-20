package com.imooc.concurrency.concurrentLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
@Slf4j
public class ReenLock {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    FutureTask
    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            log.info("释放锁");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("重新获取到锁");
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            log.info("获取到锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signal();
            lock.unlock();
        }).start();
    }
}
