package ljx.ashin.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by AshinLiang on 2017/8/5.
 */
public class MySemaphoreTest {
    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        //大小为3的信号灯
        final Semaphore semaphore = new Semaphore(3);

        //向线程池中提交任务
        for (int i = 0; i < 10; i++) {
            final int num = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可证
                        semaphore.acquire();
                        Thread.sleep(3*1000);
                        System.out.println(Thread.currentThread().getName()+"执行具体的任务 "+num);
                        System.out.println("目前共有"+(3-semaphore.availablePermits())+"个任务正在执行");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //释放许可
                        System.out.println(Thread.currentThread().getName()+"准备释放许可"+num);
                        semaphore.release();
                    }
                }
            };
            executorService.submit(runnable);
        }
        System.out.println("提交完了10个任务");
    }
}
