package ljx.ashin.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁与Synchronized
 * Created by AshinLiang on 2017/7/30.
 */
public class LockTest {

    static InnserClassPrintMsg innserClassPrintMsg = new InnserClassPrintMsg();


    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        lockTest.init();

    }

    public void init(){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            /*try {
                                Thread.sleep(1*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                            innserClassPrintMsg.printMsg("aiyigerenhennan");
                        }
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                           /* try {
                                Thread.sleep(3*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                            innserClassPrintMsg.printMsg("shifengshiliburuni");
                        }
                    }
                }
        ).start();


    }

    static class InnserClassPrintMsg{
        Lock lock = new ReentrantLock();
        public void printMsg(String msg){
            lock.lock();
            try{
                if(null!=msg){
                    int len = msg.length();
                    for (int i = 0; i < len; i++) {
                        System.out.print(msg.charAt(i));
                    }
                    System.out.println("");
                }
            }finally {
                lock.unlock();
            }
        }

    }
}
