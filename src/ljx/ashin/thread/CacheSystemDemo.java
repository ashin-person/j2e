package ljx.ashin.thread;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 一个简单的缓存系统
 * Created by AshinLiang on 2017/7/31.
 */
public class CacheSystemDemo {

    public static void main(String[] args) {
        CacheSystemDemo cacheSystemDemo = new CacheSystemDemo();
        Object obj1 = cacheSystemDemo.getData("29");
        Object obj2 = cacheSystemDemo.getData("29");
    }
    private Map<String,Object> cacheMap = new HashMap<String, Object>();

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public Object getData(String id){

        try {
            lock.readLock().lock();
            //首先查询缓存中是否存在该数据
            Object result = cacheMap.get(id);
            if (result==null){
                lock.readLock().unlock();
                lock.writeLock().lock();
                try {
                    //模拟从数据库中获取值
                    result = new Random().nextInt();
                    System.out.println("从数据库中获取到值");
                    //将获取到的值放入缓存中
                    cacheMap.put(id,result);
                }finally {
                    lock.writeLock().lock();
                    System.out.println("在写锁中执行finally");
                }
                lock.readLock().lock();
            }else {
                System.out.println("从缓存中获取到值");
            }
            return result;

        }finally {
            lock.readLock().unlock();
            System.out.println("在读锁中执行finally");
        }
    }
}
