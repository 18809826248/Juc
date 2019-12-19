package com.atguigu.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 获取线程的有几种方法？
 * 4中
 * 继承 thread类  实现runable接口  实现callable接口  线程池中获取
 *          runbale 和  callable不同点  方法名字不同 一个是run  一个是call
 *          有无返回值  runable没有  callable有
 *          抛不抛异常   runable没有   callable有
 *          FutureTask futureTask = new FutureTask(new MyThread());
 *
 */

class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("1234");
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }



}
