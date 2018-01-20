package ljx.ashin.thread;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟一个有限的缓冲区
 * 它支持put和take方法。 如果在一个空的缓冲区尝试一个take ，
 * 则线程将阻塞直到一个项目可用; 如果put试图在一个完整的缓冲区，
 * 那么线程将阻塞，直到空间变得可用。
 * Created by AshinLiang on 2017/8/3.
 */
public class BoundedBufferDemo {
    private final Lock lock = new ReentrantLock();
    //没有满的锁
    private final Condition condition1 = lock.newCondition();
    //不为空的锁
    private final Condition condition2 = lock.newCondition();
    //固定长度的
    private final Object[] boundBufferedArrays = new Object[5];

    private int count = 0;
    private int len = boundBufferedArrays.length;

    public boolean putDataToArray(Object object){
        //是否存放数据成功，默认不成功
        boolean isSuccess = false;

        try {
            lock.lock();

            while (count>=len-1){
                try {
                    //阻塞
                    condition1.await();
                    System.out.println(Thread.currentThread().getName()+"存放数据失败，缓存区已经满了，等待中");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boundBufferedArrays[count] = object;
            //计数器加一
            count++;
            //通知读方法可以取数据了
            condition2.signal();
            System.out.println(Thread.currentThread().getName()+"成功存放了数据:"+object);
            isSuccess = true;
        }finally {
            lock.unlock();
        }

        return isSuccess;
    }

    public Object getDataFromArray(){
        Object object = null;

        try {
            lock.lock();
            while (count==0){
                try {
                    //阻塞
                    condition2.await();
                    System.out.println(Thread.currentThread().getName()+"缓存区为空，等待数据存入");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //获取到缓存区的数据
            object = boundBufferedArrays[count-1];
            boundBufferedArrays[count-1] = null;
            //将计数器减一
            count--;
            condition1.signal();
            System.out.println(Thread.currentThread().getName()+"成功从缓存区拿到了数据");

        }finally {
            lock.unlock();
        }
        return object;
    }

    public static void main(String[] args) {
        final BoundedBufferDemo boundedBufferDemo = new BoundedBufferDemo();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            for (int i = 0; i < 10; i++) {
                                try {
                                    Thread.sleep(5*1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                boundedBufferDemo.putDataToArray(i);
                            }
                        }
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            for (int i = 0; i < 10; i++) {
                                try {
                                    Thread.sleep(1*1000);
                                    Object obj = boundedBufferDemo.getDataFromArray();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
        ).start();
    }
}
