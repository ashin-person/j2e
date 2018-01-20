package ljx.ashin.thread;
/**
 * 搞清楚什么情况下会产生多线程并发的问题
 * Created by AshinLiang on 2017/7/31.
 */
public class ThreadProblemTest {
    public static void main(String[] args) {
        final MyData myData = new MyData();
        for (int i = 0; i < 6; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            myData.addMyDataNum();
                        }
                    }
            ).start();
        }
    }

    static class MyData{
        private Integer id = 0;
        public void addMyDataNum(){
            /*if (id==null){
                id = id +1;
            }*/
            synchronized (MyData.class){
                System.out.println(Thread.currentThread().getName()+"准备去读取MyData的id，读取前，值是:"+id);
                try {
                    Thread.sleep(3*1000);
                    id = id +1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"修改MyData的id，修改之后，值是:"+id);
            }
        }
    }
}
