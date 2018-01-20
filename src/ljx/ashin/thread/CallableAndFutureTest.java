package ljx.ashin.thread;

import java.util.concurrent.*;
/**
 * Callable和Future的使用
 * Created by AshinLiang on 2017/7/30.
 */
public class CallableAndFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //向线程池中提交任务,并获取到执行完的结果，封装到executResult中
        Future<Integer> executResults = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("正在执行任务。。。。");
                return 99;
            }
        });

        System.out.println("提交完任务");
        System.out.println("拿到任务执行完的结果:"+executResults.get());
    }
}
