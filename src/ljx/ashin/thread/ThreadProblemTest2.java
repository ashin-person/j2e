package ljx.ashin.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by AshinLiang on 2017/7/31.
 */
public class ThreadProblemTest2 {

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            MyShareData myShareData = new MyShareData();
                            myShareData.addMyData();
                        }
                    }
            ).start();
        }
    }

    static class MyShareData{
        private static Integer myData = 1;

        Lock lock = new ReentrantLock();

        public void addMyData(){
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"准备去读取MyData的id，读取前，值是:"+myData);
            try {
                Thread.sleep(3*1000);
                myData = myData +1;
                System.out.println(Thread.currentThread().getName()+"修改MyData的id，修改之后，值是:"+myData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                lock.unlock();
            }
        }
    }
}
