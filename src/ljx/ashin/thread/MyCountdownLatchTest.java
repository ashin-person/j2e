package ljx.ashin.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟主线程发送命令之后，子线程收到3个命令之后，执行内容，全部内容执行完之后，通知主线程
 * Created by AshinLiang on 2017/8/6.
 */
public class MyCountdownLatchTest {

    //
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch1 = new CountDownLatch(1);
        final CountDownLatch countDownLatch2 = new CountDownLatch(3);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"准备接受命令");
                    //阻塞等待
                    countDownLatch2.await();

                    System.out.println("线程"+Thread.currentThread().getName()+"接受到了命令");
                    Thread.sleep(2*1000);
                    System.out.println("线程"+Thread.currentThread().getName()+"执行完了任务");
                    countDownLatch1.countDown();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //提交任务
        executorService.submit(runnable);
        System.out.println("向线程池中提交任务完成");
        for (int i = 0; i < 3; i++) {
            new Thread(

                    new Runnable() {
                        @Override
                        public void run() {
//                            int num = i;

                            try {
                                Thread.sleep(1 * 1000);
                                System.out.println("向子线程发送命令:" );
                                //计数器减一
                                countDownLatch2.countDown();
                                countDownLatch1.await();
                                System.out.println("子任务执行完了");

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
            ).start();
        }



    }

}
