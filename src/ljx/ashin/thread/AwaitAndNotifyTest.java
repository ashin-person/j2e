package ljx.ashin.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用await和notify实现通讯
 * Created by AshinLiang on 2017/8/9.
 */
public class AwaitAndNotifyTest {

    private List<Integer> accountList = new ArrayList<Integer>();
    private Integer account = 0;

    public void addNumToList(Integer account){
        accountList.add(account);
        System.out.println("添加了一个元素:"+account);
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public static void main(String[] args) {
        final AwaitAndNotifyTest awaitAndNotifyTest = new AwaitAndNotifyTest();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (awaitAndNotifyTest){
                            while (true){
                                try {
                                    Thread.sleep(2*1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("线程1:"+awaitAndNotifyTest.getAccount());
                                while (awaitAndNotifyTest.getAccount()==5||awaitAndNotifyTest.getAccount()==15){//5的时候，阻塞，并通知其他正在等待的线程
                                    try {
                                        awaitAndNotifyTest.notify();
                                        awaitAndNotifyTest.wait();


                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                awaitAndNotifyTest.account++;
                                System.out.println(Thread.currentThread().getName()+"正在执行任务"+awaitAndNotifyTest.getAccount());
                                awaitAndNotifyTest.addNumToList(awaitAndNotifyTest.getAccount());
                            }
                        }

                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (awaitAndNotifyTest){
                            while (true){
                                try {
                                    Thread.sleep(2*1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("线程2:"+awaitAndNotifyTest.getAccount());
                                boolean flag = awaitAndNotifyTest.getAccount()!=5;
                                System.out.println("flag = "+flag);
                                if (awaitAndNotifyTest.getAccount()!=5||awaitAndNotifyTest.getAccount()!=15){
                                    try {
                                        awaitAndNotifyTest.notify();
                                        awaitAndNotifyTest.wait();


                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                awaitAndNotifyTest.account++;
                                System.out.println(Thread.currentThread().getName()+"正在执行任务"+awaitAndNotifyTest.getAccount());
                                awaitAndNotifyTest.addNumToList(awaitAndNotifyTest.getAccount());
                            }
                        }
                    }
                }
        ).start();
    }
}
