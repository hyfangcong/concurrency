package com.imooc.concurrency.publish;

import java.time.Period;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
public class ObjectEscape3 {
    private People people;

    public ObjectEscape3(People people){
        this.people = people;
    }

    public void studyItself(){
        //这里可以重新new一个people为newPeople，然后给它赋值，传递newPeople
        Enjoy.watchTV(people);   //对象逸出，通过参数逸出了。 在Enjoy中可以随意更改ObjectEscape3中的成员变量People的值
    }
}
