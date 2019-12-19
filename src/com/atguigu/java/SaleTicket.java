package com.atguigu.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁在哪里  锁要在资源类里面
 */
class Ticket{
    private int number = 30;
    private Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 卖的是第"+(number--)+"张票还剩"+number+"张票");
        }finally {
            lock.unlock();
        }
    }
}

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            for (int i = 1; i <=30 ; i++) {
                threadPool.execute(() ->{ticket.sale();});
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
