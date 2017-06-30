import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Contructor构造函数
 * Created by AshinLiang on 2017/6/23.
 */
public class ReflectTest {

    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        System.out.println("----------第一种方式------------");
        Constructor constructor = String.class.getConstructor(StringBuffer.class);
        String str = (String) constructor.newInstance(new StringBuffer("abc"));
        System.out.println(str);
        System.out.println("----------第二种方式------------");
        Constructor constructor1 = Class.forName("java.lang.String").getConstructor(StringBuffer.class);
        String str2 = (String) constructor1.newInstance(new StringBuffer("ashin"));
        System.out.println(str2);

        String str3 = String.class.newInstance();


    }
}
