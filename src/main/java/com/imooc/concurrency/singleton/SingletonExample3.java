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
 * 使用内部类枚举， 利用jvm来保证线程安全。jvm保证只会允许一个线程去创建该实例。
 */
@ThreadSafe
@Recomment
public class SingletonExample3 {
    private SingletonExample3(){};


    public static SingletonExample3 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;
        private SingletonExample3 singleton;
        private Singleton(){
            singleton = new SingletonExample3();
        }
        public SingletonExample3 getInstance(){
            return singleton;
        }
    }
}
