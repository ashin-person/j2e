import java.lang.reflect.Field;

/**
 * Created by AshinLiang on 2017/6/24.
 */
public class ReflectTestMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Student student = new Student(23,234);
        Field agetField = student.getClass().getDeclaredField("age");
        agetField.setAccessible(true);
        int age = (int)agetField.get(student);
        System.out.println(""+age);

        Field numtField = student.getClass().getField("num");
        int num = (int)numtField.get(student);
        System.out.println(""+num);

    }



}
