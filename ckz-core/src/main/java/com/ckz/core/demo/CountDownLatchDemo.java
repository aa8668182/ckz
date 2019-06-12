package com.ckz.core.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author: caikaizhen
 * @date: 2019/5/20 14:25
 * @Description:CountDownLatch代表的是一个计数器，不论是否在同一线程中，不论线程是否执行完成，都可以随时随地调用CountDownLatch的countDown方法，而Thread的成员方法join只能在一个线程中对另一个线程对象调用，而且方法返回的前提是线程已经执行完成。
 * CountDownLatch对象不能被重复利用，也就是不能修改计数器的值。
 *
 * CountDownLatch代表的计数器的大小可以为0，意味着在一个线程调用await方法时会立即返回。
 *
 * 如果某些线程中有阻塞操作的话，最好使用带有超时时间的await方法，以免该线程调用await方法之后永远得不到执行。
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length); //创建CountDownLatch对象

        for (int i = 0; i < threads.length; i++) {

            int num = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000L);    //模拟耗时操作
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("第" + num + "个小任务执行完成");
                    countDownLatch.countDown(); //每个线程在执行完任务后，都调用这个方法
                }
            });
            threads[i] = t;
            t.start();
        }

        try {
            countDownLatch.await(); //在threads中线程都执行完成之前，此方法将阻塞
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("等待所有线程执行完成之后才执行");
    }
}
