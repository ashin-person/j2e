package ljx.ashin.thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁的使用
 * Created by AshinLiang on 2017/7/30.
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        final QueData queData = new QueData();

        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
//                            while (true){
                                try {
                                    while (true){
                                        queData.readData();
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
//                            }
                        }
                    }
            ).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (true){
                                    queData.writeData(new Random().nextInt());
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ).start();
        }
    }

    static class QueData{
        private Integer shareData = null;
        private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //读数据
        public void readData() throws InterruptedException {
            try {
                //加上读锁
                readWriteLock.readLock().lock();
                System.out.println("线程"+Thread.currentThread().getName()+"准备读取shareData数据");
                Thread.sleep(2*1000);
                System.out.println("线程"+Thread.currentThread().getName()+"读取到shareData的数据为:"+shareData);
            }finally {
                //解开读锁
                readWriteLock.readLock().unlock();
            }

        }

        //写数据
        public void writeData(int shareData) throws InterruptedException {
            readWriteLock.writeLock().lock();
            try {
                System.out.println("===线程"+Thread.currentThread().getName()+"准备修改shareData的数据"+"===");
                Thread.sleep(3*1000);
                this.shareData = shareData;
                System.out.println("===线程"+Thread.currentThread().getName()+"将shareData的数据修改为:"+shareData+"===");
            }finally {
                readWriteLock.writeLock().unlock();
            }
        }
    }
}
