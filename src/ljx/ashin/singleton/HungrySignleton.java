package ljx.ashin.singleton;

/**
 * 饿汉单例模式
 * Created by AshinLiang on 2017/7/27.
 */
public class HungrySignleton {
    //实例
    public static HungrySignleton instance = new HungrySignleton();
    //构造函数私有化
    private HungrySignleton(){};

    /**
     * 获取实例的静态方法
     * @return
     */
    public static HungrySignleton getInstance(){
        return instance;//类加载时已经初始化，不会有线程安全问题
    }
}
