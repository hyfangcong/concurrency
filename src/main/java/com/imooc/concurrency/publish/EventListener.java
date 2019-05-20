package com.imooc.concurrency.publish;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
public interface EventListener {
    void onEvent(Event e);
}
