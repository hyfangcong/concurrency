package com.imooc.concurrency.publish;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */

/**
 * 在构造函数中注册事件，致使this逸出。
 * 一般事件是异步的，因此在ThisEscape3没有构造完成的时候，出现了访问未被初始化的变量
 */
public class ThisEscape3 {

    private int value;
    public ThisEscape3(EventSource source){
        source.register(new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething();
            }
        });

        //初始化
        value = 1;
    }


    private void doSomething(){
        System.out.println(value);
    }
}
