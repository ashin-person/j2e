package ljx.ashin.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by AshinLiang on 2017/8/6.
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        Collection<String> collection = new CopyOnWriteArrayList<String>();
//        Collection<String> collection = new ArrayList<String>();
        collection.add("张三");
        collection.add("李四");
        collection.add("王五");

        for (String s : collection){
            if ("张三".equals(s)){
                collection.remove(s);
            }
        }
        System.out.println(collection.size());
    }
}
