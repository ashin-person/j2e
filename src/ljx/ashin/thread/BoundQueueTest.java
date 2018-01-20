package ljx.ashin.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列实现两个线程交互循环执行
 * Created by AshinLiang on 2017/8/6.
 */
public class BoundQueueTest {

    public static void main(String[] args) {
        Business business = new Business();
        business.subMethod();
        business.mainMethod();
    }

    static class Business{
        private static ArrayBlockingQueue<Integer> subArrayBlockingQueue = new ArrayBlockingQueue<Integer>(1);
        private static ArrayBlockingQueue<Integer> mainArrayBlockingQueue = new ArrayBlockingQueue<Integer>(1);

        static {
            try {
                //先向sub线程中放入一个值
                subArrayBlockingQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void subMethod(){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while (true){
                                try {
                                    subArrayBlockingQueue.take();
                                    for (int i = 0; i < 10; i++) {
                                        System.out.println("子线程循环"+Thread.currentThread().getName()+"正在执行:"+i);
                                    }
                                    mainArrayBlockingQueue.put(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }
            ).start();
        }

        public void mainMethod(){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while (true){
                                try {
                                    mainArrayBlockingQueue.take();
                                    for (int i = 0; i < 10; i++) {
                                        System.out.println("主线程循环"+Thread.currentThread().getName()+"正在执行:"+i);
                                    }
                                    subArrayBlockingQueue.put(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            ).start();
        }
    }
}
