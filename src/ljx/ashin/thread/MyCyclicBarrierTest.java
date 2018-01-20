package ljx.ashin.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by AshinLiang on 2017/8/5.
 */
public class MyCyclicBarrierTest {
    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //循环等待
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        //提交10个任务
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) Math.random()*1000);
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "即将到达集合地点1，当前已有" + cyclicBarrier.getNumberWaiting() + "个已经到达，正在等候");
                        cyclicBarrier.await();

                        Thread.sleep((long) Math.random()*1000);
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "即将到达集合地点2，当前已有" + cyclicBarrier.getNumberWaiting() + "个已经到达，正在等候");
                        cyclicBarrier.await();

                        Thread.sleep((long) Math.random()*1000);
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "即将到达集合地点3，当前已有" + cyclicBarrier.getNumberWaiting() + "个已经到达，正在等候");
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(runnable);
        }
        System.out.println("提交完了任务");
    }
}
