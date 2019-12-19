package com.atguigu.java;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
       /* ExecutorService threadPool1= Executors.newFixedThreadPool(5);//一池固定数线程
        ExecutorService threadPoo2 = Executors.newSingleThreadExecutor();//一池一线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池一线程
*/
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        //一个银行已经new好了5个受理窗口，有5个工作人员
                try {
                    //一池5个工作人员，模拟有20 个客户来银行实体店办理业务
                    for (int i = 1; i <= 19; i++) {
                        final int tempI = i;
                            threadPool.execute(() ->{ System.out.println(Thread.currentThread().getName()+"\t 办理业务"+"\t 客户"+tempI); });
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            threadPool.shutdown();
                        }
    }
}
