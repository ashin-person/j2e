package ljx.ashin.thread;

import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by AshinLiang on 2017/8/10.
 */
public class AshinThreadLocalTest {

    private ThreadLocal<String> threadLocal = new ThreadLocal<String>();//本地线程域

    public void setData(){
        int num = new Random().nextInt();
        System.out.println(Thread.currentThread().getName()+"设置num的值为:"+num);
        threadLocal.set(""+num);
    }

    public String getData(){
        String result = "";

        result = threadLocal.get();
        System.out.println(Thread.currentThread().getName()+"得到的数据为:"+result);

        return result;
    }

    public static void main(String[] args) {
        final AshinThreadLocalTest ashinThreadLocalTest = new AshinThreadLocalTest();

        for (int i = 0; i < 5; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {

                            try {
                                Thread.sleep(1*1000);
                                ashinThreadLocalTest.setData();
                                Thread.sleep(1*1000);
                                String data = ashinThreadLocalTest.getData();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ).start();
        }


    }
}
