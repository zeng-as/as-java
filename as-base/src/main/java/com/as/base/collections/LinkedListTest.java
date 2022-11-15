package com.as.base.collections;

import java.util.LinkedList;

/**
 * @author as
 * @date 2022/8/26
 * @desc
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                linkedList.add(i);
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 肯定不是线程安全的啦，size、first、last、modCount的操作均为竞争使用
        System.out.println(linkedList.size());
    }
}
