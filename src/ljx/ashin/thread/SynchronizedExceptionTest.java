package ljx.ashin.thread;

/**
 * Created by AshinLiang on 2017/8/7.
 */
public class SynchronizedExceptionTest {

    public static void main(String[] args) {
        final MyData myData = new MyData();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        myData.printMsg(10);
                    }
                }
        ).start();
    }

    static class MyData{
        private int num = 10;

        public void printMsg(int num){

                this.num = num;
                while (true){


                    try {
                        Thread.sleep(1*1000);
                        --num;
                        if (7==num){
                            /*throw new RuntimeException();*/
                            Integer.parseInt("a");
                        }
                        System.out.println(Thread.currentThread().getName()+"执行任务，num为:"+num);

                    }catch (InterruptedException e){
                        e.printStackTrace();
//                        throw new RuntimeException();
//                        continue;
                    }
//                e.printStackTrace();
                        /*System.out.println("执行到num="+num+"时，出错了，"+e.getMessage());
                        throw new RuntimeException();
                        continue;}*/
                }
        }


    }
}
