package com.imooc.concurrency.singleton;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */

import com.imooc.concurrency.annotion.NotRecomment;
import com.imooc.concurrency.annotion.ThreadSafe;

/**
 * 饿汉模式
 *
 * 在类加载的时候就进行实例化，容易造成加载过程慢。当没有使用这个类的时候，会造成资源浪费
 */
@ThreadSafe
@NotRecomment
public class SingletonExample1 {
    private static SingletonExample1 instance = new SingletonExample1();

    private SingletonExample1 (){

    }

    public static SingletonExample1 getInstance(){
        return instance;
    }
}
