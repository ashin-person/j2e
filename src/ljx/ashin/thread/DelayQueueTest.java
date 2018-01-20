package ljx.ashin.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用DelayQueue带有延迟时间的queue模拟一个网吧上网管理系统
 * 系统功能：
 * 1、登记上网的网民的姓名，身份证，网费
 * 2、时间到，提醒下线
 * Created by AshinLiang on 2017/8/11.
 */
public class DelayQueueTest {

    DelayQueue<Netizen> internetBar = new DelayQueue<Netizen>();

    /**
     * 开机上线
     * @param netizenList
     */
    public void onlineInternet(List<Netizen> netizenList){

        try {
            Thread.sleep(11000);
            for (Netizen netizen:netizenList){
                System.out.println("给网民"+netizen.getName()+"开机上网");
                internetBar.put(netizen);

            }
            System.out.println("开机：目前共有"+internetBar.size()+"人正在网吧上网");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 给网民下机
     */
    public void upLine(){
        try {
            Thread.sleep(11000);
            System.out.println("给网民"+internetBar.take().getName()+"下线");
            System.out.println("下线：目前共有"+internetBar.size()+"人正在网吧上网");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final DelayQueueTest delayQueueTest = new DelayQueueTest();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        List<Netizen> list = new ArrayList<Netizen>();
                        list.add(new Netizen(123,12,"ashin",12*1000));
                        list.add(new Netizen(124,14,"jack",14*1000));
                        list.add(new Netizen(125,2,"Mick",2*1000));
                        delayQueueTest.onlineInternet(list);
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            delayQueueTest.upLine();
                        }

                    }
                }
        ).start();

    }
}
