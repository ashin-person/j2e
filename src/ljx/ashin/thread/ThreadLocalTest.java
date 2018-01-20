package ljx.ashin.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 使用threadLocal实现线程范围内共享数据的安全访问
 * Created by AshinLiang on 2017/7/27.
 */
public class ThreadLocalTest {

//    private static int shareData;
    private static Map<Thread,Integer> hashMap = new HashMap<Thread, Integer>();
    public static void main(String[] args) {
//        int shareData ;

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int shareData = new Random().nextInt();//获取一个随机值
                    int myShareData = shareData;
                    System.out.println(Thread.currentThread().getName()+" 共享数据sharaData赋值为:"+shareData);
                    hashMap.put(Thread.currentThread(),shareData);
                    /*MyDataBean myDataBean1 = MyDataBean.getInstance();
                    myDataBean1.setMyData(shareData);*/
                    ModelA modelA = new ModelA();
                    modelA.printMsg(myShareData);
                    ModelB modelB = new ModelB();
                    modelB.printMsg(myShareData);
                }
            }).start();
        }
    }

    /**
     * 模拟模块A
     */
    static class ModelA{
//        int data = MyDataBean.getInstance().getMyData();
        int data = hashMap.get(Thread.currentThread());
        public void printMsg(int mydata){
            System.out.println(Thread.currentThread().getName()+" ModelA获取共享数据sharaData："+mydata);
        }
    }

    /**
     * 模拟模块B
     */
    static class ModelB{
//        int data = MyDataBean.getInstance().getMyData();
        int data = hashMap.get(Thread.currentThread());
        public void printMsg(int mydata){
            System.out.println(Thread.currentThread().getName()+" ModelB获取共享数据sharaData："+mydata);
        }
    }

    /**
     * 封装了本线程需要用到的数据的实体
     */
    static class MyDataBean{
        private MyDataBean(){};

        private int myData;
        private static ThreadLocal<MyDataBean> map = new ThreadLocal<MyDataBean>();

        public int getMyData() {
            return myData;
        }

        public void setMyData(int myData) {
            this.myData = myData;
        }

        private static MyDataBean instance = null;

        public static /*synchronized*/ MyDataBean getInstance(){
            instance = map.get();
            if(instance == null){
                instance = new MyDataBean();
                map.set(instance);
            }

            return instance;
        }
    }


}
