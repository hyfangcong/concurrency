package com.imooc.concurrency.publish;

import lombok.Data;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
@Data
public class People {
    private String name;
    private int age;

    public People(String name, int age){
        this.name = name;
        this.age = age;
    }
}
