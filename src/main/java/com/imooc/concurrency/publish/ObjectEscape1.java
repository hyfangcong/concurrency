package com.imooc.concurrency.publish;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */

/**
 * 例子中发布的对象为set，如果set添加元素，则这些元素也被发布。在这里发布的意思就是在当前作用域中(intitialize方法体中)
 * set对象的引用保存在knownSecret中，这样就可以在当前作用域外通过knownSecret引用操纵set对象，包括set中的元素。
 *
 */
public class ObjectEscape1 {
    public static Set<Secret> knowSecret;
    public void init(){
        Set<Secret> set = new HashSet<>();
        knowSecret = set;
    }
}
