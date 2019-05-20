package com.imooc.concurrency.singleton;

import com.imooc.concurrency.annotion.ThreadSafe;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */

/**
 * 懒汉模式
 *
 * 使用volatile + lock 双重同步检测 来保证线程安全
 *
 *  jvm构造一个对象的时候可以分为以下几步：
 *   1. memory = allocate()  分配内存对象
 *   2. ctorInstance（） 初始化对象
 *   3.instance = memory 设置instance指向刚才分配的内存
 *
 *   jvm和cpu可能会进行指令重排序
 *   1
 *   3
 *   2
 *   这时候有可能会拿到一个没有被初始化的对象。  因此需要使用volatile修饰，禁止重排序
 */
@ThreadSafe
public class SingletonExample2 {

    private volatile static SingletonExample2 instance = null;
    private SingletonExample2 (){}

    public static SingletonExample2 getInstance(){
        if(instance == null){
            synchronized (SingletonExample2.class){
                if(instance == null)
                    instance = new SingletonExample2();
            }
        }
        return instance;
    }
}
