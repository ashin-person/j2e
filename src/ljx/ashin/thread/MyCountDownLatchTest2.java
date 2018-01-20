package ljx.ashin.thread;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch作为线程之间执行顺序的控制器
 * Created by AshinLiang on 2017/8/15.
 */
public class MyCountDownLatchTest2 {

    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(2);

        //主线程的任务
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println(Thread.currentThread().getName()+"准备执行主线程的任务");
                            System.out.println(Thread.currentThread().getName()+"必须要先执行完其他线程才能执行主线程");
                            //阻塞
                            countDownLatch.await();
                            System.out.println(Thread.currentThread().getName()+"正在执行主线程的任务");
                            Thread.sleep(2*1000);
                            System.out.println(Thread.currentThread().getName()+"执行完了主线程的任务");
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        //子线程1的任务
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        try {
                            System.out.println(Thread.currentThread().getName()+"正在执行子线程1的任务， 初始化。。。。");
                            Thread.sleep(2*1000);
                            System.out.println(Thread.currentThread().getName()+"执行完子线程1的任务");
                            countDownLatch.countDown();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        //子线程1的任务
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        try {
                            System.out.println(Thread.currentThread().getName()+"正在执行子线程2的任务， 初始化。。。。");
                            Thread.sleep(2*1000);
                            System.out.println(Thread.currentThread().getName()+"执行完子线程2的任务");
                            countDownLatch.countDown();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

    }
}
