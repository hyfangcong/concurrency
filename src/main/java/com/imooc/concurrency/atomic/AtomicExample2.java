package com.imooc.concurrency.atomic;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
@Slf4j
public class AtomicExample2 {


    @Getter
    public volatile int count = 0;
    static AtomicIntegerFieldUpdater<AtomicExample2> updater = AtomicIntegerFieldUpdater
            .newUpdater(AtomicExample2.class, "count");

    public static void main(String[] args) {
        AtomicExample2 atomicExample2 = new AtomicExample2();
        if(updater.compareAndSet(atomicExample2, 0,10)){
            log.info("count:{}",atomicExample2.getCount());
        }
    }
}
