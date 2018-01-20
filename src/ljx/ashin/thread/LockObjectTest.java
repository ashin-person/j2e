package ljx.ashin.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁的使用：两个线程执行的代码片段要实现同步互斥的效果，它们必须用同一个Lock对象。
 * Created by AshinLiang on 2017/8/1.
 */
public class LockObjectTest {
    public static void main(String[] args) {
        //创建6个线程
        for (int i = 0; i < 6; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            final ShareData shareData = new ShareData();
                            shareData.modifyShareData();
                        }
                    }
            ).start();
        }
    }
    static class ShareData{
        private static Lock lock = new ReentrantLock();
        private static Integer myShareData = 0;
        public void modifyShareData(){
//            Lock lock = new ReentrantLock();
            try {
                lock.lock();
                System.out.println("线程"+Thread.currentThread().getName()+"读取到数据myShareData："+myShareData);
                Thread.sleep(3*1000);
                myShareData = myShareData + 1;
                System.out.println("线程"+Thread.currentThread().getName()+"将数据myShareData修改为："+myShareData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
