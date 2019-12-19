package com.atguigu.java;

import java.util.HashMap;
import java.util.Map;

class MyCache2 {
    private volatile Map <String, String> map = new HashMap <>();
    public void put(String key, String value) {
            System.out.println(Thread.currentThread().getName() + "\t 写入开始");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入结束");
    }

    public void get(String key) {
            System.out.println(Thread.currentThread().getName() + "\t 读取开始");
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取结束" + result);
    }
}

public class ReadWriteLockDemo2 {
    public  static void main(String[] args) {
        MyCache2 myCache = new MyCache2();
        for (int i = 1; i <= 10; i++) {
            final int tempI = i;
            new Thread(() -> {
                myCache.put(tempI + "", tempI + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 10; i++) {
            final int tempI = i;
            new Thread(() -> {
                myCache.get(tempI + "");
            }, String.valueOf(i)).start();
        }
    }
}



