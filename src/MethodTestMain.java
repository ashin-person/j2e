import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Method反射类的应用
 * Created by AshinLiang on 2017/6/25.
 */
public class MethodTestMain {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
       Method method = String.class.getMethod("charAt", int.class);
       String str = "abc";
       char var = (char)method.invoke(str,2);
       System.out.println(var);

    }
}
