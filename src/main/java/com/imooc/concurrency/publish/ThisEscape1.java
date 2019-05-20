package com.imooc.concurrency.publish;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 通过内部类，使this逸出
 */
public class ThisEscape1 {
    private Set<Integer> set = new HashSet<>();

    public class Inner{
        public Set<Integer> doSomething(){   //外部类中的私有属性，通过内部类中的共有方法逃逸出去了
            return ThisEscape1.this.set;     //内部类中可以使用外部类的this
        }
    }

    public static void main(String[] args) {
        ThisEscape1 thisEscape1 = new ThisEscape1();
        Inner inner = thisEscape1.new Inner();
        Set<Integer> set = inner.doSomething();
    }
}
