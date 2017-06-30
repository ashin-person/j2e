import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by AshinLiang on 2017/6/26.
 */
public class MethodUtils
{
    /**
     * 调用一个类的main方法
     * @param object
     */
    public static void callMain(Object object,Object[]params) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        Object[] types = new Object[]{};
        for(int i = 0 ;i <params.length;i++){
//            obj.getClass();
            types[i] = params[i].getClass();
        }

/*        Method method = object.getClass().getMethod("main",(Object)types);
        method.invoke(null,params);*/

    }
}
