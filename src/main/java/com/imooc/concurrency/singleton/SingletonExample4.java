package com.imooc.concurrency.singleton;

import com.imooc.concurrency.annotion.Recomment;
import com.imooc.concurrency.annotion.ThreadSafe;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */

/**
 * 懒汉模式
 *
 * 使用静态内部类， 利用jvm来保证线程安全。jvm保证只会允许一个线程去创建该实例。
 */
@ThreadSafe
@Recomment
public class SingletonExample4 {
    private SingletonExample4 (){}

    public static SingletonExample4 getInstance(){
        return Singleton.instance;
    }

    private static class Singleton{
        private static SingletonExample4 instance = new SingletonExample4();
    }
}
