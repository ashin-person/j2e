package ljx.ashin.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition实现多个线程协同操作
 * 线程1循环30遍
 * 线程2循环30遍
 * 如此反复
 * Created by AshinLiang on 2017/8/2.
 */
public class ConditionTest {
    public static Integer executeFlag = 1;//循环的标志，假设先从线程1开始

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        //线程1的条件阻塞
        final Condition condition1 = lock.newCondition();
        //线程2的条件阻塞
        final Condition condition2 = lock.newCondition();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            try {
                                lock.lock();
                                while (executeFlag!=1){
                                    try {
                                        condition1.await();
                                        System.out.println("不满足条件，线程1等待");
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                for (int i = 0; i < 10; i++) {
                                    System.out.println(Thread.currentThread().getName()+"线程1正在执行循环操作：  "+i);
                                }
                                System.out.println("通知线程2执行");
                                executeFlag =2;
                                condition2.signal();
                            }finally {
                                lock.unlock();
                            }
                        }
                    }
                }
        ).start();


        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        while (true){
                            try {
                                lock.lock();
                                while (executeFlag!=2){
                                    try {
                                        condition2.await();
                                        System.out.println("不满足条件，线程2等待");
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                for (int i = 0; i < 10; i++) {
                                    System.out.println(Thread.currentThread().getName()+"线程2正在执行循环操作：  "+i);
                                }
                                executeFlag = 1;
                                System.out.println("通知线程1执行");
                                condition1.signal();
                            }finally {
                                lock.unlock();
                            }
                        }

                    }
                }
        ).start();
    }
}
