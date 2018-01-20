package ljx.ashin.thread.pool;

import ljx.ashin.thread.pool.MyRejectedExecutionHandler;

import java.util.concurrent.*;

/**
 * 自定义线程池
 * Created by AshinLiang on 2017/8/15.
 */
public class MyThreadPoolExecutoreTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(3);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,8,
                1*1000, TimeUnit.SECONDS,/*linkedBlockingQueue,*/arrayBlockingQueue, new MyRejectedExecutionHandler());

        MyTask task1 = new MyTask(1,"任务1");
        MyTask task2 = new MyTask(2,"任务2");
        MyTask task3 = new MyTask(3,"任务3");
        MyTask task4 = new MyTask(4,"任务4");
        MyTask task5 = new MyTask(5,"任务5");
        MyTask task6 = new MyTask(6,"任务6");
        MyTask task7 = new MyTask(7,"任务7");
        MyTask task8 = new MyTask(8,"任务8");
        MyTask task9 = new MyTask(9,"任务9");
        MyTask task10 = new MyTask(10,"任务10");
        MyTask task11 = new MyTask(11,"任务11");
        MyTask task12 = new MyTask(12,"任务12");
        MyTask task13 = new MyTask(13,"任务13");
        threadPoolExecutor.execute(task1);
        threadPoolExecutor.execute(task2);
        threadPoolExecutor.execute(task3);
        threadPoolExecutor.execute(task4);
        threadPoolExecutor.execute(task5);
        threadPoolExecutor.execute(task6);
        threadPoolExecutor.execute(task7);
        threadPoolExecutor.execute(task8);
        threadPoolExecutor.execute(task9);
        threadPoolExecutor.execute(task10);
        threadPoolExecutor.execute(task11);
        threadPoolExecutor.execute(task12);
        threadPoolExecutor.execute(task13);

        threadPoolExecutor.shutdown();
    }
}
