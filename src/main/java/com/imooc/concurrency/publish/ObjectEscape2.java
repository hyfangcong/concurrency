package com.imooc.concurrency.publish;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */

/**
 * 将类的私有成员变量的引用通过公有方法返回
 */
public class ObjectEscape2 {
    private String[] state = {"aaa", "bbb"};

    public String[] getState(){
        return state;            //对象逸出，私有成员变量state的引用被当作返回值提供给了外部的类
    }
}
