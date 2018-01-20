package ljx.ashin.thread;

/**
 * Created by AshinLiang on 2017/8/8.
 */
public class VolatileThreadTest {

    static class MyData extends Thread{
        private volatile boolean flag = true;

        public void setFlag(boolean flag){
            this.flag = flag;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"正在执行任务");
            while (flag){

            }
            System.out.println(Thread.currentThread().getName()+"执行完成任务");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyData myData = new MyData();
        myData.start();
        Thread.sleep(1000);
        myData.setFlag(false);
        System.out.println("设置flag为false");
    }
}
