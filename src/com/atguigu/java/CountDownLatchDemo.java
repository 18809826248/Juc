package com.atguigu.java;

/**
 * CountDownLatchDemo
 * 火箭发射  5,4,3,2,1,0倒计时前面的都走了班长才可以走
 * 这个也是一种锁
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
       /* CountDownLatch countDownLatch = new CountDownLatch(100);*/
        for (int i = 1; i <=100; i++) {
            new Thread(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t 离开教室");
                   /* countDownLatch.countDown();*/
            },String.valueOf(i)).start();
        }
       /* try {
            countDownLatch.await();*/
            System.out.println(Thread.currentThread().getName()+"\t 班长走人");
       /* } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


    }
}
