package ljx.ashin.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 线程池的概念，初始使用executors
 * Created by AshinLiang on 2017/7/29.
 */
public class ThreadPoolExecutorsTest {

    public static void main(String[] args) {
        //创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Executors.newCachedThreadPool();

        System.out.println("===开始提交10个任务===");
        for (int i = 0; i < 10; i++) {
            final int taskNum = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println("==="+Thread.currentThread().getName()+" 正在执行任务:"+taskNum+" "+"的第"+j+"次===");
                    }

                }
            });
        }
        System.out.println("===提交完了所有的任务===");
        executorService.shutdown();
    }
}
