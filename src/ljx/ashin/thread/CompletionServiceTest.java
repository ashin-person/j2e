package ljx.ashin.thread;

import java.util.concurrent.*;

/**
 * CompletionService将执行完的结果返回，不阻塞
 * Created by AshinLiang on 2017/7/30.
 */
public class CompletionServiceTest {
    public static void main(String[] args) throws Exception {

        //创建一个固定线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //将线程池传递给completionService
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);

        //开始提交10个任务
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //沉睡3秒
                    Thread.sleep(3*1000);
                    System.out.println("线程"+Thread.currentThread().getName()+"正在执行任务，taskId为:"+taskId);
                    //返回执行结果
                    return taskId;
                }
            });
        }
        System.out.println("提交完了任务");

        for (int i = 0; i < 10; i++) {
            //获取执行完的结果
            Integer result = completionService.take().get();
            System.out.println("执行完的结果:"+result);
        }
    }
}
