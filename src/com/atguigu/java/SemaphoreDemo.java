package com.atguigu.java;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 这个三个同步(锁
 * )：
 * java.util.concurrent
 * java.util.concurrent.CountDownLatch
 *          倒数火箭发射
 * java.util.concurrent.CycliBarrier
 *           人到齐了才开会
 * java.util.concurrent.Semaphore
 *             抢车位 又来有回
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//3车位
        for (int i = 1; i <=6 ; i++) {//模拟6车抢车位
                    new Thread(() ->{
                        boolean flag = false;
                        try {
                            semaphore.acquire();//抢车位  不见不散 死等
                            flag = true;
                           // semaphore.release(10);       过时不候
                            System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                            try {
                                TimeUnit.SECONDS.sleep(3);//停了3秒
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName()+"\t 离开车位");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            if(flag){
                               semaphore.release();
                            }
                        }
                    },String.valueOf(i)).start();

                }

    }
}
