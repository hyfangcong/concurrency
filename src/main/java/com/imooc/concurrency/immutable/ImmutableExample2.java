package com.imooc.concurrency.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */

/**
 * 构造不可以改变的集合
 * 利用java中collections中的unmodifiable的方法，同时也可使用Guava中的ImmutableMap等
 *
 * 他们的原理都是一样的，都是创建一个不可以修改的集合，把集合中可以改变集合状态的方法，
 * 都抛出UnsupportedOperationException
 */
@Slf4j
public class ImmutableExample2 {
    static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
    }
    public static void main(String[] args) {
        map = Collections.unmodifiableMap(map);
//        map.put(1,3);
//        map.put(5,6);

        log.info("{}",map.get(1));
    }
}
