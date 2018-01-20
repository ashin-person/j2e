package ljx.ashin.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列的应用
 * Created by AshinLiang on 2017/8/11.
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws Exception{
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(6);

        arrayBlockingQueue.add("a");
        arrayBlockingQueue.add("b");
        arrayBlockingQueue.add("c");
        arrayBlockingQueue.add("d");
        arrayBlockingQueue.add("e");
        arrayBlockingQueue.add("f");
//        arrayBlockingQueue.put("g");
        arrayBlockingQueue.take();
//        arrayBlockingQueue.add("f");
        System.out.println(arrayBlockingQueue.size());

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>(2);
        linkedBlockingQueue.add("a");
        linkedBlockingQueue.add("b");
        linkedBlockingQueue.add("c");
        linkedBlockingQueue.add("d");
        linkedBlockingQueue.add("e");
        linkedBlockingQueue.add("f");
        System.out.println(linkedBlockingQueue.size());


    }
}
