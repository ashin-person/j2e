package ljx.ashin.thread;

/**
 * Created by AshinLiang on 2017/8/7.
 */
public class MultiThreadTest {

    public static void main(String[] args) {
        final MyData myData1 = new MyData();
        final MyData myData2 = new MyData();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        myData1.printMsg("a");
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        myData2.printMsg("b");
                    }
                }
        ).start();
    }

    static class MyData{
        private static int num = 10;

        public static synchronized void printMsg(String str){

            if ("a".equals(str)){
                num = 100;
                System.out.println(Thread.currentThread().getName()+"即将执行任务");
                try {
                    Thread.sleep(3*1000);
                    System.out.println(Thread.currentThread().getName()+"tag:"+str+"正在执行完了任务"+num);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if ("b".equals(str)){
                num = 500;
                System.out.println(Thread.currentThread().getName()+"即将执行任务");
                try {
                   /* Thread.sleep(3*1000);*/
                    System.out.println(Thread.currentThread().getName()+"tag:"+str+"正在执行任务"+num);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName()+"tag:"+str+"执行完了任务");

        }
    }
}
