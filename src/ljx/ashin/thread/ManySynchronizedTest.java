package ljx.ashin.thread;

/**
 * 多重锁的问题
 * Created by AshinLiang on 2017/8/7.
 */
public class ManySynchronizedTest {
    public static void main(String[] args) {
        MyData myData = new MyData();
        myData.subMethod();
    }
    static class MyData{
        private int num = 10;
        public synchronized void mainMethod(){
            --num;
            System.out.println("mainMethod方法中的num为:"+num);
        }
        public synchronized void subMethod(){

            while (num>0){
                --num;
                System.out.println("subMethod方法中的num为:"+num);
                mainMethod();
            }
        }
    }
}
