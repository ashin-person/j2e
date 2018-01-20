package ljx.ashin.thread;

/**
 * 多线程数据共享问题
 * Created by AshinLiang on 2017/7/28.
 */
public class MultiThreadShareDataTest {

    private static String connection = "sqlConnection";
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    A a = new A();
                    a.setOne(Thread.currentThread().getName()+"--开启事物");
                    a.setTwo(Thread.currentThread().getName()+"--关闭事物");
                    B b = new B();
                    b.printMsg();
                }
            }).start();
        }

    }

    static class A{
        public void setOne(String val){
            connection = connection + val;
//            threadLocal.set(connection+val);
        }

        public void setTwo(String val){
            connection = connection + val;
//            String connet = threadLocal.get()+val;
//            threadLocal.set(connet);

        }
    }

    static class B{
        public void printMsg(){
            System.out.println(Thread.currentThread().getName()+"==="
                    +connection
//                    +threadLocal.get()
            );
        }
    }
}
