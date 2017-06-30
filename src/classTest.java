
/**
 * Class 字节码类
 * Created by AshinLiang on 2017/6/20.
 */
public class classTest {

    public static void main(String[] args){
        String str = "abc";
        Class strClass1 = str.getClass();
        Class strClass2 = String.class;
        try {
            Class strClass3 = Class.forName("java.lang.String");
            System.out.println(strClass1==strClass2);
            System.out.println(strClass2==strClass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
