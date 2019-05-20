package com.imooc.concurrency.syncContainer;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author: fangcong
 * @date: 2019/5/19
 */
public class ContainerExamper1 {
    static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);

        //java.util.ConcurrentModificationException
        for(Integer i : vector){
            if(i == 2)
                vector.remove(i);
        }

        //java.util.ConcurrentModificationException
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            if(i == 1) {
                vector.remove(i);
            }
        }

        for(int i = 0 ;i < vector.size(); i ++){
            if(vector.get(i) == 1){
                vector.remove(i);
            }
        }
    }

}
