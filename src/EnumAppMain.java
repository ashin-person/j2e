import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by AshinLiang on 2017/6/26.
 */
public class EnumAppMain {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        AppMain enumAppMain = new AppMain();
        //普通方式调用
        AppMain.main(new String[]{"asdf"});
        //反射方式访问
        Method appMainMehod = AppMain.class.getMethod("main", String[].class);
        appMainMehod.invoke(enumAppMain,new Object[]{new String[]{"ashin"}} );
    }
}
