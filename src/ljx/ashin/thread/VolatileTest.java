package ljx.ashin.thread;

/**
 * volatile关键字的使用
 * Created by AshinLiang on 2017/8/8.
 */
public class VolatileTest {

    private boolean flag = true;

    /**
     * 设置值
     * @param flag
     */
    public void setFlag(boolean flag){
        this.flag = flag;
    }

    public void printMsg(){
        System.out.println(Thread.currentThread().getName()+"正在执行任务");
        while (flag){

        }
        System.out.println(Thread.currentThread().getName()+"结束任务");
    }

    public static void main(String[] args) {
        final VolatileTest volatileTest = new VolatileTest();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        volatileTest.printMsg();
                    }
                }
        ).start();
        volatileTest.setFlag(false);
        System.out.println("false的值为:"+false);
    }

}
