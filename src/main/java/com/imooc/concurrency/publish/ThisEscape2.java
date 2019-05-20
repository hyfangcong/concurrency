package com.imooc.concurrency.publish;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */

/**
 * 在构造函数中发生this逃逸，使还没有构造完成的对象，发布给了外部
 *
 * 在构造函数中启动了线程（避免在构造函数中启动线程）
 */
public class ThisEscape2 {
    private int value = 1;

    public ThisEscape2() throws InterruptedException {
        OutThread thread = new OutThread(this);  //this逃逸了
        thread.start();

        //一些初始化的工作
        Thread.sleep(100);

        this.value = 2;   //构造函数还没有执行完成
    }

    public void doSomething(){
        System.out.println(value);
    }

    public static void main(String[] args) throws InterruptedException {
        ThisEscape2 tt = new ThisEscape2();
    }
}
