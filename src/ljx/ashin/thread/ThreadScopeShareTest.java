package ljx.ashin.thread;

import java.util.Random;

/**
 * 线程范围内的共享变量数据的访问
 * Created by AshinLiang on 2017/7/26.
 */
public class ThreadScopeShareTest {

    public static int data;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    threadLocal.set(data);
                    System.out.println(Thread.currentThread().getName()+"产生的data的数据为:"+data);
                    ThreadA threadA = new ThreadA();
                    threadA.readDataMsg();
                    ThreadB threadB = new ThreadB();
                    threadB.readDataMsg();
                }
            }).start();
        }

    }

    static class ThreadA{
        public void readDataMsg(){
            System.out.println(Thread.currentThread().getName()+"ThreadA读取到共享的data为:"
                    +threadLocal.get()
//                    +data
            );
        }
    }

    static class ThreadB{
        public void readDataMsg(){
            System.out.println(Thread.currentThread().getName()+"ThreadB读取到共享的data为:"
                    +threadLocal.get()
//                    +data
            );
        }
    }
}
