package ljx.ashin.thread;

/**
 * Created by AshinLiang on 2017/8/7.
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        final MyData myData = new MyData();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        myData.method1();
                    }
                }
        ).start();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        myData.method2();
                    }
                }
        ).start();
    }
    static class MyData{
        private int num=100;
        public synchronized void method1(){
            try {
                num = 500;
                System.out.println(Thread.currentThread().getName()+"将数据修改为："+num);
                System.out.println(Thread.currentThread().getName()+"正在执行任务"+num);
                Thread.sleep(6*1000);
                System.out.println(Thread.currentThread().getName()+"执行完了任务"+num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public synchronized void method2(){
            num = 600;
            System.out.println(Thread.currentThread().getName()+"将数据修改为："+num);
        }
    }
}
