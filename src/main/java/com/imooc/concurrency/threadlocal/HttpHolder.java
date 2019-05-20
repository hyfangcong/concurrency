package com.imooc.concurrency.threadlocal;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
public class HttpHolder {
    static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void add(Long vaule){
        threadLocal.set(vaule);
    }

    public static Long get(){
        return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }
}
