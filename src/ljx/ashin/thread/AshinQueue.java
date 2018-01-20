package ljx.ashin.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 使用synchronized、wait和notify实现一个阻塞队列
 * Created by AshinLiang on 2017/8/10.
 */
public class AshinQueue {

    //数组，为队列存放数据
    private final ArrayList<Object> list = new ArrayList<Object>();

    private int count = 0;//计数器
    private int minSize = 0;//存放的最小数据量
    private int maxSize;//最大的数据存放量

    private AshinQueue(int size){
        this.maxSize = size;
    }

    /**
     * 从队列中获取数据
     * @return
     */
    public Object take(){
        Object resultObj = null;

        synchronized (this){
            //如果队列为空，则阻塞等待
            while (count==0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //计数器加一
            count--;
            resultObj = list.get(count);
            list.remove(count);
            //通知put方法
            this.notify();
        }
        return resultObj;
    }

    /**
     * 将数据存入队列中
     * @param object
     * @return
     */
    public boolean put(Object object){
        boolean isSuccess = false;//是否成功存放的标志

        synchronized (this){
            //如果队列已经满，则不能存放
            while (count==maxSize){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //计数器加一
            count++;
            list.add(object);
            isSuccess = true;
            //通知取数据方法
            this.notify();
        }
        return isSuccess;
    }

    public static void main(String[] args) {
        final AshinQueue ashinQueue = new AshinQueue(5);

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(Thread.currentThread().getName()+"put"+i);
                            try {
                                Thread.sleep(2*1000);

                                boolean isSuccess = ashinQueue.put("ashin"+i);
                                System.out.println(Thread.currentThread().getName()+"存放数据成功"+isSuccess);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(Thread.currentThread().getName()+"take"+i);
                            try {
                                Thread.sleep(1*1000);

                                Object object = ashinQueue.take();
                                System.out.println(Thread.currentThread().getName()+"拿到的数据为:"+object);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();
    }

}
