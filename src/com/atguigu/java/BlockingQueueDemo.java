package com.atguigu.java;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 */

public class BlockingQueueDemo {
    public static void main(String[] args)throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        //进队
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        System.out.println("111111111");
       /* blockingQueue.put("x");
        System.out.println("222222222");
*/
        //打印出a为什么 因为队列是先进先出
       /*System.out.println(blockingQueue.offer("xxxxx"));
        System.out.println(blockingQueue.peek());*/
        //出队
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

    }

}
