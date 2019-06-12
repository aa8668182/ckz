package com.ckz.core.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: caikaizhen
 * @date: 2019/5/20 14:52
 * @Description:从字面上理解，CyclicBarrier的意思就是循环利用的栅栏，CyclicBarrier对象内部也维护了一个类似计数器的东东，我们可以通过它的构造方法把计数器的值给传进去。每个线程在调用CyclicBarrier对象的await方法的时候，就相当于到达了多个线程共享的一个栅栏，该线程会在这个栅栏前等待，直到调用await方法的线程数量和计数器的值一样，该栅栏将被移除，因为await方法而等待的线程都恢复执行。
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        new Fighter(cyclicBarrier, "狗哥").start();
        new Fighter(cyclicBarrier, "猫爷").start();
        new Fighter(cyclicBarrier, "王尼妹").start();
        new Fighter(cyclicBarrier, "狗剩").start();
        new Fighter(cyclicBarrier, "张大嘴巴").start();
    }
}

class Fighter extends Thread{

    private CyclicBarrier cyclicBarrier;

    public Fighter(CyclicBarrier cyclicBarrier, String name) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);    //模拟上学中过程
            System.out.println(getName() + "放学了，向学校门跑去");

            cyclicBarrier.await();  //到达校门后等待，直到5个线程都执行到了这里

            System.out.println("人聚齐了，一起打架去喽～");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
