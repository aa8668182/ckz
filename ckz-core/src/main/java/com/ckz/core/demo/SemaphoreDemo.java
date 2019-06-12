package com.ckz.core.demo;

import java.util.concurrent.Semaphore;

/**
 * @author: caikaizhen
 * @date: 2019/5/20 14:55
 * @Description:地铁或者火车站都有安检的地方，假设安检的屋子里只能容纳下10个人，当屋子里满了10个人的时候，安检的小姑娘会拿一个牌子把后边排队的人挡住，直到有人安检完从屋子里出来，后边排队的才可以继续跟进，但是无论如何，屋子里的人不能超过10个。假设每个人都是一个线程的话，安检小屋子就起到了一个限制并发执行线程数量的作用，也就是说，虽然有许多线程，但是只有在屋子里的线程才能并发执行，其余的线程只能等待屋子里的线程执行完成后才能进入屋子执行。
 *
 * 在一个线程执行完从屋子里退出的时候，有两种选择下一个线程进入安检屋子的方式，第一种是公平的，也就是谁先排的队，谁先进；第二种是随机的，就像挤公交车那样，谁运气好挤进去了算谁的，这种方式叫非公平的。
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("第" + num + "个线程执行任务");
                        Thread.sleep(5000L);    //休眠5秒钟
                        semaphore.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }).start();
        }
    }
}
