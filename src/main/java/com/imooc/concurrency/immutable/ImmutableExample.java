package com.imooc.concurrency.immutable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
public class ImmutableExample {
    private final Integer a = 1;
    private final String s = "qq";

    /**
     * 一般不会去修饰一个引用类型。map不可以指向其他的引用，但是可以改变引用所指向的对象
     */
    private final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        ImmutableExample tt = new ImmutableExample();
//        tt.a = 2;
////        tt.s = "rrr";
////        tt.map = new HashMap<>();

        tt.map.put(1,2);
    }
}
