package com.imooc.concurrency.publish;

import java.util.List;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
public class EventSource {
    List<EventListener> list;

    public void register(EventListener listener){
        this.list.add(listener);
    }

    public void publishd(Event event){
        for(EventListener listener : list){
            listener.onEvent(event);
        }
    }
}
