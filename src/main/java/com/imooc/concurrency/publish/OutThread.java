package com.imooc.concurrency.publish;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
public class OutThread extends Thread {
    private ThisEscape2 thisEscape2;
    public OutThread(ThisEscape2 thisEscape2){
        this.thisEscape2 = thisEscape2;
    }
    @Override
    public void run() {
        thisEscape2.doSomething();
    }
}
