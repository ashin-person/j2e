package ljx.ashin.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
/**
 * 使用semaphore信号灯作为限流
 * Created by AshinLiang on 2017/8/16.
 */
public class SemaphoreLimitTest {
    public static void main(String[] args) {
        //控制并发访问的最大值是5
        final Semaphore semaphore = new Semaphore(5);

        final int shareNum = 0;
        for (int i = 0; i < 20; i++) {
            final int count = i;
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //获取许可
                                semaphore.acquire();
                                System.out.println("第"+count+"个  "+Thread.currentThread().getName()+"获取到了许可，正在访问shareNum:"+shareNum);
                                Thread.sleep(new Random().nextInt(10)*1000);
                                System.out.println("第"+count+"个  "+Thread.currentThread().getName()+"执行完了任务，将释放许可");
                                //释放许可
                                semaphore.release();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ).start();
        }
    }
}
